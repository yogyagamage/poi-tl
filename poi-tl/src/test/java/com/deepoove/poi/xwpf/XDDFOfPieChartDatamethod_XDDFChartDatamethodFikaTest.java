package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;

public class XDDFOfPieChartDatamethod_XDDFChartDatamethodFikaTest {

    @Test
    public void testConstructorChain() throws Exception {
        XDDFChart mockChart = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        new XDDFOfPieChartData(mockChart, mockOfPieChart);
    }
}
