package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PoitlIOUtilscloneWorkbook_XSSFWorkbookmethodFikaTest {

    @Test
    public void testCloneWorkbookInvokesXSSFWorkbookConstructor() throws IOException {
        XSSFWorkbook srcWorkbook = new XSSFWorkbook();
        PoitlIOUtils.cloneWorkbook(srcWorkbook, false);
    }
}
