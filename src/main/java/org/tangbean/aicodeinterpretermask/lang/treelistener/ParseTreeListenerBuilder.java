package org.tangbean.aicodeinterpretermask.lang.treelistener;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.tangbean.aicodeinterpretermask.lang.Lang;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class ParseTreeListenerBuilder {

    public static ParseTreeListener build(Lang languagea, MaskResult maskResult) {
        IParseTreeListenerFactory factory = ParseTreeListenerFactoryMap.getParseTreeListener(languagea);
        return factory.create(maskResult);
    }
}
