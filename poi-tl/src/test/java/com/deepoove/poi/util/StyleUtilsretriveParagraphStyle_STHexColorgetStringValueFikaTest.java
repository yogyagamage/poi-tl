package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_STHexColorgetStringValueFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        byte[] docxBytes = createMinimalDocxWithShading();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        XWPFDocument document = new XWPFDocument(inputStream);
        
        XWPFParagraph paragraph = document.getParagraphs().get(0);
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
    
    private byte[] createMinimalDocxWithShading() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph paragraph = doc.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTShd shd = ppr.addNewShd();
        shd.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd.CLEAR);
        shd.setFill("FF0000");
        
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        doc.write(baos);
        doc.close();
        
        return baos.toByteArray();
    }
}
