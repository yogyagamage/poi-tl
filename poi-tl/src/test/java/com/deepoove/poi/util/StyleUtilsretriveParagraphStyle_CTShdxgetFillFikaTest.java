package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTShdxgetFillFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.addNewPPr();
        CTShd shd = ppr.addNewShd();
        shd.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd.CLEAR);
        shd.setFill("FFFFFF");
        
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
