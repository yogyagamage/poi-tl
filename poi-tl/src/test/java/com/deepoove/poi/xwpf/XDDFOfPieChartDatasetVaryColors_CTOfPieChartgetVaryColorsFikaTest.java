package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

class XDDFOfPieChartDatasetVaryColors_CTOfPieChartgetVaryColorsFikaTest {

    @Test
    void testSetVaryColorsInvokesGetVaryColors() {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        CTBoolean ctBoolean = Mockito.mock(CTBoolean.class);
        
        Mockito.when(ctOfPieChart.isSetVaryColors()).thenReturn(true);
        Mockito.when(ctOfPieChart.getVaryColors()).thenReturn(ctBoolean);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        chartData.setVaryColors(true);
    }
}
