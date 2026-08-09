package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import java.util.Collections;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartisSetVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsPath() throws Exception {
        // Create mock XDDFChart
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        Mockito.when(mockParent.getChartSeries()).thenReturn(Collections.emptyList());
        
        // Create real CTOfPieChart
        CTOfPieChart chart = CTOfPieChart.Factory.newInstance();
        
        // Instantiate the class under test
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, chart);
        
        // Call the entry point method with null parameter to trigger the path
        chartData.setVaryColors(null);
    }
}
