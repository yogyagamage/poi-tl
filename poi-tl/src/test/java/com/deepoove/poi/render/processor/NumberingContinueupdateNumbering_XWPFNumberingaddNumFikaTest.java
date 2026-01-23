package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.XWPFNumberingWrapper;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNum;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberingContinueupdateNumbering_XWPFNumberingaddNumFikaTest {

    @Test
    public void testUpdateNumbering() throws Exception {
        // Create the class under test
        NumberingContinue numberingContinue = new NumberingContinue();
        
        // Create source paragraph mock
        XWPFParagraph sourceParagraph = mock(XWPFParagraph.class);
        
        // Create target paragraph mock
        XWPFParagraph targetParagraph = mock(XWPFParagraph.class);
        
        // Create document mock
        XWPFDocument document = mock(XWPFDocument.class);
        when(sourceParagraph.getDocument()).thenReturn(document);
        
        // Create numbering mock
        XWPFNumbering numbering = mock(XWPFNumbering.class);
        when(document.getNumbering()).thenReturn(numbering);
        
        // Setup source paragraph to have a numID
        BigInteger sourceNumID = BigInteger.valueOf(1);
        when(sourceParagraph.getNumID()).thenReturn(sourceNumID);
        
        // Setup numbering to return a valid XWPFNum
        XWPFNum num = mock(XWPFNum.class);
        when(numbering.getNum(sourceNumID)).thenReturn(num);
        
        // Setup CTNum for the XWPFNum
        CTNum ctNum = CTNum.Factory.newInstance();
        CTDecimalNumber abstractNumId = ctNum.addNewAbstractNumId();
        abstractNumId.setVal(BigInteger.valueOf(2));
        when(num.getCTNum()).thenReturn(ctNum);
        
        // Setup numbering to return a valid XWPFAbstractNum
        XWPFAbstractNum abstractNum = mock(XWPFAbstractNum.class);
        when(numbering.getAbstractNum(BigInteger.valueOf(2))).thenReturn(abstractNum);
        
        // Setup CTAbstractNum for the XWPFAbstractNum
        CTAbstractNum ctAbstractNum = CTAbstractNum.Factory.newInstance();
        ctAbstractNum.setAbstractNumId(BigInteger.valueOf(2));
        when(abstractNum.getAbstractNum()).thenReturn(ctAbstractNum);
        
        // Setup numbering to return a new abstractNumID
        BigInteger newAbstractNumID = BigInteger.valueOf(3);
        when(numbering.addAbstractNum(org.mockito.ArgumentMatchers.any(XWPFAbstractNum.class)))
            .thenReturn(newAbstractNumID);
        
        // Setup numbering to return a new numID when addNum is called
        BigInteger newNumId = BigInteger.valueOf(4);
        when(numbering.addNum(newAbstractNumID)).thenReturn(newNumId);
        
        // Execute the entry point method
        numberingContinue.updateNumbering(sourceParagraph, targetParagraph);
    }
}
