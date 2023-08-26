package org.tangbean.aicodeinterpretermask.common.lang.tree;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.lang.tree.factory.JavaParseTreeFactory;
import org.tangbean.aicodeinterpretermask.common.lang.tree.factory.RubyParseTreeFactory;

import java.util.HashMap;
import java.util.Map;

public class ParseTreeFactoryMap {
    private static final Map<Lang, IParseTreeFactory> factoriesMap = new HashMap<>();
    static {
        factoriesMap.put(Lang.Ruby, new RubyParseTreeFactory());
        factoriesMap.put(Lang.Java, new JavaParseTreeFactory());
    }

    public static IParseTreeFactory getParseTreeFactory(Lang language) {
        if (language == null || !factoriesMap.containsKey(language)) {
            throw new RuntimeException();
        }
        return factoriesMap.get(language);
    }
}
