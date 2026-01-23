package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

import java.util.ArrayList;

public class XDDFOfPieChartDatasetVaryColors_CTOfPieChartunsetVaryColorsFikaTest {

    @Test
    public void testSetVaryColorsTriggersUnsetVaryColors() throws Exception {
        XDDFChart parentChart = Mockito.mock(XDDFChart.class);
        Mockito.when(parentChart.getChartSeries()).thenReturn(new ArrayList<>());
        
        CTOfPieChart ctOfPieChart = CTOfPieChart.Factory.newInstance();
        CTBoolean varyColors = ctOfPieChart.addNewVaryColors();
        varyColors.setVal(true);
        
        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parentChart, ctOfPieChart);
        
        chartData.setVaryColors(null);
    }
}
