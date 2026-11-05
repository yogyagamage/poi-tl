package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.expression.spel.CodeFlow;
import org.springframework.asm.MethodVisitor;

public class ReadMapAccessorgenerateCode_MethodVisitorvisitLdcInsnFikaTest {

    @Test
    public void testGenerateCode() throws Exception {
        String propertyName = "testProperty";
        MethodVisitor mv = Mockito.mock(MethodVisitor.class);
        CodeFlow cf = Mockito.mock(CodeFlow.class);
        
        Mockito.when(cf.lastDescriptor()).thenReturn("Ljava/util/Map");
        
        ReadMapAccessor accessor = new ReadMapAccessor();
        accessor.generateCode(propertyName, mv, cf);
    }
}
