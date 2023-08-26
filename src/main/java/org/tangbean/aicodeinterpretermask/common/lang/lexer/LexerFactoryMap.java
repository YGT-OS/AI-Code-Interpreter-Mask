package org.tangbean.aicodeinterpretermask.common.lang.lexer;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.lang.lexer.factory.JavaLexerFactory;
import org.tangbean.aicodeinterpretermask.common.lang.lexer.factory.RubyLexerFactory;

import java.util.HashMap;
import java.util.Map;

public class LexerFactoryMap {
    private static final Map<Lang, ILexerFactory> factoriesMap = new HashMap<>();
    static {
        factoriesMap.put(Lang.Ruby, new RubyLexerFactory());
        factoriesMap.put(Lang.Java, new JavaLexerFactory());
    }

    public static ILexerFactory getLexerFactory(Lang language) {
        if (language == null || !factoriesMap.containsKey(language)) {
            throw new RuntimeException();
        }
        return factoriesMap.get(language);
    }
}
