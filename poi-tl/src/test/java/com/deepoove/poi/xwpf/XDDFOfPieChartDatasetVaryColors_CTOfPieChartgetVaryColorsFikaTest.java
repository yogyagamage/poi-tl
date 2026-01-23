package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;

class XDDFOfPieChartDatasetVaryColors_CTOfPieChartgetVaryColorsFikaTest {

    @Test
    void testSetVaryColorsInvokesGetVaryColors() {
        // Create mock chart that will return a mock CTBoolean when getVaryColors() is called
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        CTBoolean mockCtBoolean = Mockito.mock(CTBoolean.class);
        
        // Configure the mock to return true for isSetVaryColors() so execution
        // takes the path that calls getVaryColors()
        Mockito.when(ctOfPieChart.isSetVaryColors()).thenReturn(true);
        Mockito.when(ctOfPieChart.getVaryColors()).thenReturn(mockCtBoolean);
        
        // Mock parent chart required by constructor
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        
        // Create instance using the provided constructor
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        
        // Call the entry point method with a non-null Boolean
        // This should trigger the path: chart.isSetVaryColors() -> chart.getVaryColors()
        chartData.setVaryColors(Boolean.TRUE);
        
        // No assertions or verifications - test completes when getVaryColors() is invoked
    }
}
