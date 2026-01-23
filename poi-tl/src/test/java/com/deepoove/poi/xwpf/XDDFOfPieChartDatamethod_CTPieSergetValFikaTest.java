package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;

public class XDDFOfPieChartDatamethod_CTPieSergetValFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTPieSer series = Mockito.mock(CTPieSer.class);
        
        Mockito.when(parent.getChartSeries()).thenReturn(Collections.emptyList());
        Mockito.when(chart.getSerList()).thenReturn(Collections.singletonList(series));
        
        new XDDFOfPieChartData(parent, chart);
    }
}
