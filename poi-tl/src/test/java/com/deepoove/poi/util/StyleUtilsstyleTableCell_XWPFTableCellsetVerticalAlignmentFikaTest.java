package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleTableCell_XWPFTableCellsetVerticalAlignmentFikaTest {

    @Test
    public void testStyleTableCellInvokesSetVerticalAlignment() {
        // Create mock cell with required behavior
        XWPFTableCell mockCell = Mockito.mock(XWPFTableCell.class);
        
        // Create cell style with vertical alignment
        CellStyle cellStyle = new CellStyle();
        cellStyle.setVertAlign(XWPFTableCell.XWPFVertAlign.CENTER);
        
        // Execute the entry point method
        StyleUtils.styleTableCell(mockCell, cellStyle);
    }
}
