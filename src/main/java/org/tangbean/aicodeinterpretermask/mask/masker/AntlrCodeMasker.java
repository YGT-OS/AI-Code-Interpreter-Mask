package org.tangbean.aicodeinterpretermask.mask.masker;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.common.lang.lexer.LexerBuilder;
import org.tangbean.aicodeinterpretermask.common.lang.tokenlistener.ParseTokenListenerBuilder;
import org.tangbean.aicodeinterpretermask.common.lang.tree.ParseTreeBuilder;
import org.tangbean.aicodeinterpretermask.common.lang.treelistener.ParseTreeListenerBuilder;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenListener;
import org.tangbean.aicodeinterpretermask.common.token.ParseTokenWalker;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.MaskNameGenerator;

public class AntlrCodeMasker implements CodeMasker {

    @Override
    public MaskResult mask(String sourceCode, Lang language, MaskNameGenerator maskNameGenerator) {
        MaskResult maskResult = new MaskResult(sourceCode, maskNameGenerator);

        ParseTokenListener parseTokenListener = ParseTokenListenerBuilder.build(language, maskResult);
        Lexer lexer = LexerBuilder.build(language, sourceCode);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        ParseTokenWalker.DEFAULT.walk(parseTokenListener, tokenStream, lexer.getVocabulary());

        // Parse the input
        ParseTreeListener parseTreeListener = ParseTreeListenerBuilder.build(language, maskResult);
        ParseTree tree = ParseTreeBuilder.build(language, tokenStream);

        // Walk the parse tree and print function names
        ParseTreeWalker.DEFAULT.walk(parseTreeListener, tree);

        maskResult.buildMaskedCode();

        return maskResult;
    }
}
