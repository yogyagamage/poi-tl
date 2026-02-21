package com.deepoove.poi.util;

import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xwpf.usermodel.XWPFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Mockito.when;

public class ChartUtilsgetValueAxes_XDDFValueAxismethodFikaTest {

    @Test
    public void testGetValueAxes() throws Exception {
        XWPFChart chart = Mockito.mock(XWPFChart.class);
        org.openxmlformats.schemas.drawingml.x2006.chart.CTChart ctChart = 
            org.openxmlformats.schemas.drawingml.x2006.chart.CTChart.Factory.newInstance();
        org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea plotArea = 
            ctChart.addNewPlotArea();
        org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx valAx = 
            plotArea.addNewValAx();
        valAx.addNewAxId().setVal(1L);
        
        when(chart.getCTChart()).thenReturn(ctChart);
        
        Map<Long, XDDFValueAxis> result = ChartUtils.getValueAxes(chart);
    }
}
