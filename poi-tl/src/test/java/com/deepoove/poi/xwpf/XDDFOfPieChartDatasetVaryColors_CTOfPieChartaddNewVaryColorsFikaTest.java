package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;

class XDDFOfPieChartDatasetVaryColors_CTOfPieChartaddNewVaryColorsFikaTest {

    @Test
    void testSetVaryColorsInvokesAddNewVaryColors() throws Exception {
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        CTBoolean ctBoolean = Mockito.mock(CTBoolean.class);
        Mockito.when(ctOfPieChart.isSetVaryColors()).thenReturn(false);
        Mockito.when(ctOfPieChart.addNewVaryColors()).thenReturn(ctBoolean);
        
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        chartData.setVaryColors(true);
    }
}
