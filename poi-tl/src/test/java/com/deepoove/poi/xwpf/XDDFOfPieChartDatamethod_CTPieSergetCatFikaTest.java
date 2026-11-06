package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

public class XDDFOfPieChartDatamethod_CTPieSergetCatFikaTest {

    @Test
    public void test() throws Exception {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        
        List<CTPieSer> serList = new ArrayList<>();
        CTPieSer pieSer = Mockito.mock(CTPieSer.class);
        serList.add(pieSer);
        
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        Mockito.when(chart.getSerList()).thenReturn(serList);
        
        new XDDFOfPieChartData(parent, chart);
    }
}
