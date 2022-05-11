package com.example.test;

import javafx.scene.control.ListView;

public class TruthTableContent
{
    private Double VCC; ///Voltage
    private Double GND; ///Ground
    private Boolean Input_1; ///A
    private Boolean Input_2; ///B
    private Boolean Input_3; ///C
    private Boolean Input_4; ///D
    private Boolean Output;  ///F
    private boolean AND_Input_1;
    private boolean AND_Input_2;
    private boolean AND_Input_3;

    private boolean NAND_Input_1;
    private boolean NAND_Input_2;
    private boolean NAND_Input_3;

    private boolean OR_Input_1;
    private boolean OR_Input_2;
    private boolean OR_Input_3;

    private boolean NOR_Input_1;
    private boolean NOR_Input_2;
    private boolean NOR_Input_3;

    private boolean XOR_Input_1;
    private boolean XOR_Input_2;

    private boolean XNOR_Input_1;
    private boolean XNOR_Input_2;

    private boolean NOT_Input_1;
    private boolean NOT_Output_1;

    ///Inverter Gate
    private final boolean[] Gate_74x04 ={!NOT_Output_1}; ///NOT

    ///2 input 1 output gates
    private final boolean[] Gate_74x00 ={NAND_Input_1,NAND_Input_2}; ///NAND
    private final boolean[] Gate_74x02 ={NOR_Input_1,NOR_Input_2};  ///NOR
    private final boolean[] Gate_74x08 ={AND_Input_1,AND_Input_2};  ///AND
    private final boolean[] Gate_74x32 ={OR_Input_1,OR_Input_2};    ///OR
    private final boolean[] Gate_74x86 ={XOR_Input_1,XOR_Input_2};  ///XOR
    private final boolean[] Gate_74x7266 ={XNOR_Input_1,XNOR_Input_2}; ///XNOR

    ///3 input 1 output gates
    private final boolean[] Gate_74x10 ={NAND_Input_1,NAND_Input_2,NAND_Input_3};  ///NAND
    private final boolean[] Gate_74x11 ={AND_Input_1,AND_Input_2,AND_Input_3};  ///AND
    private final boolean[] Gate_74x27 ={NOR_Input_1,NOR_Input_2,NOR_Input_3};  ///NOR
    private final boolean[] Gate_74x4075 ={OR_Input_1,OR_Input_2,OR_Input_3};    ///OR




}
