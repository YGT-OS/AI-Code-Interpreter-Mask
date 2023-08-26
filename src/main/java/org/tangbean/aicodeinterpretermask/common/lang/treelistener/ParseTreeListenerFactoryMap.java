package org.tangbean.aicodeinterpretermask.common.lang.treelistener;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.lang.treelistener.factory.JavaParseTreeListenerFactory;
import org.tangbean.aicodeinterpretermask.common.lang.treelistener.factory.RubyParseTreeListenerFactory;

import java.util.HashMap;
import java.util.Map;

public class ParseTreeListenerFactoryMap {
    private static final Map<Lang, IParseTreeListenerFactory> factoriesMap = new HashMap<>();
    static {
        factoriesMap.put(Lang.Ruby, new RubyParseTreeListenerFactory());
        factoriesMap.put(Lang.Java, new JavaParseTreeListenerFactory());
    }

    public static IParseTreeListenerFactory getParseTreeListener(Lang language) {
        if (language == null || !factoriesMap.containsKey(language)) {
            throw new RuntimeException();
        }
        return factoriesMap.get(language);
    }
}
