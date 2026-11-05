package com.deepoove.poi.render.processor;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigInteger;

public class NumberingContinueupdateNumbering_XWPFNumberingaddAbstractNumFikaTest {

    @Test
    public void testUpdateNumbering() throws Exception {
        XWPFDocument document = Mockito.mock(XWPFDocument.class);
        XWPFNumbering numbering = Mockito.mock(XWPFNumbering.class);
        XWPFParagraph source = Mockito.mock(XWPFParagraph.class);
        XWPFParagraph target = Mockito.mock(XWPFParagraph.class);
        
        Mockito.when(source.getDocument()).thenReturn(document);
        Mockito.when(document.getNumbering()).thenReturn(numbering);
        
        BigInteger mockNumID = BigInteger.valueOf(1);
        Mockito.when(source.getNumID()).thenReturn(mockNumID);
        
        org.apache.poi.xwpf.usermodel.XWPFNum mockNum = Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFNum.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum mockCTNum = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber mockAbstractNumId = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber.Factory.newInstance();
        mockAbstractNumId.setVal(BigInteger.valueOf(2));
        mockCTNum.setAbstractNumId(mockAbstractNumId);
        Mockito.when(mockNum.getCTNum()).thenReturn(mockCTNum);
        Mockito.when(numbering.getNum(mockNumID)).thenReturn(mockNum);
        
        XWPFAbstractNum mockAbstractNum = Mockito.mock(XWPFAbstractNum.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum mockCTAbstractNum = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum.Factory.newInstance();
        Mockito.when(mockAbstractNum.getAbstractNum()).thenReturn(mockCTAbstractNum);
        Mockito.when(numbering.getAbstractNum(BigInteger.valueOf(2))).thenReturn(mockAbstractNum);
        
        Mockito.when(numbering.addAbstractNum(Mockito.any(XWPFAbstractNum.class))).thenReturn(BigInteger.valueOf(3));
        Mockito.when(numbering.addNum(BigInteger.valueOf(3))).thenReturn(BigInteger.valueOf(4));
        
        NumberingContinue numberingContinue = new NumberingContinue();
        numberingContinue.updateNumbering(source, target);
    }
}
