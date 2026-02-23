package com.deepoove.poi.render.processor;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class DelegatePolicyinvoke_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testInvokePathToClassUtilsGetShortClassName() {
        RenderPolicy mockPolicy = Mockito.mock(RenderPolicy.class);
        ElementTemplate mockElementTemplate = Mockito.mock(ElementTemplate.class);
        Object data = new Object();
        
        Configure mockConfig = Mockito.mock(Configure.class);
        Mockito.when(mockConfig.getPreRenderDataCastors()).thenReturn(Collections.emptyList());
        
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        Mockito.when(mockTemplate.getConfig()).thenReturn(mockConfig);
        
        Mockito.when(mockElementTemplate.getTagName()).thenReturn("testTag");
        Mockito.when(mockElementTemplate.getSign()).thenReturn('$');
        
        DelegatePolicy.invoke(mockPolicy, mockElementTemplate, data, mockTemplate);
    }
}
