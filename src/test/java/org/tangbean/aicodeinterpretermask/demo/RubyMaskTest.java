package org.tangbean.aicodeinterpretermask.demo;

import org.junit.jupiter.api.Test;
import org.tangbean.aicodeinterpretermask.mask.masker.AntlrCodeMasker;
import org.tangbean.aicodeinterpretermask.mask.masker.CodeMasker;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.NumericMaskNameGenerator;
import org.tangbean.aicodeinterpretermask.utils.TestPrintUtils;

public class RubyMaskTest {

    @Test
    void test_CodeMaskerMask_success() {
        String source =
                "      def add_action_mailbox_production_environment_config\n" +
                "        str_a = \"This is a string\"\n" +
                "        environment <<~end_of_config, env: \"production\"\n" +
                "          # Prepare the ingress controller used to receive mail\n" +
                "          # config.action_mailbox.ingress = :relay\n" +
                "        end_of_config\n" +
                "      end";

        CodeMasker codeMasker = new AntlrCodeMasker();
        MaskResult maskResult = codeMasker.mask(source, "ruby", new NumericMaskNameGenerator());

        TestPrintUtils.printMaskResult(maskResult);
    }
}
