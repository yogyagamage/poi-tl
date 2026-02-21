package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersaddNewTopFikaTest {

    @Test
    public void testBorderTableInvokesAddNewTop() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        XWPFTableRow row = table.getRow(0);
        if (row.getTableCells().isEmpty()) {
            row.createCell();
        }
        
        CTTblPr tblPr = CTTblPr.Factory.newInstance();
        CTTblBorders tblBorders = CTTblBorders.Factory.newInstance();
        
        java.lang.reflect.Field ctTblField = XWPFTable.class.getDeclaredField("ctTbl");
        ctTblField.setAccessible(true);
        ctTblField.set(table, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance());
        
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl ctTbl = 
            (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl) ctTblField.get(table);
        ctTbl.setTblPr(tblPr);
        tblPr.setTblBorders(tblBorders);
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
