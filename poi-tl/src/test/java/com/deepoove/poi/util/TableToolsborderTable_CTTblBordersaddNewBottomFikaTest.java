package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import java.lang.reflect.Method;
import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersaddNewBottomFikaTest {

    @Test
    public void testBorderTableInvokesAddNewBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        Method getTblPrMethod = TableTools.class.getDeclaredMethod("getTblPr", XWPFTable.class);
        getTblPrMethod.setAccessible(true);
        CTTblPr tblPr = (CTTblPr) getTblPrMethod.invoke(null, table);
        
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        TableTools.borderTable(table, 8);
    }
}
