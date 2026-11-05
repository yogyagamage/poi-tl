package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class RemoveTableColumnRenderPolicyminusGridSpan_CTDecimalNumbergetValFikaTest {

    @Test
    public void testRenderTriggersGetVal() throws Exception {
        // Create the class under test
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        // Create mock XWPFTemplate
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        // Create a real table structure
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        // Get the cell that will contain the template tag
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell tagCell = row.getCell(1);
        
        // Create a paragraph and run inside the cell
        XWPFParagraph paragraph = tagCell.addParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("{{@removeColumn}}", 0);
        
        // Create a grid span on the cell to trigger minusGridSpan path
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr tcPr = 
            tagCell.getCTTc().addNewTcPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber gridSpan = 
            tcPr.addNewGridSpan();
        gridSpan.setVal(BigInteger.valueOf(2));
        
        // Create another cell in the same row with "_delete_" text to avoid removal
        XWPFTableCell otherCell = row.getCell(0);
        otherCell.setText("_delete_");
        
        // Create ElementTemplate (RunTemplate)
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        Mockito.when(runTemplate.getSource()).thenReturn("{{@removeColumn}}");
        
        // Execute the entry point method
        policy.render(runTemplate, null, template);
        
        // The test passes if execution reaches CTDecimalNumber.getVal() without exceptions
        // No assertions needed per requirements
    }
}
