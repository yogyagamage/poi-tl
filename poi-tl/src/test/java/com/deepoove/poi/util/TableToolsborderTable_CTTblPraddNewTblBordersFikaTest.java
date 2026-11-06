package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblPraddNewTblBordersFikaTest {

    @Test
    public void testBorderTableInvokesAddNewTblBorders() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        
        // Ensure CTTblPr exists and has no borders initially
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr == null) {
            tblPr = table.getCTTbl().addNewTblPr();
        }
        if (tblPr.getTblBorders() != null) {
            tblPr.unsetTblBorders();
        }
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
