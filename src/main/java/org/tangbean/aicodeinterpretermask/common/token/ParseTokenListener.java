package org.tangbean.aicodeinterpretermask.common.token;

import org.antlr.v4.runtime.Token;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class ParseTokenListener {
    protected final MaskResult maskResult;
    protected final Map<String, Consumer<Token>> handleMap;

    public ParseTokenListener(MaskResult maskResult) {
        this.maskResult = maskResult;
        this.handleMap = new HashMap<>();
    }

    public void enterToken(String tokenType, Token token) {
        if (handleMap.containsKey(tokenType)) {
            handleMap.get(tokenType).accept(token);
        }
    }
}
