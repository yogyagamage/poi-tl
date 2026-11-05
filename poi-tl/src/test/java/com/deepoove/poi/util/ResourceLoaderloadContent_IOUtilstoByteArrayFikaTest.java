package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class ResourceLoaderloadContent_IOUtilstoByteArrayFikaTest {

    @Test
    public void testLoadContent() {
        try {
            ResourceLoader.loadContent("org/apache/commons/compress/utils/IOUtils.class");
        } catch (Throwable ignored) {
        }
    }
}
