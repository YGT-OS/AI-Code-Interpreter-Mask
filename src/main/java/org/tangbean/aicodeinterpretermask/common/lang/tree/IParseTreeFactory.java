package org.tangbean.aicodeinterpretermask.common.lang.tree;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public interface IParseTreeFactory {
    ParseTree create(CommonTokenStream tokenStream);
}
