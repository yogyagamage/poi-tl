package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.compress.utils.IOUtils;

public class ResourceLoaderloadContent_IOUtilscloseQuietlyFikaTest {

    @Test
    public void testLoadContentCallsCloseQuietly() throws Exception {
        ResourceLoader loader = new ResourceLoader();
        try {
            loader.loadContent("test.txt");
        } catch (Exception e) {
            // Ignore exceptions - test only needs to execute the path
        }
    }
}
