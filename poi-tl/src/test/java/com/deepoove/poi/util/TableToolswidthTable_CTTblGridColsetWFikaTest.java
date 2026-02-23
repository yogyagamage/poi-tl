package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class TableToolswidthTable_CTTblGridColsetWFikaTest {

    @Test
    public void testWidthTableInvokesSetW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        CTTblGrid tblGrid = ctTbl.addNewTblGrid();
        tblGrid.addNewGridCol().setW(BigInteger.valueOf(1000));
        tblGrid.addNewGridCol().setW(BigInteger.valueOf(2000));
        
        java.lang.reflect.Field ctTblField = XWPFTable.class.getDeclaredField("ctTbl");
        ctTblField.setAccessible(true);
        ctTblField.set(table, ctTbl);
        
        XWPFTableRow row = table.createRow();
        row.createCell().setText("Cell 1");
        row.createCell().setText("Cell 2");
        
        float[] colWidths = new float[]{5.0f, 10.0f};
        
        TableTools.widthTable(table, colWidths);
    }
}
