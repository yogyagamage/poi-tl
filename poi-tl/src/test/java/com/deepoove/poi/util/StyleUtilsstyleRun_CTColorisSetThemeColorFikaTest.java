package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.xwpf.XWPFHighlightColor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFRun.FontCharRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor.Enum;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_CTColorisSetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesIsSetThemeColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        Style style = new Style();
        style.setColor("FF0000");
        
        StyleUtils.styleRun(run, style);
        
        document.close();
    }
}
