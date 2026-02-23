package com.deepoove.poi.util;

import com.deepoove.poi.util.StyleUtils;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_EnumintValueFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTShd shd = ppr.addNewShd();
        shd.setVal(STShd.CLEAR);
        shd.setFill("FFFFFF");
        
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
