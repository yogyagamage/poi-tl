package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PoitlIOUtilscloneWorkbook_XSSFWorkbookmethodFikaTest {

    @Test
    public void testCloneWorkbook() throws IOException {
        XSSFWorkbook srcWorkbook = new XSSFWorkbook();
        PoitlIOUtils.cloneWorkbook(srcWorkbook, false);
    }
}
