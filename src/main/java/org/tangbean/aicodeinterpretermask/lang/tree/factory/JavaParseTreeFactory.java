package org.tangbean.aicodeinterpretermask.lang.tree.factory;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tangbean.aicodeinterpretermask.lang.tree.IParseTreeFactory;
import org.tangbean.aicodeinterpretermask.grammers.java.JavaParser;

public class JavaParseTreeFactory implements IParseTreeFactory {

    @Override
    public ParseTree create(CommonTokenStream tokenStream) {
        return new JavaParser(tokenStream).compilationUnit();
    }
}
