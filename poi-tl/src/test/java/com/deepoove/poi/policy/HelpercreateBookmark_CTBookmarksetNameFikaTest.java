package com.deepoove.poi.policy;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class HelpercreateBookmark_CTBookmarksetNameFikaTest {

    @Test
    public void testRenderTextRunToCreateBookmark() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        TextRenderData data = new BookmarkTextRenderData("Sample Text", "TestBookmark");
        
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        document.write(new ByteArrayOutputStream());
        document.close();
    }
}
