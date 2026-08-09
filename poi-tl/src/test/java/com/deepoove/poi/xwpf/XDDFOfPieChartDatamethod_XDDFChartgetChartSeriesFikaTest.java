package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.ArrayList;
import java.util.List;

public class XDDFOfPieChartDatamethod_XDDFChartgetChartSeriesFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // Create mock XDDFChart
        XDDFChart mockChart = Mockito.mock(XDDFChart.class);
        
        // Create mock CTOfPieChart
        CTOfPieChart mockOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        // Create mock list for getSerList()
        List<CTPieSer> mockSerList = new ArrayList<>();
        
        // Configure mock chart to return empty list for getChartSeries()
        Mockito.when(mockChart.getChartSeries()).thenReturn(new ArrayList<>());
        
        // Configure mock CTOfPieChart to return empty ser list
        Mockito.when(mockOfPieChart.getSerList()).thenReturn(mockSerList);
        
        // Instantiate XDDFOfPieChartData using the constructor
        // This will trigger the call chain: constructor -> parent.getChartSeries()
        new XDDFOfPieChartData(mockChart, mockOfPieChart);
    }
}
