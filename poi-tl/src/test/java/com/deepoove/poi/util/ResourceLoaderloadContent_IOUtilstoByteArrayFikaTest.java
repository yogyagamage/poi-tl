package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.compress.utils.IOUtils;

public class ResourceLoaderloadContent_IOUtilstoByteArrayFikaTest {

    @Test
    public void testLoadContent() throws Exception {
        ResourceLoader loader = new ResourceLoader();
        String resourcePath = "test.txt";
        
        // Create a test resource in the classpath
        java.io.File tempFile = java.io.File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();
        java.nio.file.Files.write(tempFile.toPath(), "test content".getBytes());
        
        // Add the directory containing the temp file to classpath via custom ClassLoader
        java.net.URL url = tempFile.getParentFile().toURI().toURL();
        java.net.URLClassLoader customClassLoader = new java.net.URLClassLoader(
            new java.net.URL[]{url}, 
            Thread.currentThread().getContextClassLoader()
        );
        
        Thread.currentThread().setContextClassLoader(customClassLoader);
        
        try {
            loader.loadContent(tempFile.getName());
        } finally {
            Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());
        }
    }
}
