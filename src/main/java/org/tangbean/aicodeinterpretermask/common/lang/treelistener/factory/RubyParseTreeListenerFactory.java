package org.tangbean.aicodeinterpretermask.common.lang.treelistener.factory;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.tangbean.aicodeinterpretermask.common.lang.treelistener.IParseTreeListenerFactory;
import org.tangbean.aicodeinterpretermask.compiler.ruby.RubyParseTreeListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class RubyParseTreeListenerFactory implements IParseTreeListenerFactory {

    @Override
    public ParseTreeListener create(MaskResult maskResult) {
        return new RubyParseTreeListener(maskResult);
    }
}
