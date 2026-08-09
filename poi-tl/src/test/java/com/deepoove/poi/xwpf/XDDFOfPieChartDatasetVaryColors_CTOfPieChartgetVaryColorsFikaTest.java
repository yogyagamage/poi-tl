package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;

class XDDFOfPieChartDatasetVaryColors_CTOfPieChartgetVaryColorsFikaTest {

    @Test
    void testSetVaryColorsInvokesGetVaryColors() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTBoolean varyColorsObj = Mockito.mock(CTBoolean.class);
        
        Mockito.when(chart.isSetVaryColors()).thenReturn(true);
        Mockito.when(chart.getVaryColors()).thenReturn(varyColorsObj);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        chartData.setVaryColors(Boolean.TRUE);
    }
}
