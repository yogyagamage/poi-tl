package com.deepoove.poi.render.processor;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.config.PreRenderDataCastor;
import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import org.apache.commons.lang3.ClassUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class DelegatePolicyinvoke_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testInvokePathToClassUtilsGetShortClassName() {
        // Create real objects where possible
        RenderPolicy mockPolicy = Mockito.mock(RenderPolicy.class);
        ElementTemplate mockElementTemplate = Mockito.mock(ElementTemplate.class);
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        Configure mockConfig = Mockito.mock(Configure.class);
        
        // Setup mock behavior to avoid NPE and follow the path
        Mockito.when(mockElementTemplate.getTagName()).thenReturn("testTag");
        Mockito.when(mockElementTemplate.getSign()).thenReturn('$');
        Mockito.when(mockTemplate.getConfig()).thenReturn(mockConfig);
        Mockito.when(mockConfig.getPreRenderDataCastors()).thenReturn(Collections.emptyList());
        
        // This will trigger the ClassUtils.getShortClassName call in DelegatePolicy.invoke
        DelegatePolicy.invoke(mockPolicy, mockElementTemplate, new Object(), mockTemplate);
    }
}
