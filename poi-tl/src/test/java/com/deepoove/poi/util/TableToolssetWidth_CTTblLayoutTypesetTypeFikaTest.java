package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import com.deepoove.poi.xwpf.BodyContainer;
import com.deepoove.poi.xwpf.BodyContainerFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;

import java.math.BigInteger;
import java.util.Arrays;

public class TableToolssetWidth_CTTblLayoutTypesetTypeFikaTest {

    @Test
    public void testSetWidthInvokesCTTblLayoutTypeSetType() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        int[] colWidths = new int[]{1000, 2000, 3000};
        TableTools.setWidth(table, "5000", colWidths);
        
        document.close();
    }
}
