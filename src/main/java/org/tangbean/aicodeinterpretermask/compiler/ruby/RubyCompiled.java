package org.tangbean.aicodeinterpretermask.compiler.ruby;

import lombok.Getter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyBaseListener;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyLexer;
import org.tangbean.aicodeinterpretermask.grammers.ruby.RubyParser;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.NumericMaskNameGenerator;

import java.util.Objects;

@Getter
public class RubyCompiled {

    private final RubyParser.ExpressionContext product;
    private final String source;

    public RubyCompiled(String src, RubyParser.ExpressionContext content) {
        this.source = src;
        this.product = content;
    }

    public static RubyCompiled compile(String sourceCode) {
        RubyLexer lexer = new RubyLexer(CharStreams.fromString(sourceCode));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        tokenStream.fill();
        for (Token token : tokenStream.getTokens()) {
            String tokenType = lexer.getVocabulary().getSymbolicName(token.getType());
//            System.out.printf("Token: %-15s Type: %-15s Start: %d, Stop: %d\n",
//                    token.getText(), tokenType, token.getStartIndex(), token.getStopIndex());
        }

        RubyParser parser = new RubyParser(tokenStream);
        // Parse the input
        RubyParser.ProgContext tree = parser.prog();

        // Walk the parse tree and print function names
        ParseTreeWalker walker = new ParseTreeWalker();

        MaskResult maskResult = new MaskResult(sourceCode, new NumericMaskNameGenerator());
        RubyMaskListener listener = new RubyMaskListener(maskResult);
        walker.walk(listener, tree);

        maskResult.buildMaskedCode();

        System.out.println(maskResult.getSourceCode());
        System.out.println(maskResult.getMaskedCode());
        System.out.println(maskResult.getCodeBook());
        System.out.println(maskResult.getMaskBook());

        return new RubyCompiled(sourceCode, parser.expression());
    }

}
