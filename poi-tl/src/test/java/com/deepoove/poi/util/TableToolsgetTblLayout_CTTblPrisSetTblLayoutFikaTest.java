package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static com.deepoove.poi.util.TableTools.getTblLayout;

public class TableToolsgetTblLayout_CTTblPrisSetTblLayoutFikaTest {

    @Test
    public void testGetTblLayout() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        cell.setText("Test");
        
        CTTblLayoutType result = getTblLayout(table);
        
        document.close();
    }
}
