package org.tangbean.aicodeinterpretermask.common.lang.treelistener;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public interface IParseTreeListenerFactory {
    ParseTreeListener create(MaskResult maskResult);
}
