package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_MethodVisitorvisitLdcInsnFikaTest {

    @Test
    public void testGenerateCodeInvokesVisitLdcInsn() {
        ReadMapAccessor accessor = new ReadMapAccessor();
        MethodVisitor methodVisitor = mock(MethodVisitor.class);
        CodeFlow codeFlow = new CodeFlow("com/test/ClassName", null);
        
        codeFlow.pushDescriptor("Ljava/util/Map");
        accessor.generateCode("testProperty", methodVisitor, codeFlow);
    }
}
