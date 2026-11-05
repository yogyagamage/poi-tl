package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class XDDFOfPieChartDatamethod_XDDFChartgetChartSeriesFikaTest {

    @Test
    public void test() throws Exception {
        XDDFChart mockChart = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockCTOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        new XDDFOfPieChartData(mockChart, mockCTOfPieChart);
    }
}
