package com.deepoove.poi.resolver;

import com.deepoove.poi.xwpf.RunBodyContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class RunningRunBodymethod_QNamemethodFikaTest2 {

    @Test
    public void test() {
        RunBodyContext mockContext = Mockito.mock(RunBodyContext.class);
        Mockito.when(mockContext.getRuns()).thenReturn(new ArrayList<>());
        
        Pattern pattern = Pattern.compile("test");
        
        new RunningRunBody(mockContext, pattern);
    }
}
