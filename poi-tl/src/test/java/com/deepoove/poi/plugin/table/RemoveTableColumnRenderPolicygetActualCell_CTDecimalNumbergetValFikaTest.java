package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class RemoveTableColumnRenderPolicygetActualCell_CTDecimalNumbergetValFikaTest {

    @Test
    public void test() throws Exception {
        // Create the policy instance
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        // Create mock template
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        // Create mock run template
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getSource()).thenReturn("test");
        
        // Create mock run
        XWPFRun run = Mockito.mock(XWPFRun.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        
        // Create mock paragraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        Mockito.when(run.getParent()).thenReturn(paragraph);
        
        // Create mock table cell
        XWPFTableCell tagCell = Mockito.mock(XWPFTableCell.class);
        Mockito.when(paragraph.getBody()).thenReturn(tagCell);
        
        // Create mock table row
        XWPFTableRow tableRow = Mockito.mock(XWPFTableRow.class);
        Mockito.when(tagCell.getTableRow()).thenReturn(tableRow);
        
        // Create mock table
        XWPFTable table = Mockito.mock(XWPFTable.class);
        Mockito.when(tableRow.getTable()).thenReturn(table);
        Mockito.when(table.getRows()).thenReturn(java.util.Collections.singletonList(tableRow));
        
        // Create actual cell with grid span
        XWPFTableCell actualCell = Mockito.mock(XWPFTableCell.class);
        Mockito.when(tableRow.getTableCells()).thenReturn(java.util.Collections.singletonList(actualCell));
        Mockito.when(tableRow.getCell(0)).thenReturn(actualCell);
        
        // Create CTTc and CTTcPr
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr tcPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr.Factory.newInstance();
        ctTc.setTcPr(tcPr);
        
        // Create CTDecimalNumber with value
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber gridSpan = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber.Factory.newInstance();
        gridSpan.setVal(BigInteger.valueOf(2));
        tcPr.setGridSpan(gridSpan);
        
        Mockito.when(actualCell.getCTTc()).thenReturn(ctTc);
        
        // Make sure TableTools.isInsideTable returns true
        Mockito.mockStatic(com.deepoove.poi.util.TableTools.class).when(
            () -> com.deepoove.poi.util.TableTools.isInsideTable(run)
        ).thenReturn(true);
        
        // Execute the render method
        policy.render((ElementTemplate) runTemplate, null, template);
    }
}
