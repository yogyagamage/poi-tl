package com.deepoove.poi.policy;

import com.deepoove.poi.data.AttachmentRenderData;
import com.deepoove.poi.data.AttachmentType;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;
import com.deepoove.poi.data.style.PictureStyle;
import com.deepoove.poi.render.RenderContext;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.StringReader;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class AttachmentRenderPolicydoRender_InputSourcemethodFikaTest {

    @Test
    public void testDoRender() throws Exception {
        AttachmentRenderPolicy policy = new AttachmentRenderPolicy();
        
        RenderContext<AttachmentRenderData> context = Mockito.mock(RenderContext.class);
        NiceXWPFDocument doc = Mockito.mock(NiceXWPFDocument.class);
        XWPFRun run = Mockito.mock(XWPFRun.class);
        CTR ctr = Mockito.mock(CTR.class);
        AttachmentRenderData data = Mockito.mock(AttachmentRenderData.class);
        PictureRenderData icon = Mockito.mock(PictureRenderData.class);
        
        Mockito.when(context.getXWPFDocument()).thenReturn(doc);
        Mockito.when(context.getRun()).thenReturn(run);
        Mockito.when(context.getData()).thenReturn(data);
        Mockito.when(run.getCTR()).thenReturn(ctr);
        
        Mockito.when(data.getFileType()).thenReturn(AttachmentType.DOCX);
        Mockito.when(data.readAttachmentData()).thenReturn(new byte[]{1, 2, 3});
        Mockito.when(data.getIcon()).thenReturn(icon);
        
        Mockito.when(icon.readPictureData()).thenReturn(new byte[]{4, 5, 6});
        Mockito.when(icon.getPictureType()).thenReturn(PictureType.PNG);
        Mockito.when(icon.getPictureStyle()).thenReturn(new PictureStyle());
        
        Mockito.when(doc.addPictureData(Mockito.any(byte[].class), Mockito.anyInt())).thenReturn("rId1");
        Mockito.when(doc.addEmbeddData(Mockito.any(byte[].class), Mockito.anyString(), Mockito.anyString())).thenReturn("rId2");
        
        policy.doRender(context);
    }
}
