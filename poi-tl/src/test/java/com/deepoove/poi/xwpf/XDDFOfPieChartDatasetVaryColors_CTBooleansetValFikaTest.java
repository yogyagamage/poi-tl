package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XDDFOfPieChartDatasetVaryColors_CTBooleansetValFikaTest {

    @Test
    public void testSetVaryColorsInvokesCTBooleanSetVal() throws Exception {
        XDDFChart parent = mock(XDDFChart.class);
        CTOfPieChart ctOfPieChart = CTOfPieChart.Factory.newInstance();
        
        CTBoolean ctBoolean = ctOfPieChart.addNewVaryColors();
        ctBoolean.setVal(false);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, ctOfPieChart);
        
        chartData.setVaryColors(true);
    }
}
