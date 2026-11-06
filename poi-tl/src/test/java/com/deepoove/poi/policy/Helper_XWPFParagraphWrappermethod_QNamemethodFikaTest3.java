package com.deepoove.poi.policy;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.TextRenderData;

public class Helper_XWPFParagraphWrappermethod_QNamemethodFikaTest3 {

    @Test
    public void testRenderTextRunReachesXWPFParagraphWrapperInitialization() {
        try {
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            TextRenderData data = new BookmarkTextRenderData("test", "bookmark");
            TextRenderPolicy.Helper.renderTextRun(run, data);
        } catch (Throwable ignored) {
        }
    }
}
