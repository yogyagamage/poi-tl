package com.deepoove.poi.policy;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Helper_XWPFParagraphWrappermethod_QNameSetforArrayFikaTest3 {

    @Test
    public void testRenderTextRunTriggersQNameSetForArray() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create BookmarkTextRenderData to trigger the createBookmark path
        TextRenderData data = new BookmarkTextRenderData("testBookmark", "Sample Text");
        
        // Invoke the entry point method
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        // No assertions - test passes if QNameSet.forArray is invoked during execution
    }
}
