package org.tangbean.aicodeinterpretermask.mask.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.Pair;
import org.tangbean.aicodeinterpretermask.mask.utils.MaskNameGenerator;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MaskResult {
    /**
     * Source code, code before mask, can not be sent to AI tools directly
     */
    private final String sourceCode;

    /**
     * Masked code, code after mask, can be sent to AI tools
     */
    private String maskedCode;

    /**
     * Map<maskedValue, replacedValue>
     * replacedValue = rawTokenValue
     */
    private final Map<String, String> codeBook;

    /**
     * Map<startIndex, Pair<endIndex, maskedValue>>
     */
    private final Map<Integer, Pair<Integer, String>> maskBook;

    private final Gson gson;

    private final MaskNameGenerator maskNameGenerator;

    public MaskResult(String sourceCode, MaskNameGenerator maskNameGenerator) {
        this.sourceCode = sourceCode;
        this.maskNameGenerator = maskNameGenerator;
        this.codeBook = new HashMap<>();
        this.maskBook = new HashMap<>();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void putCode(String tokenType, String tokenValue, int start, int end, String prefix, String suffix) {
        String maskName = this.maskNameGenerator.getMaskName(tokenType, tokenValue);
        if (prefix != null) {
            maskName = prefix + maskName;
        }
        if (suffix != null) {
            maskName = maskName + suffix;
        }
        codeBook.put(maskName, tokenValue);
        maskBook.put(start, new Pair<>(end, maskName));
    }

    public void putCode(String tokenType, String tokenValue, int start, int end) {
        putCode(tokenType, tokenValue, start, end, null, null);
    }

    public void buildMaskedCode() {
        StringBuilder res = new StringBuilder();
        char[] sourceCodeArr = sourceCode.toCharArray();
        for (int i = 0; i < sourceCodeArr.length; i++) {
            if (maskBook.containsKey(i)) {
                Pair<Integer, String> pair = maskBook.get(i);
                res.append(pair.b);
                i = pair.a;
            } else {
                res.append(sourceCodeArr[i]);
            }
        }
        this.maskedCode = res.toString();
    }

    public String getPrettyCodeBook() {
        return gson.toJson(codeBook);
    }

    public String getPrettyMaskBook() {
        return gson.toJson(maskBook);
    }
}
