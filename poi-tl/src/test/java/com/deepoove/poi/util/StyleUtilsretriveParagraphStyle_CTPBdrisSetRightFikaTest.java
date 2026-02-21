package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrisSetRightFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrIsSetRight() throws Exception {
        byte[] docContent = createMinimalDocxWithParagraphBorder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docContent);
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFParagraph paragraph = document.getParagraphs().get(0);
        
        StyleUtils.retriveParagraphStyle(paragraph);
    }
    
    private byte[] createMinimalDocxWithParagraphBorder() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph paragraph = doc.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTPBdr border = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        
        CTBorder rightBorder = border.addNewRight();
        rightBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        doc.write(out);
        doc.close();
        return out.toByteArray();
    }
}
