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
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.addNewPPr();
        CTShd shd = ppr.addNewShd();
        shd.setVal(STShd.CLEAR);
        shd.setFill("FFFFFF");
        
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
