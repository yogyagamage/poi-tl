package com.deepoove.poi;

import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.DocumentRenderPolicy;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XWPFTemplate_AbstractRenderPolicypostValidError_ClassUtilsgetSimpleNameFikaTest {

    @Test
    public void testPostValidErrorCallsClassUtilsGetSimpleName() throws Exception {
        // Create a minimal DocumentRenderData
        DocumentRenderData data = new DocumentRenderData();
        
        // Create a style for the template tag
        Style style = new Style();
        
        // Create a Configure with a ValidErrorHandler that will trigger postValidError
        Configure.ValidErrorHandler errorHandler = mock(Configure.ValidErrorHandler.class);
        Configure configure = Configure.builder()
                .bind("var", new DocumentRenderPolicy())
                .setValidErrorHandler(errorHandler)
                .build();
        
        // Create a document with a template tag
        XWPFDocument document = new NiceXWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        run.setText("{{var}}");
        
        // Convert document to input stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        
        // Create template using compile method (since constructor is private)
        XWPFTemplate template = XWPFTemplate.compile(inputStream, configure);
        
        // Call the entry point method
        XWPFTemplate.create(data, style);
    }
}
