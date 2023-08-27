package org.tangbean.aicodeinterpretermask.lang.lexer.factory;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.tangbean.aicodeinterpretermask.lang.lexer.ILexerFactory;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyLexer;

public class RubyLexerFactory implements ILexerFactory {

    @Override
    public Lexer create(String sourceCode) {
        return new RubyLexer(CharStreams.fromString(sourceCode));
    }
}
