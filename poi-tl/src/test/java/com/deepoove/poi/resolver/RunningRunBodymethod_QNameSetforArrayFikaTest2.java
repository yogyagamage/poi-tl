package com.deepoove.poi.resolver;

import com.deepoove.poi.xwpf.RunBodyContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.regex.Pattern;

public class RunningRunBodymethod_QNameSetforArrayFikaTest2 {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        RunBodyContext mockContext = Mockito.mock(RunBodyContext.class);
        Mockito.when(mockContext.getRuns()).thenReturn(Collections.emptyList());
        
        Pattern pattern = Pattern.compile("test");
        
        new RunningRunBody(mockContext, pattern);
    }
}
