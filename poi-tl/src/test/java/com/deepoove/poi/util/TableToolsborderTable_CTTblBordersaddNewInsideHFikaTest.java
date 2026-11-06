package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersaddNewInsideHFikaTest {

    @Test
    public void testBorderTableInvokesAddNewInsideH() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
