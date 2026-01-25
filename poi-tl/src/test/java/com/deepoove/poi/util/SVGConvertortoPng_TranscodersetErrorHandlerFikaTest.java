package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.exception.RenderException;
import org.apache.batik.transcoder.ErrorHandler;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
