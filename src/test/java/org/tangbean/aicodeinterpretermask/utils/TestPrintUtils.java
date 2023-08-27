package org.tangbean.aicodeinterpretermask.utils;

import org.tangbean.aicodeinterpretermask.mask.model.MaskResult;

public class TestPrintUtils {

    public static void printMaskResult(MaskResult maskResult) {
        System.out.println("=========================== Start ===========================");
        System.out.println(maskResult.getSourceCode());
        System.out.println("-------------------------------------------------------------");
        System.out.println(maskResult.getMaskedCode());
        System.out.println("-------------------------------------------------------------");
        System.out.println(maskResult.getPrettyCodeBook());
        System.out.println("-------------------------------------------------------------");
        System.out.println(maskResult.getPrettyMaskBook());
        System.out.println("===========================  End  ===========================");
    }
}
