package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetTopFikaTest {

    @Test
    public void test() throws Exception {
        XWPFTable table = createXWPFTable();
        TableTools.borderTable(table, 8);
    }

    private XWPFTable createXWPFTable() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblPr tblPr = ctTbl.getTblPr();
        if (tblPr == null) {
            tblPr = ctTbl.addNewTblPr();
        }
        
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        return table;
    }
}
