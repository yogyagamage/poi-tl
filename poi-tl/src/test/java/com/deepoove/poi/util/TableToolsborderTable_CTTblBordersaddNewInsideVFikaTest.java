package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;

public class TableToolsborderTable_CTTblBordersaddNewInsideVFikaTest {

    @Test
    public void testBorderTableInvokesAddNewInsideV() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
