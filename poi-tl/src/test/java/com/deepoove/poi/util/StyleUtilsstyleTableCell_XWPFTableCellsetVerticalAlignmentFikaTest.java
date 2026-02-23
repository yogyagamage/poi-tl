package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleTableCell_XWPFTableCellsetVerticalAlignmentFikaTest {

    @Test
    public void testStyleTableCellCallsSetVerticalAlignment() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        CellStyle cellStyle = new CellStyle();
        cellStyle.setVertAlign(XWPFVertAlign.CENTER);
        
        StyleUtils.styleTableCell(cell, cellStyle);
        
        document.close();
    }
}
