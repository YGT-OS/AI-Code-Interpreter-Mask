package org.tangbean.aicodeinterpretermask.compiler.ruby;

import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class RubyParseTokenListener extends ParseTokenListener {

    public RubyParseTokenListener(MaskResult maskResult) {
        super(maskResult);
        handle_ML_COMMENT();
        handle_SL_COMMENT();
    }

    private void handle_ML_COMMENT() {
        String tokenType = "ML_COMMENT";
        handleMap.put(tokenType,
                token -> maskResult.putCode(tokenType, token.getText(),
                    token.getStartIndex(), token.getStopIndex(),
                    "=begin ", "=end\n")
        );
    }

    private void handle_SL_COMMENT() {
        String tokenType = "SL_COMMENT";
        handleMap.put(tokenType,
                token -> maskResult.putCode(tokenType, token.getText(),
                    token.getStartIndex(), token.getStopIndex(),
                    "# ", "\n")
        );
    }
}
