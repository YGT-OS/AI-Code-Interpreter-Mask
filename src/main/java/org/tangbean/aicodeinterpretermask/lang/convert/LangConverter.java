package org.tangbean.aicodeinterpretermask.lang.convert;

import org.apache.commons.lang3.StringUtils;
import org.tangbean.aicodeinterpretermask.lang.Lang;

import java.util.HashMap;
import java.util.Map;

public class LangConverter {

    private static final Map<String, Lang> language2LangMap = new HashMap<>();
    static {
        language2LangMap.put("ruby", Lang.Ruby);
        language2LangMap.put("rb", Lang.Ruby);
        language2LangMap.put("java", Lang.Java);
        language2LangMap.put("python3", Lang.Python3);
        language2LangMap.put("py3", Lang.Python3);
    }

    public static Lang convert(String language) {
        if (StringUtils.isBlank(language)) {
            throw new RuntimeException("language is blank, language: " + language);
        }
        language = language.toLowerCase();
        if (!language2LangMap.containsKey(language)) {
            throw new RuntimeException("Invaild language input, language: " + language);
        }
        return language2LangMap.get(language);
    }
}
