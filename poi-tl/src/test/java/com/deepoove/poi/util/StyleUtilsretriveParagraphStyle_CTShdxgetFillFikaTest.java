package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_CTShdxgetFillFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesXgetFill() throws Exception {
        // Create a minimal document with a paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has shading with fill
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTShd shd = ppr.isSetShd() ? ppr.getShd() : ppr.addNewShd();
        shd.setVal(STShd.CLEAR);
        shd.setFill("FFFFFF");
        
        // This call should traverse the path and invoke CTShd.xgetFill()
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
