package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblGridaddNewGridColFikaTest {

    @Test
    public void testWidthTableInvokesAddNewGridCol() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblGrid tblGrid = ctTbl.addNewTblGrid();
        tblGrid.addNewGridCol().setW(BigInteger.valueOf(1000));
        
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        if (row.getTableCells().size() < 2) {
            row.createCell();
        }
        
        float[] colWidths = new float[]{2.5f, 3.5f};
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
