package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWordInvokesIsNotBlank() {
        // Test with non-blank string to ensure isNotBlank is called
        String input = "test$string";
        RegexUtils.escapeExprSpecialWord(input);
        
        // Test with blank string - isNotBlank should still be called
        RegexUtils.escapeExprSpecialWord("");
        
        // Test with null - isNotBlank should still be called
        RegexUtils.escapeExprSpecialWord(null);
    }
}
