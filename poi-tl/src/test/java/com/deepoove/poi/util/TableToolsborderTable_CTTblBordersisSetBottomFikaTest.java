package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetBottomFikaTest {

    @Test
    public void testBorderTableInvokesIsSetBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr == null) {
            tblPr = table.getCTTbl().addNewTblPr();
        }
        CTTblBorders tblBorders = tblPr.addNewTblBorders();
        tblBorders.addNewBottom();
        
        TableTools.borderTable(table, 8);
    }
}
