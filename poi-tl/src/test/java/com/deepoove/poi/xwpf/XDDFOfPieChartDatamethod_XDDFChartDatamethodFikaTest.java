package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import java.util.List;
import java.util.ArrayList;

public class XDDFOfPieChartDatamethod_XDDFChartDatamethodFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        XDDFChart mockChart = Mockito.mock(XDDFChart.class);
        CTOfPieChart mockCTOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        List<XDDFChartData> emptySeriesList = new ArrayList<>();
        Mockito.when(mockChart.getChartSeries()).thenReturn(emptySeriesList);
        
        List<CTPieSer> emptySerList = new ArrayList<>();
        Mockito.when(mockCTOfPieChart.getSerList()).thenReturn(emptySerList);
        
        new XDDFOfPieChartData(mockChart, mockCTOfPieChart);
    }
}
