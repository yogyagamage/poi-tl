package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.TableWidthType;
import com.deepoove.poi.xwpf.BodyContainer;
import com.deepoove.poi.xwpf.BodyContainerFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolssetWidth_CTTblLayoutTypesetTypeFikaTest {

    @Test
    public void testSetWidth() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        CTTbl ctTbl = table.getCTTbl();
        CTTblPr tblPr = ctTbl.getTblPr();
        if (tblPr == null) {
            tblPr = ctTbl.addNewTblPr();
        }
        
        CTTblLayoutType layoutType = tblPr.getTblLayout();
        if (layoutType == null) {
            layoutType = tblPr.addNewTblLayout();
        }
        
        int[] colWidths = new int[]{1000, 2000, 3000};
        TableTools.setWidth(table, "6000", colWidths);
    }
}
