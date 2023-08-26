package org.tangbean.aicodeinterpretermask.demo;

import org.junit.jupiter.api.Test;
import org.tangbean.aicodeinterpretermask.mask.masker.AntlrCodeMasker;
import org.tangbean.aicodeinterpretermask.mask.masker.CodeMasker;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.NumericMaskNameGenerator;
import org.tangbean.aicodeinterpretermask.utils.TestPrintUtils;

public class JavaMaskTest {

    @Test
    void test_CodeMaskerMask_success() {
        String source =
                "public class RubyMaskTest {\n" +
                "\n" +
                "    @Test\n" +
                "    void test_CodeMaskerMask_success() {\n" +
                "        String source =\n" +
                "                \"      def add_action_mailbox_production_environment_config\\n\" +\n" +
                "                \"        str_a = \\\"This is a string\\\"\\n\" +\n" +
                "                \"        environment <<~end_of_config, env: \\\"production\\\"\\n\" +\n" +
                "                \"          # Prepare the ingress controller used to receive mail\\n\" +\n" +
                "                \"          # config.action_mailbox.ingress = :relay\\n\" +\n" +
                "                \"        end_of_config\\n\" +\n" +
                "                \"      end\";\n" +
                "\n" +
                "        CodeMasker codeMasker = new AntlrCodeMasker();\n" +
                "        MaskResult maskResult = codeMasker.mask(source, \"ruby\", new NumericMaskNameGenerator());\n" +
                "\n" +
                "        TestPrintUtils.printMaskResult(maskResult);\n" +
                "\n" +
                "        test1();\n" +
                "    }\n" +
                "    \n" +
                "    void test1() {\n" +
                "        System.out.println(\"Enter test1 method\");\n" +
                "    }\n" +
                "}";

        CodeMasker codeMasker = new AntlrCodeMasker();
        MaskResult maskResult = codeMasker.mask(source, "java", new NumericMaskNameGenerator());

        TestPrintUtils.printMaskResult(maskResult);
    }
}
