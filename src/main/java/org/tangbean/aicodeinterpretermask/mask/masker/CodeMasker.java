package org.tangbean.aicodeinterpretermask.mask.masker;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.MaskNameGenerator;

public interface CodeMasker {
    MaskResult mask(String sourceCode, Lang language, MaskNameGenerator maskNameGenerator);
}
