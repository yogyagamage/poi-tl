package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import com.deepoove.poi.xwpf.XWPFOnOff;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewWidowControlFikaTest {

    @Test
    public void testStylePprInvokesAddNewWidowControl() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has a CTP with PPr
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create a ParagraphStyle that will trigger the widowControl path
        ParagraphStyle style = ParagraphStyle.builder()
                .withWidowControl(true)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
