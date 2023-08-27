package org.tangbean.aicodeinterpretermask.lang.lexer;

import org.antlr.v4.runtime.Lexer;
import org.tangbean.aicodeinterpretermask.lang.Lang;

public class LexerBuilder {

    public static Lexer build(Lang language, String sourceCode) {
        ILexerFactory factory = LexerFactoryMap.getLexerFactory(language);
        return factory.create(sourceCode);
    }
}
