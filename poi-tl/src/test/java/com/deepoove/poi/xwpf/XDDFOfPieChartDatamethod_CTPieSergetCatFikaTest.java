package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;

public class XDDFOfPieChartDatamethod_CTPieSergetCatFikaTest {

    @Test
    public void testEntryPoint() {
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockChart = Mockito.mock(CTOfPieChart.class);
        CTPieSer mockSeries = Mockito.mock(CTPieSer.class);
        
        Mockito.when(mockParent.getChartSeries()).thenReturn(Collections.emptyList());
        Mockito.when(mockChart.getSerList()).thenReturn(Collections.singletonList(mockSeries));
        
        new XDDFOfPieChartData(mockParent, mockChart);
    }
}
