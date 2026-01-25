package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilscloneWorkbook_XSSFWorkbookmethodFikaTest {

    @Test
    public void testCloneWorkbook() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XSSFWorkbook srcWorkbook = new XSSFWorkbook();
        srcWorkbook.createSheet("Test");
        srcWorkbook.write(out);
        srcWorkbook.close();
        
        XSSFWorkbook src = new XSSFWorkbook(new java.io.ByteArrayInputStream(out.toByteArray()));
        PoitlIOUtils.cloneWorkbook(src, true);
    }
}
