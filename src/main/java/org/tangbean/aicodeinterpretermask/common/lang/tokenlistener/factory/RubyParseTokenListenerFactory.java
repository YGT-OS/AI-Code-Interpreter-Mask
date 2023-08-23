package org.tangbean.aicodeinterpretermask.common.lang.tokenlistener.factory;

import org.tangbean.aicodeinterpretermask.common.lang.tokenlistener.IParseTokenListenerFactory;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.compiler.ruby.RubyParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class RubyParseTokenListenerFactory implements IParseTokenListenerFactory {
    @Override
    public ParseTokenListener create(MaskResult maskResult) {
        return new RubyParseTokenListener(maskResult);
    }
}
