package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

import java.util.ArrayList;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartaddNewVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsInvokesAddNewVaryColors() throws Exception {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        Mockito.when(chart.getSerList()).thenReturn(new ArrayList<CTPieSer>());
        Mockito.when(chart.isSetVaryColors()).thenReturn(false);
        
        CTBoolean ctBoolean = Mockito.mock(CTBoolean.class);
        Mockito.when(chart.addNewVaryColors()).thenReturn(ctBoolean);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, chart);
        chartData.setVaryColors(true);
    }
}
