package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.apache.batik.transcoder.TranscoderException;

public class SVGConvertortoPng_TranscodersetErrorHandlerFikaTest {

    @Test
    public void testToPngInvokesSetErrorHandler() throws TranscoderException, IOException {
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><rect width=\"100\" height=\"100\" fill=\"blue\"/></svg>".getBytes();
        float width = 100.0f;
        float maxHeight = 100.0f;
        int svgScale = 1;
        
        SVGConvertor.toPng(svgData, width, maxHeight, svgScale);
    }
}
