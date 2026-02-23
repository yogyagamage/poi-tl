package com.deepoove.poi.policy;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class HelperrenderRow_XWPFTableRowgetTableCellsFikaTest {

    @Test
    public void testRenderRowCallsGetTableCells() throws Exception {
        XWPFTableRow mockRow = Mockito.mock(XWPFTableRow.class);
        Mockito.when(mockRow.getTableCells()).thenReturn(Collections.emptyList());
        Mockito.when(mockRow.getCell(Mockito.anyInt())).thenReturn(null);
        
        RowRenderData rowData = Mockito.mock(RowRenderData.class);
        Mockito.when(rowData.obtainColSize()).thenReturn(0);
        Mockito.when(rowData.getRowStyle()).thenReturn(null);
        Mockito.when(rowData.getCells()).thenReturn(Collections.emptyList());
        
        Style defaultStyle = Mockito.mock(Style.class);
        
        TableRenderPolicy.Helper.renderRow(mockRow, rowData, defaultStyle);
    }
}
