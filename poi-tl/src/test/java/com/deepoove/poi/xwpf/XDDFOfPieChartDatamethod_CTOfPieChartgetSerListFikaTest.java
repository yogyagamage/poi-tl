package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import java.util.Collections;

public class XDDFOfPieChartDatamethod_CTOfPieChartgetSerListFikaTest {

    @Test
    public void testConstructorCallsGetSerList() {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        Mockito.when(parentChart.getChartSeries()).thenReturn(Collections.emptyList());
        Mockito.when(ctOfPieChart.getSerList()).thenReturn(Collections.emptyList());
        
        new XDDFOfPieChartData(parentChart, ctOfPieChart);
    }
}
