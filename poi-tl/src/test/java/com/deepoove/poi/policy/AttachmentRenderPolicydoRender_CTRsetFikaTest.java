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
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class AttachmentRenderPolicydoRender_CTRsetFikaTest {

    @Test
    public void testDoRender() throws Exception {
        // Create instance of class under test
        AttachmentRenderPolicy policy = new AttachmentRenderPolicy();
        
        // Create mock RenderContext
        RenderContext<AttachmentRenderData> mockContext = Mockito.mock(RenderContext.class);
        
        // Create mock NiceXWPFDocument
        NiceXWPFDocument mockDoc = Mockito.mock(NiceXWPFDocument.class);
        Mockito.when(mockContext.getXWPFDocument()).thenReturn(mockDoc);
        
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        Mockito.when(mockContext.getRun()).thenReturn(mockRun);
        
        // Create real CTR object (this is the target of the third-party method call)
        CTR realCtr = CTR.Factory.newInstance();
        Mockito.when(mockRun.getCTR()).thenReturn(realCtr);
        
        // Create mock AttachmentRenderData
        AttachmentRenderData mockData = Mockito.mock(AttachmentRenderData.class);
        Mockito.when(mockContext.getData()).thenReturn(mockData);
        
        // Setup AttachmentType
        AttachmentType mockFileType = AttachmentType.DOCX;
        Mockito.when(mockData.getFileType()).thenReturn(mockFileType);
        
        // Setup attachment data
        byte[] mockAttachment = new byte[]{1, 2, 3};
        Mockito.when(mockData.readAttachmentData()).thenReturn(mockAttachment);
        
        // Setup icon - create a real PictureRenderData
        PictureRenderData realIcon = Pictures.ofBase64(mockFileType.icon(), PictureType.PNG).size(64, 64).create();
        Mockito.when(mockData.getIcon()).thenReturn(realIcon);
        
        // Setup document methods
        Mockito.when(mockDoc.addPictureData(Mockito.any(byte[].class), Mockito.anyInt()))
               .thenReturn("rId1");
        Mockito.when(mockDoc.addEmbeddData(Mockito.any(byte[].class), Mockito.anyString(), Mockito.anyString()))
               .thenReturn("rId2");
        
        // Reset static field to ensure shape type XML is included
        // Using reflection to reset the static field
        try {
            java.lang.reflect.Field haveShapeTypeField = AttachmentRenderPolicy.class.getDeclaredField("haveShapeType");
            haveShapeTypeField.setAccessible(true);
            haveShapeTypeField.set(null, false);
        } catch (Exception e) {
            // Ignore reflection issues for test purposes
        }
        
        // Execute the entry point method
        policy.doRender(mockContext);
        
        // No assertions - test passes if no exceptions are thrown
        // The third-party method CTR.set() will be called during execution
    }
}
