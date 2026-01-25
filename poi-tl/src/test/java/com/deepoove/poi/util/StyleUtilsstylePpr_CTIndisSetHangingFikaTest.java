package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFOnOff;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetHangingFikaTest {

    @Test
    public void testStylePprInvokesIsSetHanging() throws Exception {
        // Create a real XWPFDocument to avoid NullPointerException
        XWPFDocument document = new XWPFDocument();
        
        // Create a real paragraph from the document
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with indentHangingChars to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentHangingChars(2.0)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // Close the document to release resources
        document.close();
    }
}
