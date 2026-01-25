package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import java.math.BigInteger;

public class StyleUtilsstyleTableCell_CTTcgetTcPrFikaTest {

    @Test
    public void testStyleTableCell() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        CTTc ctTc = cell.getCTTc();
        CTTcPr tcPr = ctTc.addNewTcPr();
        CTShd shd = tcPr.addNewShd();
        shd.setFill("auto");
        shd.setVal(STShd.CLEAR);
        
        StyleUtils.styleTableCell(cell, cellStyle);
        
        document.close();
    }
}
