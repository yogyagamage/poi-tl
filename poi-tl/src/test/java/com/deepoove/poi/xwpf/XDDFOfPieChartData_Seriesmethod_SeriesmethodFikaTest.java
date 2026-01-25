package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class XDDFOfPieChartData_Seriesmethod_SeriesmethodFikaTest {

    @Test
    public void testAddSeriesTriggersThirdPartyConstructor() {
        XDDFChart mockParent = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockChart = Mockito.mock(CTOfPieChart.class);
        CTPieSer mockCtSer = Mockito.mock(CTPieSer.class);
        
        Mockito.when(mockChart.addNewSer()).thenReturn(mockCtSer);
        Mockito.when(mockCtSer.addNewIdx()).thenReturn(Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class));
        Mockito.when(mockCtSer.addNewOrder()).thenReturn(Mockito.mock(org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt.class));
        Mockito.when(mockParent.getChartSeries()).thenReturn(new ArrayList<>());
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(mockParent, mockChart);
        
        XDDFDataSource<?> mockCategory = Mockito.mock(XDDFDataSource.class);
        XDDFNumericalDataSource<? extends Number> mockValues = Mockito.mock(XDDFNumericalDataSource.class);
        
        chartData.addSeries(mockCategory, mockValues);
    }
}
