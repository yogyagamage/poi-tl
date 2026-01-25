package com.deepoove.poi.render.compute;

import org.junit.jupiter.api.Test;
import org.springframework.asm.MethodVisitor;
import org.springframework.expression.spel.CodeFlow;

import static org.mockito.Mockito.mock;

public class ReadMapAccessorgenerateCode_CodeFlowloadTargetFikaTest {

    @Test
    public void test() throws Exception {
        ReadMapAccessor readMapAccessor = new ReadMapAccessor();
        
        MethodVisitor methodVisitor = mock(MethodVisitor.class);
        CodeFlow codeFlow = new CodeFlow("testClassName", null);
        
        readMapAccessor.generateCode("testProperty", methodVisitor, codeFlow);
    }
}
