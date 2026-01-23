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

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewOrderFikaTest {

    @Test
    public void testAddSeriesInvokesAddNewOrder() throws Exception {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        Mockito.when(chart.getSerList()).thenReturn(new ArrayList<>());
        
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        Mockito.when(chart.addNewSer()).thenReturn(ctPieSer);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockIdx = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(mockIdx);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockOrder = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(mockOrder);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        
        XDDFDataSource<?> category = XDDFDataSourcesFactory.fromArray(new String[]{"A", "B"});
        XDDFNumericalDataSource<? extends Number> values = XDDFDataSourcesFactory.fromArray(new Double[]{1.0, 2.0});
        
        chartData.addSeries(category, values);
    }
}
