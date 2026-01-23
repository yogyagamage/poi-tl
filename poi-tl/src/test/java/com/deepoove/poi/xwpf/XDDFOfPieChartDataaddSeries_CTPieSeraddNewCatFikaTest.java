package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewCatFikaTest {

    @Test
    public void testAddSeriesInvokesAddNewCat() throws Exception {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        Mockito.when(chart.addNewSer()).thenReturn(ctPieSer);
        
        CTUnsignedInt idx = Mockito.mock(CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(idx);
        
        CTUnsignedInt order = Mockito.mock(CTUnsignedInt.class);
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(order);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        
        XDDFDataSource<?> category = Mockito.mock(XDDFDataSource.class);
        XDDFNumericalDataSource<? extends Number> values = Mockito.mock(XDDFNumericalDataSource.class);
        
        chartData.addSeries(category, values);
    }
}
