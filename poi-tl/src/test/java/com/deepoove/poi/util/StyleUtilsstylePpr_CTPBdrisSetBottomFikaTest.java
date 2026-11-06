package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdrisSetBottomFikaTest {

    @Test
    public void testStylePprInvokesCTPBdrisSetBottom() throws Exception {
        // Create document and paragraph to get real CTP objects
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure paragraph has CTP initialized
        CTP ctp = paragraph.getCTP();
        if (!ctp.isSetPPr()) {
            ctp.addNewPPr();
        }
        
        // Create paragraph style with bottom border to trigger the target call
        ParagraphStyle style = ParagraphStyle.builder()
                .withBottomBorder(BorderStyle.builder().build())
                .build();
        
        // Invoke entry point - this will reach ct.isSetBottom()
        StyleUtils.stylePpr(paragraph, style);
        
        // Clean up resources
        document.close();
    }
}
