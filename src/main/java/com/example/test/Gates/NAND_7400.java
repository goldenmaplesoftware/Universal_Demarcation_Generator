package com.example.test.Gates;

public class NAND_7400 <GateNumber,Input_1A,Input_1B,Output_1Y,Input_2A,Input_2B,Output_2Y,Input_3A,Input_3B,Output_3Y,Input_4A,Input_4B,Output_4Y,Ground,Voltage>
{

    private final boolean pin1; //1A
    private final boolean pin2; //1B

    private final int ICNumber;


    private final boolean pin4; //2A
    private final boolean pin5; //2B
    private final double pin7;
    private boolean pin6;       //2Y

    private final boolean pin8; //3A
    private final boolean pin9; //3B
    private boolean pin10;       //3Y

    private final boolean pin11; //4A
    private final boolean pin12; //4B
    private boolean pin13;       //4Y


    private double pin14 = 0;
    private static final String ICName="74LS00 Quad 2-Input NAND Gate";

    public static String ICName()
    {
        System.out.println(ICName);
        return ICName;
    }

    public NAND_7400(String ICName,int ICNumber, boolean pin1, boolean pin2, boolean pin4, boolean pin5, double pin7, boolean pin8, boolean pin9, boolean pin11, boolean pin12, double pin14) {
        this.ICNumber=ICNumber;
        this.pin1 = pin1;
        this.pin2 = pin2;
        this.pin4 = pin4;
        this.pin5 = pin5;
        this.pin7 = pin7;
        this.pin8 = pin8;
        this.pin9 = pin9;
        this.pin11 = pin11;
        this.pin12 = pin12;
        this.pin14 = pin14;
    }


    public int gateNumberOutput()
    {
        System.out.println("IC number inputted:"+ICNumber);
        return ICNumber;
    }

    public double voltageInput()
    {
        System.out.println("Voltage inputted on"+ICNumber+"="+pin14);
        return pin14;
    }

    public double groundOutput()
    {
        System.out.println("Ground output on"+ICNumber+"="+pin7);
        return pin7;
    }

    public void gateOutput_1Y()
    {
        //1Y
        boolean pin3 = (!(pin1 && pin2));
        System.out.println("\n1A^1B=1Y\n"+pin1+"^"+pin2+"="+ pin3);

        int pin1_Convert = pin1? 1 : 0;
        int pin2_Convert = pin2? 1 : 0;
        int pin3_Convert = pin3 ? 1 : 0;
        System.out.println("\n1A^1B=1Y\n"+pin1_Convert+"^"+pin2_Convert+"="+pin3_Convert);
    }

    public void gateOutput_2Y()
    {
        pin6 = (!(pin4 && pin5));
        System.out.println("\n2A^2B=2Y\n"+pin4+"^"+pin5+"="+pin6);
        int pin4_Convert = pin4? 1 : 0;
        int pin5_Convert = pin5? 1 : 0;
        int pin6_Convert = pin6? 1 : 0;
        System.out.println("\n2A^2B=2Y\n"+pin4_Convert+"^"+pin5_Convert+"="+pin6_Convert);
    }

    public void gateOutput_3Y()
    {
        pin10 = (!(pin8 && pin9));
        System.out.println("\n3A^3B=3Y\n"+pin8+"^"+pin9+"="+pin10);
        int pin8_Convert = pin8? 1 : 0;
        int pin9_Convert = pin9? 1 : 0;
        int pin10_Convert = pin10? 1 : 0;
        System.out.println("\n3A^3B=3Y\n"+pin8_Convert+"^"+pin9_Convert+"="+pin10_Convert);
    }

    public void gateOutput_4Y()
    {
        pin13 = (!(pin11 && pin12));
        System.out.println("\n4A^4B=4Y\n"+pin11+"^"+pin12+"="+pin13);
        int pin11_Convert = pin11? 1 : 0;
        int pin12_Convert = pin12? 1 : 0;
        int pin13_Convert = pin13? 1 : 0;
        System.out.println("\n4A^4B=4Y\n"+pin11_Convert+"^"+pin12_Convert+"="+pin13_Convert);
    }

}
