package org.tangbean.aicodeinterpretermask;

import org.tangbean.aicodeinterpretermask.compiler.ruby.RubyCompiled;

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
        RubyCompiled compiled = RubyCompiled.compile(source);
        System.out.println("==================== Main End   ====================\n");
    }
}
