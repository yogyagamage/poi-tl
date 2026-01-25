package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.xwpf.XWPFOnOff;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdraddNewLeftFikaTest {

    @Test
    public void testStylePprInvokesAddNewLeft() throws Exception {
        // Create a real XWPFDocument to ensure paragraph has proper context
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with left border to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withLeftBorder(BorderStyle.builder().build())
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
