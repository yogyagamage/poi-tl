package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import java.util.ArrayList;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartaddNewVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsInvokesAddNewVaryColors() {
        // Create mock XDDFChart with empty series list
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        Mockito.when(mockParent.getChartSeries()).thenReturn(new ArrayList<>());
        
        // Create real CTOfPieChart (not mocked to allow actual method calls)
        CTOfPieChart chart = CTOfPieChart.Factory.newInstance();
        
        // Instantiate the class under test using the provided constructor
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, chart);
        
        // Call entry point method with non-null Boolean
        // This should trigger the else branch and invoke chart.addNewVaryColors()
        chartData.setVaryColors(Boolean.TRUE);
    }
}
