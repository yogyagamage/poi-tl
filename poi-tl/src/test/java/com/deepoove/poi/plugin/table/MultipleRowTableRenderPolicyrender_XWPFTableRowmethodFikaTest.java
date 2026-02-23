package com.deepoove.poi.plugin.table;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MultipleRowTableRenderPolicyrender_XWPFTableRowmethodFikaTest {

    @Test
    public void testRender() throws Exception {
        // Create the policy instance
        MultipleRowTableRenderPolicy policy = new MultipleRowTableRenderPolicy();
        
        // Create mock template with minimal configuration
        Configure config = Configure.builder().build();
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        Mockito.when(template.getConfig()).thenReturn(config);
        
        // Create a real XWPFDocument and table structure
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        // Get the first row and cell
        XWPFTableRow firstRow = table.getRow(0);
        XWPFTableCell tagCell = firstRow.getCell(0);
        
        // Create a paragraph and run in the tag cell
        XWPFParagraph paragraph = tagCell.addParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("{{#test}}");
        
        // Create a mock ElementTemplate that returns our run
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRun()).thenReturn(run);
        Mockito.when(runTemplate.getTagName()).thenReturn("test");
        
        // Create test data that will trigger the iteration
        List<Object> data = new ArrayList<>();
        data.add("item1");
        data.add("item2");
        
        // Execute the render method
        policy.render(runTemplate, data, template);
    }
}
