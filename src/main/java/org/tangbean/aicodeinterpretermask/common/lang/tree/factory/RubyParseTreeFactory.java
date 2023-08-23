package org.tangbean.aicodeinterpretermask.common.lang.tree.factory;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tangbean.aicodeinterpretermask.common.lang.tree.IParseTreeFactory;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyParser;

public class RubyParseTreeFactory implements IParseTreeFactory {

    @Override
    public ParseTree create(CommonTokenStream tokenStream) {
        return new RubyParser(tokenStream).prog();
    }
}
