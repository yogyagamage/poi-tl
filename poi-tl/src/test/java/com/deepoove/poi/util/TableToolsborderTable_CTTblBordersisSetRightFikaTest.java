package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersisSetRightFikaTest {

    @Test
    public void testBorderTableInvokesIsSetRight() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
