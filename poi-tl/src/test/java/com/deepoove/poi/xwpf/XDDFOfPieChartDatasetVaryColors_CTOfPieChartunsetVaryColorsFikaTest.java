package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import java.util.Collections;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartunsetVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsTriggersUnsetVaryColors() throws Exception {
        // Create mock dependencies
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockChart = Mockito.mock(CTOfPieChart.class);
        
        // Configure mocks to enable the execution path
        Mockito.when(mockParent.getChartSeries()).thenReturn(Collections.emptyList());
        Mockito.when(mockChart.getSerList()).thenReturn(Collections.emptyList());
        Mockito.when(mockChart.isSetVaryColors()).thenReturn(true);
        
        // Create instance using constructor
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, mockChart);
        
        // Execute entry point with null to trigger unsetVaryColors()
        chartData.setVaryColors(null);
    }
}
