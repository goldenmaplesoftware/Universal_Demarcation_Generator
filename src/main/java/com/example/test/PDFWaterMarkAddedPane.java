package com.example.test;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class PDFWaterMarkAddedPane extends StackPane
{
    private ListView<String> listView;
    private Button selectSingleFile=new Button("Single File Browse");
    private Button selectBatchFile=new Button("Batch File Browse");
    private Button selectPDFFile= new Button("Single PDF Create");
    private String sourceDirectory;
    private String fileNameInputted; ///File name that user inputs

    private Label fileToInputLabel = new Label("Input file name");
    private TextField fileToInputTextField = new TextField();
    private Text name = new Text("Smart Tracker");
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);

    private VBox buttonView =new VBox(selectSingleFile,selectBatchFile,selectPDFFile);
    protected TextField tfTextField = new TextField();
    protected TextField tfColumnSize = new TextField();
    public PDFWaterMarkAddedPane() {
        name.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45));
        name.setFill(Color.RED);
        StackPane.setAlignment(name, Pos.TOP_CENTER);
        this.getChildren().addAll(name, buttonView);

    }

}
