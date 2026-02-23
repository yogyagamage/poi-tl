package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.util.ArrayList;
import java.util.List;

public class LoopRowTableRenderPolicyrender_XWPFTableRowmethodFikaTest {

    @Test
    public void testRenderPathToXWPFTableRowConstructor() throws Exception {
        // Create mock template with minimal configuration
        Configure config = Configure.builder().build();
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        Mockito.when(template.getConfig()).thenReturn(config);
        
        // Create a real XWPFDocument and table structure
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        // Get the first row as template row
        XWPFTableRow templateRow = table.getRow(0);
        XWPFTableCell tagCell = templateRow.getCell(0);
        
        // Create a paragraph and run inside the cell
        XWPFParagraph paragraph = tagCell.addParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("{{test}}");
        
        // Create the ElementTemplate (RunTemplate)
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        Mockito.when(runTemplate.getSource()).thenReturn("{{test}}");
        
        // Create test data that will trigger the loop
        List<String> data = new ArrayList<>();
        data.add("Item1");
        data.add("Item2");
        
        // Create the policy instance
        LoopRowTableRenderPolicy policy = new LoopRowTableRenderPolicy("{{", "}}");
        
        // Execute the render method - this should trigger the XWPFTableRow constructor
        policy.render(runTemplate, data, template);
    }
}
