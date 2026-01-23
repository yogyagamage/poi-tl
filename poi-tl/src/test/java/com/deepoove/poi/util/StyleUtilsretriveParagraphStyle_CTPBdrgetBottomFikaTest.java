package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.apache.xmlbeans.XmlObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTPBdr pBdr = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        CTBorder bottomBorder = pBdr.addNewBottom();
        
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
