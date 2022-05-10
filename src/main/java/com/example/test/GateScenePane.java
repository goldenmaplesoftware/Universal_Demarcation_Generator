package com.example.test;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;


public class GateScenePane extends StackPane
{


    public GateScenePane()
    {

        Text titleName= new Text("Logic Gate Screen");
        ///Title Properties
        titleName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleName.setFill(Color.CYAN);
        titleName.setStroke(Color.BLACK);
        StackPane.setAlignment(titleName, Pos.TOP_CENTER);


        this.getChildren().addAll(titleName);
    }





}
