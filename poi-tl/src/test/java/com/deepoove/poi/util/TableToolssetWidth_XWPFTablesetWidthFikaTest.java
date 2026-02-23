package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TableToolssetWidth_XWPFTablesetWidthFikaTest {

    @Test
    public void testSetWidth() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        TableTools.setWidth(table, "5000", new int[]{1000, 2000, 2000});
        
        document.write(baos);
        document.close();
    }
}
