package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetLeftFikaTest {

    @Test
    public void testBorderTableInvokesIsSetLeft() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
