package com.deepoove.poi.xwpf;

import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.ArrayList;
import java.util.List;

public class XDDFOfPieChartDatamethod_CTOfPieChartgetSerListFikaTest {

    @Test
    public void test() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        XDDFChart chart = Mockito.mock(XDDFChart.class);
        CTOfPieChart ctOfPieChart = Mockito.mock(CTOfPieChart.class);
        
        List<XDDFChartData> chartSeries = new ArrayList<>();
        Mockito.when(chart.getChartSeries()).thenReturn(chartSeries);
        
        List<CTPieSer> serList = new ArrayList<>();
        CTPieSer pieSer = Mockito.mock(CTPieSer.class);
        serList.add(pieSer);
        Mockito.when(ctOfPieChart.getSerList()).thenReturn(serList);
        
        XDDFDataSource<String> categoryData = XDDFDataSourcesFactory.fromStringCellRange(
                sheet, 
                new org.apache.poi.ss.util.CellRangeAddress(0, 0, 0, 0)
        );
        XDDFNumericalDataSource<Double> valuesData = XDDFDataSourcesFactory.fromNumericCellRange(
                sheet,
                new org.apache.poi.ss.util.CellRangeAddress(0, 0, 1, 1)
        );
        
        Mockito.when(pieSer.getCat()).thenReturn(null);
        Mockito.when(pieSer.getVal()).thenReturn(null);
        
        new XDDFOfPieChartData(chart, ctOfPieChart);
        
        workbook.close();
    }
}
