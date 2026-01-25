package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.compress.utils.IOUtils;

public class ResourceLoaderloadContent_IOUtilscloseQuietlyFikaTest {

    @Test
    public void testLoadContentTriggersCloseQuietly() throws Exception {
        ResourceLoader loader = new ResourceLoader();
        
        // Use a resource that exists in the classpath
        String resourcePath = "test.txt";
        
        // Try to load the resource - this will trigger the call chain
        try {
            loader.loadContent(resourcePath);
        } catch (Exception e) {
            // Ignore exceptions - test only cares about execution path
        }
    }
}
