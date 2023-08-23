package org.tangbean.aicodeinterpretermask;

import org.tangbean.aicodeinterpretermask.common.lang.Lang;
import org.tangbean.aicodeinterpretermask.mask.masker.AntlrCodeMasker;
import org.tangbean.aicodeinterpretermask.mask.masker.CodeMasker;
import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;
import org.tangbean.aicodeinterpretermask.mask.utils.NumericMaskNameGenerator;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n==================== Main Start ====================");
        String source = "      def add_action_mailbox_production_environment_config\n" +
                "        environment <<~end_of_config, env: \"production\"\n" +
                "          # Prepare the ingress controller used to receive mail\n" +
                "          # config.action_mailbox.ingress = :relay\n" +
                "\n" +
                "        end_of_config\n" +
                "      end";

        CodeMasker codeMasker = new AntlrCodeMasker();
        MaskResult maskResult = codeMasker.mask(source, Lang.Ruby, new NumericMaskNameGenerator());

        System.out.println(maskResult.getSourceCode());
        System.out.println(maskResult.getMaskedCode());
        System.out.println(maskResult.getCodeBook());
        System.out.println(maskResult.getMaskBook());
        System.out.println("==================== Main End   ====================\n");
    }
}
