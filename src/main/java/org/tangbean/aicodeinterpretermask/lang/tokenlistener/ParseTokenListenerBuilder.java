package org.tangbean.aicodeinterpretermask.lang.tokenlistener;

import org.tangbean.aicodeinterpretermask.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class ParseTokenListenerBuilder {

    public static ParseTokenListener build(Lang language, MaskResult maskResult) {
        IParseTokenListenerFactory factory = ParseTokenListenerFactoryMap.getParseTokenListenerFactory(language);
        return factory.create(maskResult);
    }
}
