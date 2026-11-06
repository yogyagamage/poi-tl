package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolssetWidth_XWPFTableRowgetCellFikaTest {

    @Test
    public void testSetWidthInvokesGetCell() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        List<XWPFTableRow> rows = new ArrayList<>();
        rows.add(table.getRow(0));
        rows.add(table.getRow(1));
        
        int[] colWidths = {1000, 2000, 3000};
        
        TableTools.setWidth(table, "5000", colWidths);
    }
}
