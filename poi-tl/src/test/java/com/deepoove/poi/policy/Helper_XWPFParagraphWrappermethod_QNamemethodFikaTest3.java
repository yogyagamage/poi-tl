package com.deepoove.poi.policy;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Helper_XWPFParagraphWrappermethod_QNamemethodFikaTest3 {

    @Test
    public void testRenderTextRunToQNameConstructor() throws Exception {
        // Create real XWPFRun with mocked parent paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create BookmarkTextRenderData to trigger createBookmark path
        TextRenderData data = new BookmarkTextRenderData("test", "bookmark1");
        
        // Execute entry point method
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        // No assertions - test only needs to execute the call chain
    }
}
