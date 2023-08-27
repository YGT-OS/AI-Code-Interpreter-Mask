package org.tangbean.aicodeinterpretermask.lang.tokenlistener.factory;

import org.tangbean.aicodeinterpretermask.lang.tokenlistener.IParseTokenListenerFactory;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.lang.maskrule.java.JavaParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class JavaParseTokenListenerFactory implements IParseTokenListenerFactory {
    @Override
    public ParseTokenListener create(MaskResult maskResult) {
        return new JavaParseTokenListener(maskResult);
    }
}
