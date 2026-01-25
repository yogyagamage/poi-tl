package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import java.util.List;
import java.util.ArrayList;

public class ParagraphUtilshaveObject_CTRgetObjectListFikaTest {

    @Test
    public void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        CTR ctr = run.getCTR();
        CTObject ctObject = ctr.addNewObject();
        
        ParagraphUtils.haveObject(paragraph);
    }
}
