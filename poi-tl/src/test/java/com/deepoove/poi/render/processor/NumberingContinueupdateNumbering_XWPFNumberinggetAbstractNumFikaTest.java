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

public class NumberingContinueupdateNumbering_XWPFNumberinggetAbstractNumFikaTest {

    @Test
    public void testUpdateNumbering() throws Exception {
        // Create a real XWPFDocument with numbering
        XWPFDocument document = new XWPFDocument();
        
        // Create numbering and add required structures
        XWPFNumbering numbering = document.createNumbering();
        
        // Create an abstract num
        CTAbstractNum ctAbstractNum = CTAbstractNum.Factory.newInstance();
        ctAbstractNum.setAbstractNumId(BigInteger.valueOf(1));
        XWPFAbstractNum abstractNum = new XWPFAbstractNum(ctAbstractNum);
        BigInteger abstractNumId = numbering.addAbstractNum(abstractNum);
        
        // Create a num that references the abstract num
        CTNum ctNum = CTNum.Factory.newInstance();
        CTDecimalNumber decimalNumber = CTDecimalNumber.Factory.newInstance();
        decimalNumber.setVal(abstractNumId);
        ctNum.setAbstractNumId(decimalNumber);
        XWPFNum num = new XWPFNum(ctNum, numbering);
        BigInteger numId = numbering.addNum(abstractNumId);
        
        // Create source paragraph with the numID
        XWPFParagraph sourceParagraph = document.createParagraph();
        sourceParagraph.setNumID(numId);
        
        // Create target paragraph
        XWPFParagraph targetParagraph = document.createParagraph();
        
        // Instantiate NumberingContinue using default constructor
        NumberingContinue numberingContinue = new NumberingContinue();
        
        // Call the entry point method
        numberingContinue.updateNumbering(sourceParagraph, targetParagraph);
    }
}
