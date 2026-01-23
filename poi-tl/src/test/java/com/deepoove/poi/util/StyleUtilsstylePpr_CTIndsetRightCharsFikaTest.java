package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndsetRightCharsFikaTest {

    @Test
    public void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentRightChars(2.5)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
