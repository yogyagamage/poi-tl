package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class RemoveTableColumnRenderPolicyminusGridSpan_CTDecimalNumbersetValFikaTest {

    @Test
    public void test() throws Exception {
        // Create the class under test
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        // Create mock XWPFTemplate
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        // Create a real table structure that will trigger minusGridSpan path
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(3, 3);
        
        // Get the middle cell in first row as our tag cell
        XWPFTableRow firstRow = table.getRow(0);
        XWPFTableCell tagCell = firstRow.getCell(1);
        
        // Create a paragraph and run inside the tag cell
        XWPFParagraph paragraph = tagCell.getParagraphs().get(0);
        XWPFRun run = paragraph.createRun();
        run.setText("test");
        
        // Create a RunTemplate that wraps our run
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        Mockito.when(runTemplate.getSource()).thenReturn("test");
        
        // Set up grid span on a cell in the second row to trigger minusGridSpan
        XWPFTableRow secondRow = table.getRow(1);
        XWPFTableCell gridSpanCell = secondRow.getCell(0);
        
        // Create grid span on this cell
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr tcPr = gridSpanCell.getCTTc().getTcPr();
        if (tcPr == null) {
            tcPr = gridSpanCell.getCTTc().addNewTcPr();
        }
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber gridSpan = tcPr.addNewGridSpan();
        gridSpan.setVal(BigInteger.valueOf(2));
        
        // Remove the cell at position 1 in second row to make templateColIndex not find actualInsertPosition
        secondRow.removeCell(1);
        
        // Execute the render method
        policy.render(runTemplate, null, template);
        
        // Clean up
        document.close();
    }
}
