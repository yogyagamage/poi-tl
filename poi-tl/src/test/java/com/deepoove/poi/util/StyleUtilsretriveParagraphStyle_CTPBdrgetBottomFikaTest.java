package com.deepoove.poi.util;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCtpBdrGetBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        CTP ctp = paragraph.getCTP();
        CTPPr pr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTPBdr pbdr = pr.isSetPBdr() ? pr.getPBdr() : pr.addNewPBdr();
        CTBorder bottom = pbdr.isSetBottom() ? pbdr.getBottom() : pbdr.addNewBottom();

        bottom.setVal(STBorder.SINGLE);
        bottom.setSz(BigInteger.valueOf(12));
        bottom.setSpace(BigInteger.valueOf(1));
        bottom.setColor("000000");

        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
