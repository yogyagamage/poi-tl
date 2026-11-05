package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;

public class XDDFOfPieChartDatamethod_CTPieSergetValFikaTest {

    @Test
    public void testCTPieSerGetValInvocation() {
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        Mockito.when(mockParent.getChartSeries()).thenReturn(Collections.emptyList());
        
        CTOfPieChart mockChart = Mockito.mock(CTOfPieChart.class);
        CTPieSer mockPieSer = Mockito.mock(CTPieSer.class);
        
        Mockito.when(mockChart.getSerList()).thenReturn(Collections.singletonList(mockPieSer));
        Mockito.when(mockPieSer.getCat()).thenReturn(null);
        Mockito.when(mockPieSer.getVal()).thenReturn(null);
        
        new XDDFOfPieChartData(mockParent, mockChart);
    }
}
