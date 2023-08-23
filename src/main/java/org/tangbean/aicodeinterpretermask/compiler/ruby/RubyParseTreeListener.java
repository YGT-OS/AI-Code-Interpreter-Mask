package org.tangbean.aicodeinterpretermask.compiler.ruby;

import org.antlr.v4.runtime.Token;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyBaseListener;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyParser;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

import java.util.Objects;

public class RubyParseTreeListener extends RubyBaseListener {
    private final MaskResult maskResult;

    public RubyParseTreeListener(MaskResult maskResult) {
        this.maskResult = maskResult;
    }

    @Override
    public void enterFunction_name(RubyParser.Function_nameContext ctx) {
        Token tokenValue = null;
        if (Objects.nonNull(ctx.id_function())) tokenValue = ctx.id_function().ID_FUNCTION().getSymbol();
        if (Objects.nonNull(ctx.id_())) tokenValue = ctx.id_().ID().getSymbol();
        this.maskResult.putCode("function_name", tokenValue.getText(),
                tokenValue.getStartIndex(), tokenValue.getStopIndex());
    }
}
