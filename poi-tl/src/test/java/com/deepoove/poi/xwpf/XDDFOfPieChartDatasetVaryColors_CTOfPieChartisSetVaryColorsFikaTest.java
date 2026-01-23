package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.mockito.Mockito;

import java.util.ArrayList;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartisSetVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsPath() throws Exception {
        // Create mock XDDFChart
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        Mockito.when(mockParent.getChartSeries()).thenReturn(new ArrayList<>());
        
        // Create real CTOfPieChart with isSetVaryColors() method
        CTOfPieChart ctChart = CTOfPieChart.Factory.newInstance();
        
        // Create instance using constructor
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, ctChart);
        
        // Call entry point with null to trigger the path that calls isSetVaryColors()
        chartData.setVaryColors(null);
    }
}
