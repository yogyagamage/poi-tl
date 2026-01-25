package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XDDFOfPieChartDatasetVaryColors_CTBooleansetValFikaTest {

    @Test
    public void testSetVaryColorsInvokesCTBooleanSetVal() {
        XDDFChart parent = mock(XDDFChart.class);
        CTOfPieChart ctOfPieChart = mock(CTOfPieChart.class);
        CTBoolean ctBoolean = mock(CTBoolean.class);

        when(ctOfPieChart.isSetVaryColors()).thenReturn(true);
        when(ctOfPieChart.getVaryColors()).thenReturn(ctBoolean);

        XDDFOfPieChartData chartData = new XDDFOfPieChartData(parent, ctOfPieChart);
        chartData.setVaryColors(true);
    }
}
