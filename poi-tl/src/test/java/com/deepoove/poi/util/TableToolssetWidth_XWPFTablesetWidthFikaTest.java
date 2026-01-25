package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import java.io.ByteArrayOutputStream;

public class TableToolssetWidth_XWPFTablesetWidthFikaTest {

    @Test
    public void testSetWidth() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        int[] colWidths = new int[]{1000, 2000, 3000};
        TableTools.setWidth(table, "5000", colWidths);
        
        document.close();
    }
}
