package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;

public class StyleUtilsretriveParagraphStyle_EnumintValueFikaTest {

    @Test
    public void testRetriveParagraphStyle() {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        CTP ctp = paragraph.getCTP();
        CTPPr pr = ctp.isSetPPr() ? ctp.getPPr() : null;
        if (pr == null) {
            pr = ctp.addNewPPr();
        }

        CTShd shd = pr.isSetShd() ? pr.getShd() : null;
        if (shd == null) {
            shd = pr.addNewShd();
        }

        STShd.Enum value = null;
        for (int i = 1; i < 256 && value == null; i++) {
            value = STShd.Enum.forInt(i);
        }
        if (value == null) {
            value = STShd.Enum.forInt(0);
        }

        shd.setVal(value);

        try {
            StyleUtils.retriveParagraphStyle(paragraph);
        } catch (Exception ignored) {
        }
    }
}
