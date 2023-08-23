package org.tangbean.aicodeinterpretermask.common.lang.tokenlistener;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class ParseTokenListenerBuilder {

    public static ParseTokenListener build(Lang language, MaskResult maskResult) {
        IParseTokenListenerFactory factory = ParseTokenListenerFactoryMap.getParseTokenListenerFactory(language);
        return factory.create(maskResult);
    }
}
