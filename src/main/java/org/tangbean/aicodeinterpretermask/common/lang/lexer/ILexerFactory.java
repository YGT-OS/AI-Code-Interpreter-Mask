package org.tangbean.aicodeinterpretermask.common.lang.lexer;

import org.antlr.v4.runtime.Lexer;

public interface ILexerFactory {
    Lexer create(String sourceCode);
}
