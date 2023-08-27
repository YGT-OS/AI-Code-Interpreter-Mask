package org.tangbean.aicodeinterpretermask.lang.maskrule.python3;

import org.tangbean.aicodeinterpretermask.grammers.java.JavaParser;
import org.tangbean.aicodeinterpretermask.grammers.java.JavaParserBaseListener;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

import java.util.HashMap;

public class Python3ParseTreeListener extends JavaParserBaseListener {

    private static final HashMap<String, String> tokenTypeMap = new HashMap<>();
    static {
    }

    private final MaskResult maskResult;

    public Python3ParseTreeListener(MaskResult maskResult) {
        this.maskResult = maskResult;
    }

    @Override
    public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
        super.enterVariableDeclaratorId(ctx);
    }
}
