package org.tangbean.aicodeinterpretermask.common.lang.tokenlistener.factory;

import org.tangbean.aicodeinterpretermask.common.lang.tokenlistener.IParseTokenListenerFactory;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.maskrule.java.JavaParseTokenListener;

public class JavaParseTokenListenerFactory implements IParseTokenListenerFactory {
    @Override
    public ParseTokenListener create(MaskResult maskResult) {
        return new JavaParseTokenListener(maskResult);
    }
}
