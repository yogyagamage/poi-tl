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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.StringReader;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

class AttachmentRenderPolicydoRender_XmlObjectFactoryparseFikaTest {

    @Test
    void testDoRender() throws Exception {
        AttachmentRenderPolicy policy = new AttachmentRenderPolicy();
        
        RenderContext<AttachmentRenderData> mockContext = Mockito.mock(RenderContext.class);
        NiceXWPFDocument mockDoc = Mockito.mock(NiceXWPFDocument.class);
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        CTR mockCtr = Mockito.mock(CTR.class);
        AttachmentRenderData mockData = Mockito.mock(AttachmentRenderData.class);
        PictureRenderData mockIcon = Mockito.mock(PictureRenderData.class);
        
        Mockito.when(mockContext.getXWPFDocument()).thenReturn(mockDoc);
        Mockito.when(mockContext.getRun()).thenReturn(mockRun);
        Mockito.when(mockContext.getData()).thenReturn(mockData);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCtr);
        
        Mockito.when(mockData.getFileType()).thenReturn(AttachmentType.DOCX);
        Mockito.when(mockData.readAttachmentData()).thenReturn(new byte[]{1, 2, 3});
        Mockito.when(mockData.getIcon()).thenReturn(mockIcon);
        
        Mockito.when(mockIcon.readPictureData()).thenReturn(new byte[]{4, 5, 6});
        Mockito.when(mockIcon.getPictureType()).thenReturn(PictureType.PNG);
        PictureStyle mockStyle = new PictureStyle();
        mockStyle.setWidth(64);
        mockStyle.setHeight(64);
        Mockito.when(mockIcon.getPictureStyle()).thenReturn(mockStyle);
        
        Mockito.when(mockDoc.addPictureData(Mockito.any(byte[].class), Mockito.anyInt()))
               .thenReturn("rId1");
        Mockito.when(mockDoc.addEmbeddData(Mockito.any(byte[].class), Mockito.anyString(), Mockito.anyString()))
               .thenReturn("rId2");
        
        policy.doRender(mockContext);
    }
}
