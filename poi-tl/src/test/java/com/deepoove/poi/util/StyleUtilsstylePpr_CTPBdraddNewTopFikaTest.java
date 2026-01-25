package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdraddNewTopFikaTest {

    @Test
    public void testStylePprInvokesAddNewTop() throws Exception {
        // Create a real XWPFDocument to ensure paragraph has proper context
        XWPFDocument document = new XWPFDocument();
        
        // Create a paragraph within the document
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with top border to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withTopBorder(BorderStyle.builder()
                        .build())
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // Close the document to release resources
        document.close();
    }
}
