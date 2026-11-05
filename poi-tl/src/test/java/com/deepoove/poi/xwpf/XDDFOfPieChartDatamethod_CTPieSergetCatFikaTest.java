package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.ArrayList;

public class XDDFOfPieChartDatamethod_CTPieSergetCatFikaTest {

    @Test
    public void test() throws Exception {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        CTPieSer series = Mockito.mock(CTPieSer.class);
        List<CTPieSer> serList = new ArrayList<>();
        serList.add(series);
        
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        Mockito.when(chart.getSerList()).thenReturn(serList);
        
        new XDDFOfPieChartData(parent, chart);
    }
}
