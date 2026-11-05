package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersaddNewInsideHFikaTest {

    @Test
    public void testBorderTableTriggersAddNewInsideH() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(3, 3);
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
