package org.tangbean.aicodeinterpretermask.common.token;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

public class ParseTokenWalker {
    public static final ParseTokenWalker DEFAULT = new ParseTokenWalker();

    public void walk(ParseTokenListener listener, CommonTokenStream tokenStream, Vocabulary vocabulary) {
        tokenStream.fill();
        for (Token token : tokenStream.getTokens()) {
            String tokenType = vocabulary.getSymbolicName(token.getType());
            listener.enterToken(tokenType, token);
        }
    }
}
