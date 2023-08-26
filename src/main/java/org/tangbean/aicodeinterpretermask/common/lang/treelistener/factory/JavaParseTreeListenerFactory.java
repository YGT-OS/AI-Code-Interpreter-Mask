package org.tangbean.aicodeinterpretermask.common.lang.treelistener.factory;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.tangbean.aicodeinterpretermask.common.lang.treelistener.IParseTreeListenerFactory;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.maskrule.java.JavaParseTreeListener;

public class JavaParseTreeListenerFactory implements IParseTreeListenerFactory {

    @Override
    public ParseTreeListener create(MaskResult maskResult) {
        return new JavaParseTreeListener(maskResult);
    }
}
