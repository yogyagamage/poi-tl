package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.XWPFNumberingWrapper;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class NumberingContinueupdateNumbering_XWPFNumberingaddAbstractNumFikaTest {

    @Test
    public void testUpdateNumbering() throws Exception {
        // Create real instance of class under test
        NumberingContinue numberingContinue = new NumberingContinue();
        
        // Create mock XWPFParagraph for source
        XWPFParagraph sourceParagraph = Mockito.mock(XWPFParagraph.class);
        XWPFParagraph targetParagraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock XWPFDocument
        XWPFDocument mockDocument = Mockito.mock(XWPFDocument.class);
        when(sourceParagraph.getDocument()).thenReturn(mockDocument);
        
        // Create real XWPFNumbering (needs to be real to call addAbstractNum)
        XWPFNumbering numbering = Mockito.mock(XWPFNumbering.class);
        when(mockDocument.getNumbering()).thenReturn(numbering);
        
        // Setup source paragraph to have a numID
        BigInteger sourceNumID = BigInteger.valueOf(1);
        when(sourceParagraph.getNumID()).thenReturn(sourceNumID);
        
        // Setup numbering to return a num for the sourceNumID
        XWPFNum mockNum = Mockito.mock(XWPFNum.class);
        when(numbering.getNum(sourceNumID)).thenReturn(mockNum);
        
        // Setup the CTNum to have an abstractNumId
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum ctNum = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber abstractNumId = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber.Factory.newInstance();
        abstractNumId.setVal(BigInteger.valueOf(2));
        ctNum.setAbstractNumId(abstractNumId);
        when(mockNum.getCTNum()).thenReturn(ctNum);
        
        // Setup numbering to return an abstractNum
        XWPFAbstractNum mockAbstractNum = Mockito.mock(XWPFAbstractNum.class);
        when(numbering.getAbstractNum(BigInteger.valueOf(2))).thenReturn(mockAbstractNum);
        
        // Setup the CTAbstractNum to be copied
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum ctAbstractNum = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum.Factory.newInstance();
        when(mockAbstractNum.getAbstractNum()).thenReturn(ctAbstractNum);
        
        // Setup XWPFNumberingWrapper to return a nextAbstractNumID
        XWPFNumberingWrapper mockWrapper = Mockito.mock(XWPFNumberingWrapper.class);
        when(mockWrapper.getNextAbstractNumID()).thenReturn(BigInteger.valueOf(3));
        
        // Mock the static behavior indirectly by ensuring the path reaches addAbstractNum
        when(numbering.addAbstractNum(Mockito.any(XWPFAbstractNum.class))).thenReturn(BigInteger.valueOf(4));
        when(numbering.addNum(BigInteger.valueOf(4))).thenReturn(BigInteger.valueOf(5));
        
        // Call the entry point method
        numberingContinue.updateNumbering(sourceParagraph, targetParagraph);
    }
}
