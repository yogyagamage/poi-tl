package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

public class TableToolssetWidth_CTTblGridaddNewGridColFikaTest {

    @Test
    public void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);

        CTTblPr tblPr = CTTblPr.Factory.newInstance();
        tblPr.addNewTblLayout();
        table.getCTTbl().setTblPr(tblPr);
        table.getCTTbl().setTblGrid(CTTblGrid.Factory.newInstance());

        TableTools.setWidth(table, "100", new int[]{100});
    }
}
