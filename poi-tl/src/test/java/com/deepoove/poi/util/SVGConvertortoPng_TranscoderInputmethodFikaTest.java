package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.exception.RenderException;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SVGConvertortoPng_TranscoderInputmethodFikaTest {

    @Test
    public void testToPng() throws TranscoderException, IOException {
        SVGConvertor svgConvertor = new SVGConvertor();
        
        byte[] svgData = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100\" height=\"100\"><circle cx=\"50\" cy=\"50\" r=\"40\"/></svg>".getBytes();
        float width = 100.0f;
        float maxHeight = 100.0f;
        int svgScale = 1;
        
        svgConvertor.toPng(svgData, width, maxHeight, svgScale);
    }
}
