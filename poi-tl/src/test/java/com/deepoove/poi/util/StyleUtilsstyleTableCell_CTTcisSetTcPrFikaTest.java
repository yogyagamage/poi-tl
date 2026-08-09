package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import com.deepoove.poi.data.style.CellStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.IBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

public class StyleUtilsstyleTableCell_CTTcisSetTcPrFikaTest {

    @Test
    public void testStyleTableCellInvokesIsSetTcPr() throws Exception {
        // Create a real XWPFDocument
        XWPFDocument document = new XWPFDocument();
        
        // Create a real table
        XWPFTable table = document.createTable();
        
        // Get the first cell from the first row
        XWPFTableCell cell = table.getRow(0).getCell(0);
        
        // Create a CellStyle with background color to trigger the path
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        // Call the entry point method
        StyleUtils.styleTableCell(cell, cellStyle);
        
        // The third-party method CTTc.isSetTcPr() should be invoked during execution
    }
}
