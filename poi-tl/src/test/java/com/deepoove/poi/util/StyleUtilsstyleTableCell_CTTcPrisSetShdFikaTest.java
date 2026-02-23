package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

import java.math.BigInteger;

public class StyleUtilsstyleTableCell_CTTcPrisSetShdFikaTest {

    @Test
    public void testStyleTableCellInvokesIsSetShd() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        CTTc ctTc = cell.getCTTc();
        CTTcPr tcPr = ctTc.addNewTcPr();
        tcPr.addNewShd();
        
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        StyleUtils.styleTableCell(cell, cellStyle);
    }
}
