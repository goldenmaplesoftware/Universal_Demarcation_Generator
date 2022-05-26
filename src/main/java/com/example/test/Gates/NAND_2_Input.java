package com.example.test.Gates;

import com.example.test.TruthTableContent;

public class NAND_2_Input<O, O1, O2, O3> extends TruthTableContent {
    private static String gateName="NAND Gate 2-Input";
    private static int gateNumber;
    private static boolean inputA; //1A
    private static boolean inputB; //1B
    private boolean outputY;       //1Y

    public NAND_2_Input(String gateName, int gateNumber, boolean inputA, boolean inputB, boolean b)
    {
        super();
        NAND_2_Input.gateName =gateName;
        NAND_2_Input.gateNumber = gateNumber;
        NAND_2_Input.inputA = inputA;
        NAND_2_Input.inputB = inputB;
    }

    public static int gateNumberOutput()
    {
        return gateNumber;
    }
    public static String gateName()
    {
        return gateName;
    }

    public static boolean gateInputA() {
        return inputA;
    }

    public static boolean gateInputB() {
        return inputB;
    }

    public static boolean gateOutputY() {
        return NAND_2_Output();
    }

    public static boolean NAND_2_Output()
    {
        //1Y
        boolean outputY = (!(inputA && inputB));
        int pin1_Convert = inputA? 1 : 0;
        int pin2_Convert = inputB? 1 : 0;
        int pin3_Convert = outputY ? 1 : 0;
        return outputY;
    }


    public Boolean NAND_2_Input_A()
    {
        return inputA;
    }
    public Boolean NAND_2_Input_B()
    {
        return inputA;
    }
}
