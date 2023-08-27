package org.tangbean.aicodeinterpretermask.common.maskname;

import java.util.HashMap;
import java.util.Map;

public class NumericMaskNameGenerator implements MaskNameGenerator {
    private final Map<String, Integer> type2IndexMap;
    private final Map<String, String> token2MaskNameMap;

    public NumericMaskNameGenerator() {
        type2IndexMap = new HashMap<>();
        token2MaskNameMap = new HashMap<>();
    }

    public String getMaskName(String tokenType, String tokenValue) {
        String tokenName = tokenValue + ":" + tokenType;
        if (token2MaskNameMap.containsKey(tokenName)) {
            return token2MaskNameMap.get(tokenName);
        }
        int suffix = type2IndexMap.getOrDefault(tokenType, -1) + 1;
        String maskName = tokenType + "_" + suffix;
        type2IndexMap.put(tokenType, suffix);
        token2MaskNameMap.put(tokenName, maskName);
        return maskName;
    }
}
