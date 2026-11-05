package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;

public class XDDFOfPieChartDataaddSeries_CTPieSeraddNewOrderFikaTest {

    @Test
    public void testAddSeries() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("data");

        XSSFRow categoryRow = sheet.createRow(0);
        categoryRow.createCell(0).setCellValue("A");
        categoryRow.createCell(1).setCellValue("B");

        XSSFRow valueRow = sheet.createRow(1);
        valueRow.createCell(0).setCellValue(1.0);
        valueRow.createCell(1).setCellValue(2.0);

        XDDFDataSource<String> category = XDDFDataSourcesFactory.fromStringCellRange(
                sheet, new CellRangeAddress(0, 0, 0, 1));
        XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(
                sheet, new CellRangeAddress(1, 1, 0, 1));

        Object ctPieChart = CTPieChart.Factory.newInstance();
        Object ctOfPieChart = CTOfPieChart.Factory.newInstance();
        Object ctChart = CTChart.Factory.newInstance();
        Object xssfChart = createXSSFChart(sheet);
        Object xddfChart = tryCreateXDDFChart(ctChart, ctPieChart, ctOfPieChart, xssfChart, workbook);

        Object[] instantiateCandidates = new Object[] { ctPieChart, ctOfPieChart, ctChart, xssfChart, xddfChart };
        Object[] fieldCandidates = new Object[] { ctPieChart, ctOfPieChart, ctChart, xssfChart, xddfChart, new ArrayList<Object>() };

        Class<?> targetClass = Class.forName("com.deepoove.poi.xwpf.XDDFOfPieChartData");
        Object target = instantiate(targetClass, instantiateCandidates);
        if (target != null) {
            injectFields(target, fieldCandidates);
        }

        Method addSeries = targetClass.getMethod("addSeries", XDDFDataSource.class, XDDFNumericalDataSource.class);
        addSeries.invoke(target, category, values);
    }

    private static Object createXSSFChart(XSSFSheet sheet) {
        try {
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 10, 10);
            return drawing.createChart(anchor);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Object tryCreateXDDFChart(Object... candidates) {
        try {
            Class<?> chartClass = Class.forName("org.apache.poi.xddf.usermodel.chart.XDDFChart");

            for (Method method : chartClass.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    continue;
                }
                if (!"createChart".equals(method.getName()) && !"create".equals(method.getName())) {
                    continue;
                }
                method.setAccessible(true);
                Object[] args = buildArgs(method.getParameterTypes(), candidates);
                if (args == null) {
                    continue;
                }
                try {
                    Object result = method.invoke(null, args);
                    if (result != null && chartClass.isAssignableFrom(result.getClass())) {
                        return result;
                    }
                } catch (Throwable ignored) {
                }
            }

            if (!Modifier.isAbstract(chartClass.getModifiers())) {
                for (Constructor<?> constructor : chartClass.getDeclaredConstructors()) {
                    constructor.setAccessible(true);
                    Object[] args = buildArgs(constructor.getParameterTypes(), candidates);
                    if (args == null) {
                        continue;
                    }
                    try {
                        return constructor.newInstance(args);
                    } catch (Throwable ignored) {
                    }
                }
            }
        } catch (Throwable ignored) {
        }
        return null;
    }

    private static Object instantiate(Class<?> clazz, Object[] candidates) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0) {
                continue;
            }
            constructor.setAccessible(true);
            Object[] args = buildArgs(constructor.getParameterTypes(), candidates);
            if (args == null) {
                continue;
            }
            try {
                return constructor.newInstance(args);
            } catch (Throwable ignored) {
            }
        }

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length != 0) {
                continue;
            }
            constructor.setAccessible(true);
            try {
                return constructor.newInstance();
            } catch (Throwable ignored) {
            }
        }

        return null;
    }

    private static void injectFields(Object target, Object[] candidates) {
        Class<?> current = target.getClass();
        while (current != null && current != Object.class) {
            for (Field field : current.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                Class<?> type = field.getType();
                if (type == Object.class) {
                    continue;
                }
                Object candidate = findCandidate(type, candidates);
                if (candidate == null) {
                    continue;
                }
                field.setAccessible(true);
                try {
                    if (field.get(target) == null) {
                        field.set(target, candidate);
                    }
                } catch (Throwable ignored) {
                }
            }
            current = current.getSuperclass();
        }
    }

    private static Object[] buildArgs(Class<?>[] types, Object[] candidates) {
        Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            Object candidate = findCandidate(types[i], candidates);
            if (candidate == null) {
                return null;
            }
            args[i] = candidate;
        }
        return args;
    }

    private static Object findCandidate(Class<?> type, Object[] candidates) {
        for (Object candidate : candidates) {
            if (candidate != null && type.isAssignableFrom(candidate.getClass())) {
                return candidate;
            }
        }
        return null;
    }
}
