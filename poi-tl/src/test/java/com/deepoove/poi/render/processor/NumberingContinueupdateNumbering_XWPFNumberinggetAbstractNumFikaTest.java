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
        // Create a real XWPFDocument
        XWPFDocument document = new XWPFDocument();
        
        // Create a real XWPFNumbering and add it to the document
        XWPFNumbering numbering = document.createNumbering();
        
        // Create a real abstract num and add it to numbering
        CTAbstractNum ctAbstractNum = CTAbstractNum.Factory.newInstance();
        ctAbstractNum.setAbstractNumId(BigInteger.ONE);
        XWPFAbstractNum abstractNum = new XWPFAbstractNum(ctAbstractNum);
        BigInteger abstractNumId = numbering.addAbstractNum(abstractNum);
        
        // Create a real num and add it to numbering
        CTNum ctNum = CTNum.Factory.newInstance();
        ctNum.setNumId(BigInteger.valueOf(100));
        CTDecimalNumber ctDecimalNumber = CTDecimalNumber.Factory.newInstance();
        ctDecimalNumber.setVal(abstractNumId);
        ctNum.setAbstractNumId(ctDecimalNumber);
        XWPFNum num = new XWPFNum(ctNum);
        numbering.addNum(abstractNumId, BigInteger.valueOf(100));
        
        // Create source paragraph with the document and numID
        XWPFParagraph source = document.createParagraph();
        source.setNumID(BigInteger.valueOf(100));
        
        // Create target paragraph
        XWPFParagraph target = document.createParagraph();
        
        // Create instance of class under test using no-arg constructor
        NumberingContinue numberingContinue = new NumberingContinue();
        
        // Call the entry point method
        numberingContinue.updateNumbering(source, target);
    }
}
