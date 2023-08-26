package org.tangbean.aicodeinterpretermask.common.lang.lexer.factory;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.tangbean.aicodeinterpretermask.common.lang.lexer.ILexerFactory;
import org.tangbean.aicodeinterpretermask.grammers.java.JavaLexer;

public class JavaLexerFactory implements ILexerFactory {

    @Override
    public Lexer create(String sourceCode) {
        return new JavaLexer(CharStreams.fromString(sourceCode));
    }
}