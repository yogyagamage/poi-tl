package com.deepoove.poi.xwpf;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

public class XDDFOfPieChartData_Seriesmethod_XDDFDataSourcesFactoryfromDataSourceFikaTest {

    @Test
    public void testChain() throws Exception {
        XDDFChart parent = mock(XDDFChart.class);
        CTOfPieChart chart = mock(CTOfPieChart.class);
        CTPieSer series = mock(CTPieSer.class);
        
        when(chart.getSerList()).thenReturn(java.util.Collections.singletonList(series));
        when(parent.getChartSeries()).thenReturn(new java.util.ArrayList<XDDFChartData>());
        
        new XDDFOfPieChartData(parent, chart);
    }
}
