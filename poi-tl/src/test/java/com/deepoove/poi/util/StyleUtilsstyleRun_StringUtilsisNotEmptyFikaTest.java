package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFRun.FontCharRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.xwpf.XWPFHighlightColor;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testStyleRunInvokesStringUtilsIsNotEmpty() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun srcRun = document.createParagraph().createRun();
        XWPFRun destRun = document.createParagraph().createRun();
        
        srcRun.setStyle("CustomStyle");
        
        StyleUtils.styleRun(destRun, srcRun);
        
        document.close();
    }
}
