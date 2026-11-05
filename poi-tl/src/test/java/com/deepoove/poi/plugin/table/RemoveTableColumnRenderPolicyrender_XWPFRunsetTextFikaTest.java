package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RemoveTableColumnRenderPolicyrender_XWPFRunsetTextFikaTest {

    @Test
    public void testRender() throws Exception {
        // Create the real policy instance
        RemoveTableColumnRenderPolicy policy = new RemoveTableColumnRenderPolicy();
        
        // Create mock template
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        // Create real XWPFRun
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("initial text");
        
        // Create real table structure
        XWPFTable table = document.createTable(2, 3);
        XWPFTableRow row0 = table.getRow(0);
        XWPFTableCell cell00 = row0.getCell(0);
        
        // Set up the run to be inside the table cell
        // We need to get the paragraph from the cell and set the run there
        XWPFParagraph cellParagraph = cell00.getParagraphs().get(0);
        if (cellParagraph.getRuns().isEmpty()) {
            cellParagraph.createRun();
        }
        XWPFRun cellRun = cellParagraph.getRuns().get(0);
        
        // Create RunTemplate with the cell run
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(cellRun);
        Mockito.when(runTemplate.getSource()).thenReturn("{{#delete}}");
        
        // Mock ElementTemplate to return our RunTemplate
        ElementTemplate eleTemplate = Mockito.mock(ElementTemplate.class);
        Mockito.when(eleTemplate.toString()).thenReturn("RunTemplate");
        
        // We need to cast eleTemplate to RunTemplate in the render method
        // Since we can't control that cast, we'll pass runTemplate directly
        // But the method expects ElementTemplate, so we need to make eleTemplate
        // behave like a RunTemplate when cast
        
        // Execute the render method
        policy.render(runTemplate, null, template);
        
        // Clean up
        document.close();
    }
}
