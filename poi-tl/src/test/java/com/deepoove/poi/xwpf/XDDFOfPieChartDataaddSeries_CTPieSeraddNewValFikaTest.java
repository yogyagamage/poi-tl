package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewValFikaTest {

    @Test
    public void testAddSeriesTriggersAddNewVal() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        
        Mockito.when(chart.addNewSer()).thenReturn(ctPieSer);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class));
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class));
        Mockito.when(parent.getChartSeries()).thenReturn(Arrays.asList());
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        
        String[] categories = new String[]{"A", "B", "C"};
        Double[] values = new Double[]{1.0, 2.0, 3.0};
        XDDFDataSource<String> categoryDataSource = XDDFDataSourcesFactory.fromArray(categories);
        XDDFNumericalDataSource<Double> valuesDataSource = XDDFDataSourcesFactory.fromArray(values);
        
        chartData.addSeries(categoryDataSource, valuesDataSource);
    }
}
