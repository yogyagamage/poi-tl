package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.util.StyleUtils;
import com.deepoove.poi.data.style.Style;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_CTColorisSetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesIsSetThemeColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        run.setText("Test");
        
        Style style = Style.builder()
                .buildColor("FF0000")
                .build();
        
        StyleUtils.styleRun(run, style);
        
        document.close();
    }
}
