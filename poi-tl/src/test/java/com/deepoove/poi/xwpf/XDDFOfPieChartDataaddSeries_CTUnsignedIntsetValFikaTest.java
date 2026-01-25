package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.ArrayList;

public class XDDFOfPieChartDataaddSeries_CTUnsignedIntsetValFikaTest {

    @Test
    public void testAddSeriesInvokesCTUnsignedIntSetVal() throws Exception {
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockChart = Mockito.mock(CTOfPieChart.class);
        
        Mockito.when(mockParent.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTPieSer mockSer = Mockito.mock(CTPieSer.class);
        Mockito.when(mockChart.addNewSer()).thenReturn(mockSer);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockIdx = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(mockSer.addNewIdx()).thenReturn(mockIdx);
        
        org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt mockOrder = 
            Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class);
        Mockito.when(mockSer.addNewOrder()).thenReturn(mockOrder);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, mockChart);
        
        XDDFDataSource<?> mockCategory = Mockito.mock(XDDFDataSource.class);
        XDDFNumericalDataSource<? extends Number> mockValues = 
            Mockito.mock(XDDFNumericalDataSource.class);
        
        chartData.addSeries(mockCategory, mockValues);
    }
}
