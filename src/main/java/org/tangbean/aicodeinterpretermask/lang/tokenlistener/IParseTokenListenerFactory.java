package org.tangbean.aicodeinterpretermask.lang.tokenlistener;

import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public interface IParseTokenListenerFactory {
    ParseTokenListener create(MaskResult maskResult);
}
