package org.tangbean.aicodeinterpretermask.mask.masker;

import org.tangbean.aicodeinterpretermask.lang.Lang;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.common.maskname.MaskNameGenerator;

public interface CodeMasker {
    MaskResult mask(String sourceCode, Lang lang, MaskNameGenerator maskNameGenerator);
    MaskResult mask(String sourceCode, String language, MaskNameGenerator maskNameGenerator);
}
