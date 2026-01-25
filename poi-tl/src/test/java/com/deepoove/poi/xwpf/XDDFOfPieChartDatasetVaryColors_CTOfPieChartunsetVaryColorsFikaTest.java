package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

import java.util.ArrayList;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartunsetVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsTriggersUnsetVaryColors() throws Exception {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        Mockito.when(parentChart.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        Mockito.when(ctOfPieChart.getSerList()).thenReturn(new ArrayList<>());
        Mockito.when(ctOfPieChart.isSetVaryColors()).thenReturn(true);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        
        chartData.setVaryColors(null);
    }
}
