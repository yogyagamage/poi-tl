package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetKeepNextFikaTest {

    @Test
    public void testStylePprInvokesSetKeepNext() throws Exception {
        // Create a real XWPFParagraph using reflection since constructor is not public
        XWPFParagraph paragraph = createXWPFParagraph();
        
        // Create ParagraphStyle with keepNext set to trigger the target method
        ParagraphStyle style = new ParagraphStyle();
        style.setKeepNext(true);
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
    
    private XWPFParagraph createXWPFParagraph() throws Exception {
        // Create a minimal XWPFDocument to hold the paragraph
        Class<?> docClass = Class.forName("org.apache.poi.xwpf.usermodel.XWPFDocument");
        Object document = docClass.getDeclaredConstructor().newInstance();
        
        // Create paragraph through document
        java.lang.reflect.Method createParagraph = docClass.getMethod("createParagraph");
        XWPFParagraph paragraph = (XWPFParagraph) createParagraph.invoke(document);
        
        // Ensure paragraph has CTP structure
        java.lang.reflect.Method getCTP = XWPFParagraph.class.getMethod("getCTP");
        Object ctp = getCTP.invoke(paragraph);
        
        // Ensure CTP has PPr
        Class<?> ctpClass = Class.forName("org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP");
        java.lang.reflect.Method isSetPPr = ctpClass.getMethod("isSetPPr");
        java.lang.reflect.Method getPPr = ctpClass.getMethod("getPPr");
        java.lang.reflect.Method addNewPPr = ctpClass.getMethod("addNewPPr");
        
        if (!(Boolean) isSetPPr.invoke(ctp)) {
            addNewPPr.invoke(ctp);
        } else {
            Object ppr = getPPr.invoke(ctp);
            // Ensure PPr has PBdr for potential border styling
            Class<?> pprClass = Class.forName("org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr");
            java.lang.reflect.Method isSetPBdr = pprClass.getMethod("isSetPBdr");
            java.lang.reflect.Method addNewPBdr = pprClass.getMethod("addNewPBdr");
            
            if (!(Boolean) isSetPBdr.invoke(ppr)) {
                addNewPBdr.invoke(ppr);
            }
        }
        
        return paragraph;
    }
}
