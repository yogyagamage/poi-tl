package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

public class ReadMapAccessorgenerateCode_CodeFlowlastDescriptorFikaTest {

    @Test
    public void testGenerateCode() {
        ReadMapAccessor accessor = new ReadMapAccessor();
        
        MethodVisitor mv = Mockito.mock(MethodVisitor.class);
        CodeFlow cf = Mockito.mock(CodeFlow.class);
        
        Mockito.when(cf.lastDescriptor()).thenReturn("Ljava/util/Map");
        
        accessor.generateCode("testProperty", mv, cf);
    }
}
