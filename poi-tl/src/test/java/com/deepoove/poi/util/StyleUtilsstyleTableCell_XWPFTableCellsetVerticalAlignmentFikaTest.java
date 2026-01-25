package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableCell_XWPFTableCellsetVerticalAlignmentFikaTest {

    @Test
    public void testStyleTableCellInvokesSetVerticalAlignment() {
        XWPFTableCell mockCell = mock(XWPFTableCell.class);
        CellStyle mockCellStyle = mock(CellStyle.class);
        
        when(mockCellStyle.getVertAlign()).thenReturn(XWPFVertAlign.CENTER);
        
        StyleUtils.styleTableCell(mockCell, mockCellStyle);
    }
}
