package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.ArrayList;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewCatFikaTest {

    @Test
    public void testAddSeriesInvokesAddNewCat() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        Mockito.when(chart.addNewSer()).thenReturn(ctPieSer);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockIdx = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(mockIdx);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockOrder = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(mockOrder);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        
        XDDFDataSource<?> category = Mockito.mock(XDDFDataSource.class);
        XDDFNumericalDataSource<? extends Number> values = Mockito.mock(XDDFNumericalDataSource.class);
        
        chartData.addSeries(category, values);
    }
}
