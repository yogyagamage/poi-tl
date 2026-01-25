package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class CellBodyContainerclearPlaceholder_XWPFRunsetTextFikaTest {

    @Test
    public void testClearPlaceholder() throws Exception {
        XWPFTableCell mockCell = Mockito.mock(XWPFTableCell.class);
        Mockito.when(mockCell.getBodyElements()).thenReturn(new ArrayList<>());
        
        CellBodyContainer container = new CellBodyContainer(mockCell);
        
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("initial text");
        
        container.clearPlaceholder(run);
    }
}
