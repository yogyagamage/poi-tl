package com.deepoove.poi.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class PoitlIOUtilscloneWorkbook_XSSFWorkbookwriteFikaTest {

    @Test
    void cloneWorkbookInvokesXSSFWorkbookWrite() throws Exception {
        XSSFWorkbook src = new XSSFWorkbook();
        src.createSheet("Sheet1");
        PoitlIOUtils.cloneWorkbook(src, true);
    }
}
