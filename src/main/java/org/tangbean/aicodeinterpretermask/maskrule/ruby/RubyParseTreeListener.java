package org.tangbean.aicodeinterpretermask.maskrule.ruby;

import org.antlr.v4.runtime.Token;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyBaseListener;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyParser;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

import java.util.HashMap;
import java.util.Objects;

public class RubyParseTreeListener extends RubyBaseListener {

    private static final HashMap<String, String> tokenTypeMap = new HashMap<>();
    static {
    }

    private final MaskResult maskResult;

    public RubyParseTreeListener(MaskResult maskResult) {
        this.maskResult = maskResult;
    }

    @Override
    public void enterFunction_name(RubyParser.Function_nameContext ctx) {
        String tokenType = "function_name";
        tokenType = tokenTypeMap.getOrDefault(tokenType, tokenType);

        Token tokenValue = null;
        if (Objects.nonNull(ctx.id_function())) tokenValue = ctx.id_function().ID_FUNCTION().getSymbol();
        if (Objects.nonNull(ctx.id_())) tokenValue = ctx.id_().ID().getSymbol();

        this.maskResult.putCode(tokenType, tokenValue.getText(),
                tokenValue.getStartIndex(), tokenValue.getStopIndex());
    }

    @Override
    public void enterLiteral_t(RubyParser.Literal_tContext ctx) {
        String tokenType = "literal_t";
        tokenType = tokenTypeMap.getOrDefault(tokenType, tokenType);

        Token tokenValue = ctx.LITERAL().getSymbol();

        this.maskResult.putCode(tokenType, tokenValue.getText(),
                tokenValue.getStartIndex(), tokenValue.getStopIndex(), "\"", "\"");
    }
}
