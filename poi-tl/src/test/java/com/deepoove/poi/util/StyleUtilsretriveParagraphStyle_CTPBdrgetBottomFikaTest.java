package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;

import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesGetBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTPBdr border = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        
        CTBorder bottomBorder = border.addNewBottom();
        bottomBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forString("single"));
        
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
