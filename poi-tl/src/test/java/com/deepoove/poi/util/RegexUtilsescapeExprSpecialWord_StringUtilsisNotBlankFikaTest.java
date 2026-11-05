package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWord() {
        // Test with non-blank string to invoke StringUtils.isNotBlank
        String result = RegexUtils.escapeExprSpecialWord("test*keyword");
        
        // Test with blank string to also invoke StringUtils.isNotBlank
        String result2 = RegexUtils.escapeExprSpecialWord("   ");
        
        // Test with null to also invoke StringUtils.isNotBlank
        String result3 = RegexUtils.escapeExprSpecialWord(null);
        
        // Test with string containing special characters
        String result4 = RegexUtils.escapeExprSpecialWord("test\\keyword");
    }
}
