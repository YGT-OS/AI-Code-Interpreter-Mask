package org.tangbean.aicodeinterpretermask.maskrule.java;

import org.tangbean.aicodeinterpretermask.grammers.java.JavaParser;
import org.tangbean.aicodeinterpretermask.grammers.java.JavaParserBaseListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

import java.util.HashMap;

public class JavaParseTreeListener extends JavaParserBaseListener {

    private static final HashMap<String, String> tokenTypeMap = new HashMap<>();
    static {
    }

    private final MaskResult maskResult;

    public JavaParseTreeListener(MaskResult maskResult) {
        this.maskResult = maskResult;
    }

    @Override
    public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
        super.enterVariableDeclaratorId(ctx);
    }
}
