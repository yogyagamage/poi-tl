package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewIdxFikaTest {

    @Test
    public void testAddSeriesInvokesAddNewIdx() throws Exception {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        Mockito.when(parentChart.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        Mockito.when(ctOfPieChart.getSerList()).thenReturn(new ArrayList<>());
        
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        Mockito.when(ctOfPieChart.addNewSer()).thenReturn(ctPieSer);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockIdx = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(mockIdx);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockOrder = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(mockOrder);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        
        XDDFDataSource<?> category = Mockito.mock(XDDFCategoryDataSource.class);
        XDDFNumericalDataSource<? extends Number> values = 
            Mockito.mock(XDDFNumericalDataSource.class);
        
        chartData.addSeries(category, values);
    }
}
