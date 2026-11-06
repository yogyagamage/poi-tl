package com.deepoove.poi.render.compute;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ReadMapAccessorread_TypedValuemethodFikaTest {

    @Test
    public void testReadInvokesTypedValueConstructor() throws Exception {
        ReadMapAccessor readMapAccessor = new ReadMapAccessor();
        EvaluationContext context = new StandardEvaluationContext();
        Map<String, Object> target = new HashMap<>();
        target.put("name", "value");
        readMapAccessor.read(context, target, "name");
    }
}
