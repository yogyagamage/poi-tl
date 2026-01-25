package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

public class TableToolsborderTable_CTTblBordersaddNewInsideHFikaTest {

    @Test
    public void testBorderTable() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = CTTbl.Factory.newInstance();
        CTTblPr tblPr = ctTbl.addNewTblPr();
        CTTblBorders tblBorders = tblPr.addNewTblBorders();
        
        java.lang.reflect.Field ctTblField = XWPFTable.class.getDeclaredField("ctTbl");
        ctTblField.setAccessible(true);
        ctTblField.set(table, ctTbl);
        
        TableTools.borderTable(table, 8);
    }
}
