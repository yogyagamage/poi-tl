package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilscloneWorkbook_XSSFWorkbookwriteFikaTest {

    @Test
    public void testCloneWorkbookInvokesWrite() throws IOException {
        XSSFWorkbook srcWorkbook = new XSSFWorkbook();
        srcWorkbook.createSheet();
        
        PoitlIOUtils.cloneWorkbook(srcWorkbook, false);
    }
}
