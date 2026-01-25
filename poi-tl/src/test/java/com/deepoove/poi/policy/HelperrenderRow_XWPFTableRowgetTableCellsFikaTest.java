package com.deepoove.poi.policy;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class HelperrenderRow_XWPFTableRowgetTableCellsFikaTest {

    @Test
    public void testRenderRow() throws Exception {
        XWPFTableRow mockRow = Mockito.mock(XWPFTableRow.class);
        Mockito.when(mockRow.getTableCells()).thenReturn(Collections.emptyList());
        Mockito.when(mockRow.getCell(Mockito.anyInt())).thenReturn(null);
        
        RowRenderData data = new RowRenderData();
        data.setCells(Collections.emptyList());
        
        TableRenderPolicy.Helper.renderRow(mockRow, data, null);
    }
}
