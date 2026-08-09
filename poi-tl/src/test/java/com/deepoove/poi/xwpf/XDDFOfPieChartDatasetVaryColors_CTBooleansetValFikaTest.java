package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XDDFOfPieChartDatasetVaryColors_CTBooleansetValFikaTest {

    @Test
    public void testSetVaryColorsInvokesCTBooleanSetVal() {
        // Create mock XDDFChart
        XDDFChart mockParent = mock(XDDFChart.class);
        
        // Create real CTOfPieChart
        CTOfPieChart chart = CTOfPieChart.Factory.newInstance();
        
        // Create CTBoolean and set it up so chart.isSetVaryColors() returns true
        CTBoolean ctBoolean = chart.addNewVaryColors();
        
        // Instantiate XDDFOfPieChartData using the constructor
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, chart);
        
        // Call entry point method - this should invoke CTBoolean.setVal(boolean)
        chartData.setVaryColors(Boolean.TRUE);
    }
}
