package com.deepoove.poi.resolver;

import com.deepoove.poi.xwpf.RunBodyContext;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RunningRunBodymethod_QNameSetforArrayFikaTest {

    @Test
    public void testLoggerInfoTriggersStaticInitializer() {
        // Create mocks for constructor dependencies
        RunBodyContext mockContext = Mockito.mock(RunBodyContext.class);
        Pattern mockPattern = Mockito.mock(Pattern.class);
        
        // Mock the runs list to be non-empty so the constructor proceeds
        List<XWPFRun> mockRuns = new ArrayList<>();
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        mockRuns.add(mockRun);
        
        // Configure mocks
        Mockito.when(mockContext.getRuns()).thenReturn(mockRuns);
        Mockito.when(mockRun.text()).thenReturn("test");
        Mockito.when(mockPattern.matcher(Mockito.anyString())).thenReturn(
            Mockito.mock(java.util.regex.Matcher.class)
        );
        
        // Instantiate the class - this triggers static initializer
        RunningRunBody instance = new RunningRunBody(mockContext, mockPattern);
        
        // Call the entry point method
        instance.loggerInfo();
        
        // The static initializer already called QNameSet.forArray during class loading
        // No assertions needed as per requirements
    }
}
