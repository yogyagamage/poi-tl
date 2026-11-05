package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.ArrayList;
import java.util.List;

public class XDDFOfPieChartDatamethod_CTOfPieChartgetSerListFikaTest {

    @Test
    public void test() {
        XDDFChart parent = Mockito.mock(XDDFChart.class);
        CTOfPieChart chart = Mockito.mock(CTOfPieChart.class);
        
        List<CTPieSer> serList = new ArrayList<>();
        serList.add(Mockito.mock(CTPieSer.class));
        
        Mockito.when(chart.getSerList()).thenReturn(serList);
        Mockito.when(parent.getChartSeries()).thenReturn(new ArrayList<>());
        
        new XDDFOfPieChartData(parent, chart);
    }
}
