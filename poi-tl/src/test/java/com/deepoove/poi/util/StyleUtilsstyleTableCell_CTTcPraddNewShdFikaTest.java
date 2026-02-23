package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstyleTableCell_CTTcPraddNewShdFikaTest {

    @Test
    public void testStyleTableCellInvokesAddNewShd() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        if (cell == null) {
            cell = row.addNewTableCell();
        }
        
        CTTc ctTc = cell.getCTTc();
        if (!ctTc.isSetTcPr()) {
            ctTc.addNewTcPr();
        }
        
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        StyleUtils.styleTableCell(cell, cellStyle);
    }
}
