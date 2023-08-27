package org.tangbean.aicodeinterpretermask.lang.tree;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tangbean.aicodeinterpretermask.lang.Lang;

public class ParseTreeBuilder {

    public static ParseTree build(Lang language, CommonTokenStream tokenStream) {
        IParseTreeFactory factory = ParseTreeFactoryMap.getParseTreeFactory(language);
        return factory.create(tokenStream);
    }
}
