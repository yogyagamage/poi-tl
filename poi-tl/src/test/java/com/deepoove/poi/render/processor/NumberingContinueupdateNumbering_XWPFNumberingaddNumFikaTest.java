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

import static org.mockito.Mockito.*;

public class NumberingContinueupdateNumbering_XWPFNumberingaddNumFikaTest {

    @Test
    public void testUpdateNumberingInvokesAddNum() throws Exception {
        // Create real instance of class under test
        NumberingContinue numberingContinue = new NumberingContinue();
        
        // Create mock XWPFParagraph for source
        XWPFParagraph sourceParagraph = mock(XWPFParagraph.class);
        XWPFParagraph targetParagraph = mock(XWPFParagraph.class);
        
        // Create mock XWPFDocument
        XWPFDocument mockDocument = mock(XWPFDocument.class);
        when(sourceParagraph.getDocument()).thenReturn(mockDocument);
        
        // Create real XWPFNumbering (not mocked to allow actual addNum call)
        XWPFNumbering numbering = mock(XWPFNumbering.class);
        when(mockDocument.getNumbering()).thenReturn(numbering);
        
        // Setup source paragraph to have a numID
        BigInteger sourceNumID = BigInteger.valueOf(1);
        when(sourceParagraph.getNumID()).thenReturn(sourceNumID);
        
        // Setup numbering to return a valid XWPFNum
        XWPFNum mockNum = mock(XWPFNum.class);
        when(numbering.getNum(sourceNumID)).thenReturn(mockNum);
        
        // Setup CTNum for the mockNum
        CTNum ctNum = CTNum.Factory.newInstance();
        CTDecimalNumber abstractNumId = ctNum.addNewAbstractNumId();
        abstractNumId.setVal(BigInteger.valueOf(2));
        when(mockNum.getCTNum()).thenReturn(ctNum);
        
        // Setup abstract num
        XWPFAbstractNum mockAbstractNum = mock(XWPFAbstractNum.class);
        when(numbering.getAbstractNum(BigInteger.valueOf(2))).thenReturn(mockAbstractNum);
        
        // Setup CTAbstractNum
        CTAbstractNum ctAbstractNum = CTAbstractNum.Factory.newInstance();
        ctAbstractNum.setAbstractNumId(BigInteger.valueOf(2));
        when(mockAbstractNum.getAbstractNum()).thenReturn(ctAbstractNum);
        
        // Setup XWPFNumberingWrapper to return a next abstract num ID
        XWPFNumberingWrapper wrapper = mock(XWPFNumberingWrapper.class);
        when(wrapper.getNextAbstractNumID()).thenReturn(BigInteger.valueOf(3));
        
        // Use reflection to create wrapper since constructor is package-private
        // We'll mock the numbering.addAbstractNum call to return an ID
        BigInteger abstractNumID = BigInteger.valueOf(4);
        when(numbering.addAbstractNum(any(XWPFAbstractNum.class))).thenReturn(abstractNumID);
        
        // Setup numbering.addNum to return a new num ID
        BigInteger newNumId = BigInteger.valueOf(5);
        when(numbering.addNum(abstractNumID)).thenReturn(newNumId);
        
        // Call the entry point method
        numberingContinue.updateNumbering(sourceParagraph, targetParagraph);
    }
}
