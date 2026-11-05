package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;

public class CellBodyContainersetParagraph_CTTcsetPArrayFikaTest {

    @Test
    public void testSetParagraph() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        XWPFParagraph paragraph = cell.addParagraph();
        int pos = Math.max(0, cell.getParagraphs().size() - 1);
        CellBodyContainer container = new CellBodyContainer(cell);
        container.setParagraph(paragraph, pos);
    }
}
