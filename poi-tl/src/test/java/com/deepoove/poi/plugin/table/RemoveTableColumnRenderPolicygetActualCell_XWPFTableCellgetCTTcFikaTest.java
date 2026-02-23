package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class RemoveTableColumnRenderPolicygetActualCell_XWPFTableCellgetCTTcFikaTest {

    @Test
    public void test() throws Exception {
        // Create real table structure
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        // Get a real cell from the table
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell realCell = row.getCell(0);
        
        // Create CTTcPr with gridSpan for the minusGridSpan path
        realCell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf(2));
        
        // Create another row with spanned cells to trigger getActualCell
        XWPFTableRow secondRow = table.getRow(1);
        XWPFTableCell secondRowCell = secondRow.getCell(0);
        secondRowCell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf(3));
        
        // Create run template
        XWPFParagraph paragraph = realCell.getParagraphs().get(0);
        XWPFRun run = paragraph.createRun();
        run.setText("test");
        
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        Mockito.when(runTemplate.getSource()).thenReturn("test");
        
        // Create template mock
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        // Create policy instance
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        // Execute entry point
        policy.render(runTemplate, null, template);
        
        // Clean up
        document.close();
    }
}
