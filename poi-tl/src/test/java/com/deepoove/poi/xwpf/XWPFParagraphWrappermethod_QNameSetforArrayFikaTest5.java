package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class XWPFParagraphWrappermethod_QNameSetforArrayFikaTest5 {

    @Test
    public void testInsertNewCommentRangeEndTriggersQNameSetForArray() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Test");
        
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        BigInteger cId = BigInteger.valueOf(1);
        
        wrapper.insertNewCommentRangeEnd(run, cId);
        
        document.close();
    }
}
