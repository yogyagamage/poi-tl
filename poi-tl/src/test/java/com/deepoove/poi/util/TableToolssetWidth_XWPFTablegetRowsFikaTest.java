package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;
import com.deepoove.poi.xwpf.BodyContainer;
import com.deepoove.poi.xwpf.BodyContainerFactory;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;

public class TableToolssetWidth_XWPFTablegetRowsFikaTest {

    @Test
    public void testSetWidthInvokesGetRows() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        CTTblGrid tblGrid = CTTblGrid.Factory.newInstance();
        CTTblGridCol gridCol = tblGrid.addNewGridCol();
        gridCol.setW(BigInteger.valueOf(1000));
        
        CTTblLayoutType tblLayout = CTTblLayoutType.Factory.newInstance();
        tblLayout.setType(STTblLayoutType.FIXED);
        
        table.createRow();
        
        int[] colWidths = new int[]{1000};
        TableTools.setWidth(table, "1000", colWidths);
    }
}
