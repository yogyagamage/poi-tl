package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;
import java.util.Arrays;

public class TableToolssetWidth_XWPFTablesetWidthFikaTest {

    @Test
    public void testSetWidth() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 2);
        int[] colWidths = new int[]{100, 200};
        
        TableTools.setWidth(table, "1000", colWidths);
    }
}
