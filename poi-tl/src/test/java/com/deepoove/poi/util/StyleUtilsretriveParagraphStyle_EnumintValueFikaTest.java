package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_EnumintValueFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create a minimal document with a paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying XML object
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create and set shading to trigger the target method call
        CTShd shd = ppr.addNewShd();
        shd.setVal(STShd.CLEAR);
        
        // Execute the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
