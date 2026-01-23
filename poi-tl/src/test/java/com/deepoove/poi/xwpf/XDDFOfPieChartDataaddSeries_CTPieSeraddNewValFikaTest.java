package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewValFikaTest {

    @Test
    public void testAddSeriesInvokesCTPieSerAddNewVal() throws Exception {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        Mockito.when(parentChart.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart ctOfPieChart = CTOfPieChart.Factory.newInstance();
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        
        XDDFDataSource<?> category = XDDFDataSourcesFactory.fromArray(new String[]{"A", "B", "C"});
        XDDFNumericalDataSource<? extends Number> values = XDDFDataSourcesFactory.fromArray(new Double[]{1.0, 2.0, 3.0});
        
        chartData.addSeries(category, values);
    }
}
