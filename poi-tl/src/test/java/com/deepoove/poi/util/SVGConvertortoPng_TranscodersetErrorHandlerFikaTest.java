package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.apache.batik.transcoder.TranscoderException;

public class SVGConvertortoPng_TranscodersetErrorHandlerFikaTest {

    @Test
    public void testToPngInvokesSetErrorHandler() throws TranscoderException, IOException {
        // Create minimal SVG data - just enough to pass basic validation
        String minimalSvg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                           "<svg xmlns=\"http://www.w3.org/2000/svg\" " +
                           "width=\"100\" height=\"100\">" +
                           "<rect width=\"100\" height=\"100\" fill=\"red\"/>" +
                           "</svg>";
        byte[] svgBytes = minimalSvg.getBytes();
        
        // Call the entry point method with parameters that will execute the path
        // The third-party method setErrorHandler will be invoked during execution
        SVGConvertor.toPng(svgBytes, 100.0f, 100.0f, 1);
    }
}
