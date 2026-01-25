package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblPraddNewTblBordersFikaTest {

    @Test
    public void testBorderTableCallsAddNewTblBorders() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr == null) {
            tblPr = table.getCTTbl().addNewTblPr();
        }
        
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders != null) {
            tblPr.unsetTblBorders();
        }
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
