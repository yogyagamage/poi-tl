package com.deepoove.poi.policy;

import com.deepoove.poi.data.ParagraphRenderData;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Helper_StyleUtilsstylePpr_CTIndsetHangingCharsFikaTest {

    @Test
    public void testRenderParagraphPath() throws Exception {
        // Create document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create ParagraphStyle with hanging indent to trigger CTInd.setHangingChars
        ParagraphStyle paragraphStyle = new ParagraphStyle();
        paragraphStyle.setIndentHangingChars(2.0);
        
        // Create ParagraphRenderData with style and content
        List<RenderData> contents = new ArrayList<>();
        contents.add(new TextRenderData("Test content"));
        ParagraphRenderData data = new ParagraphRenderData();
        data.setParagraphStyle(paragraphStyle);
        data.setContents(contents);
        
        // Call the entry point method
        ParagraphRenderPolicy.Helper.renderParagraph(run, data);
        
        // Close document to release resources
        document.close();
    }
}
