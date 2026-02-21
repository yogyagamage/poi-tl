package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilscloneWorkbook_XSSFWorkbookwriteFikaTest {

    @Test
    public void testCloneWorkbook() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        workbook.createSheet("TestSheet");
        
        PoitlIOUtils.cloneWorkbook(workbook, false);
    }
}
