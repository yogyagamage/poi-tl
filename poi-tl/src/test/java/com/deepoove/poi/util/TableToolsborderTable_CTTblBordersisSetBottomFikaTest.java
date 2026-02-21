package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.math.BigInteger;
import java.lang.reflect.Method;

public class TableToolsborderTable_CTTblBordersisSetBottomFikaTest {

    @Test
    public void testBorderTableInvokesIsSetBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        
        CTTbl ctTbl = getCTTbl(table);
        CTTblPr tblPr = ctTbl.getTblPr();
        if (tblPr == null) {
            tblPr = ctTbl.addNewTblPr();
        }
        
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        tblBorders.addNewBottom();
        
        Method borderTableMethod = TableTools.class.getDeclaredMethod(
            "borderTable", XWPFTable.class, int.class);
        borderTableMethod.setAccessible(true);
        borderTableMethod.invoke(null, table, 8);
        
        document.close();
    }
    
    private CTTbl getCTTbl(XWPFTable table) throws Exception {
        Method getTblMethod = XWPFTable.class.getDeclaredMethod("getCTTbl");
        getTblMethod.setAccessible(true);
        return (CTTbl) getTblMethod.invoke(table);
    }
}
