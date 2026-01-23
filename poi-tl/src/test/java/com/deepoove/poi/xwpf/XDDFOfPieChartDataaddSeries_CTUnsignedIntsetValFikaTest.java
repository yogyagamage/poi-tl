package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

class XDDFOfPieChartDataaddSeries_CTUnsignedIntsetValFikaTest {

    @Test
    void testAddSeriesInvokesCTUnsignedIntSetVal() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTPieSer ctPieSer = Mockito.mock(CTPieSer.class);
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt ctUnsignedIntIdx = Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt ctUnsignedIntOrder = Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        
        Mockito.when(chart.addNewSer()).thenReturn(ctPieSer);
        Mockito.when(ctPieSer.addNewIdx()).thenReturn(ctUnsignedIntIdx);
        Mockito.when(ctPieSer.addNewOrder()).thenReturn(ctUnsignedIntOrder);
        Mockito.when(parent.getChartSeries()).thenReturn(java.util.Collections.emptyList());
        
        XDDFDataSource<?> category = Mockito.mock(XDDFDataSource.class);
        XDDFNumericalDataSource<? extends Number> values = Mockito.mock(XDDFNumericalDataSource.class);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        chartData.addSeries(category, values);
    }
}
