package org.tangbean.aicodeinterpretermask.mask;

import org.junit.jupiter.api.Test;
import org.tangbean.aicodeinterpretermask.mask.utils.NumericMaskNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

class NumericMaskNameGeneratorTest {
    private static final String[] functionTypes = {
            "function_name",
            "function_definition_params",
            "cond_expression"
    };

    @Test
    void test_GetMaskName_success() {
        NumericMaskNameGenerator generator = new NumericMaskNameGenerator();

        for (String functionType : functionTypes) {
            for (int i = 0; i < 100; i++) {
                String tokenValue = functionType + "_" + i;
                assertMaskName(generator, tokenValue, functionType);
            }
        }

        for (String functionType : functionTypes) {
            String tokenValue = functionType + "_10";
            assertMaskName(generator, tokenValue, functionType);
        }
    }

    void assertMaskName(NumericMaskNameGenerator generator, String tokenValue, String functionType) {
        String maskName = generator.getMaskName(tokenValue, functionType);
        assertEquals(tokenValue, maskName);
    }
}