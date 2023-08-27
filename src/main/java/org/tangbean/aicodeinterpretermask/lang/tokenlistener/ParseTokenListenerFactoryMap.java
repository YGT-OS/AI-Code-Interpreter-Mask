package org.tangbean.aicodeinterpretermask.lang.tokenlistener;

import org.tangbean.aicodeinterpretermask.lang.Lang;
import org.tangbean.aicodeinterpretermask.lang.tokenlistener.factory.JavaParseTokenListenerFactory;
import org.tangbean.aicodeinterpretermask.lang.tokenlistener.factory.RubyParseTokenListenerFactory;

import java.util.HashMap;
import java.util.Map;

public class ParseTokenListenerFactoryMap {
    private static final Map<Lang, IParseTokenListenerFactory> factoriesMap = new HashMap<>();
    static {
        factoriesMap.put(Lang.Ruby, new RubyParseTokenListenerFactory());
        factoriesMap.put(Lang.Java, new JavaParseTokenListenerFactory());
    }

    public static IParseTokenListenerFactory getParseTokenListenerFactory(Lang language) {
        if (language == null || !factoriesMap.containsKey(language)) {
            throw new RuntimeException();
        }
        return factoriesMap.get(language);
    }
}
