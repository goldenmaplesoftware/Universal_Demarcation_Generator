package com.example.test.Gates;

public class NAND_2_Input<O, O1, O2, O3> {
    private static String gateName="NAND Gate 2-Input";
    private final int gateNumber;
    private final boolean inputA; //1A
    private final boolean inputB; //1B
    private boolean outputY;       //1Y

    public NAND_2_Input(String gateName, int gateNumber, boolean inputA, boolean inputB, boolean b)
    {
        this.gateName=gateName;
        this.gateNumber = gateNumber;
        this.inputA = inputA;
        this.inputB = inputB;
    }

    public int gateNumberOutput()
    {
        System.out.println("Gate number inputted:"+gateNumber);
        return gateNumber;
    }
    public static String gateName()
    {
        System.out.println(gateName);
        return gateName;
    }

    public boolean NAND_2_Output()
    {
        //1Y
        boolean outputY = (!(inputA && inputB));
        System.out.println("\n"+gateNumber+"!A^"+gateNumber+"!B="+gateNumber+"Y!\n"+(inputA+"^"+(inputB+"="+ outputY)));
        int pin1_Convert = inputA? 1 : 0;
        int pin2_Convert = inputB? 1 : 0;
        int pin3_Convert = outputY ? 1 : 0;
        System.out.println("\n"+gateNumber+"!A^"+gateNumber+"!B="+gateNumber+"Y!\n"+((pin1_Convert+"^"+pin2_Convert+"="+pin3_Convert)));
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
