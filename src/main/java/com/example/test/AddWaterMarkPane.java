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


public class AddWaterMarkPane extends StackPane
{
    private ListView<String> listView;
    private Button selectSingleFile=new Button("Exit Application");
    private Button selectBatchFile=new Button("Batch File Browse");
    private Button selectPDFFile= new Button("Single PDF Create");
    private String sourceDirectory;
    private String fileNameInputted; ///File name that user inputs

    private Label fileToInputLabel = new Label("Input file name");
    private TextField fileToInputTextField = new TextField(fileNameInputted);
    private Text name = new Text("Smart Tracker");
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text printSourceOnScreen2 = new Text(fileNameInputted+" was saved");
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);


    private VBox buttonView =new VBox();

    public AddWaterMarkPane()
    {

        Text titleName= new Text("Add Watermark To File");
        ///Title Properties
        titleName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleName.setFill(Color.CYAN);
        titleName.setStroke(Color.BLACK);
        StackPane.setAlignment(titleName, Pos.TOP_CENTER);

        printSourceOnScreenTitle.setVisible(false);
        printSourceOnScreenTitle.setTranslateY(200);

        printSourceOnScreen.setVisible(false);
        printSourceOnScreen.setTranslateX(0);
        printSourceOnScreen.setTranslateY(150);

        printSourceOnScreen2.setVisible(false);
        printSourceOnScreen2.setTranslateX(0);
        printSourceOnScreen2.setTranslateY(300);

        selectPDFFile.setVisible(false);

        ///Select Single
        selectSingleFile.styleProperty().bind(Bindings.when(selectSingleFile.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        ///Select Batch
        selectBatchFile.styleProperty().bind(Bindings.when(selectBatchFile.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        ///Select PDF File
        selectPDFFile.styleProperty().bind(Bindings.when(selectPDFFile.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));


            System.out.println("Browse for single file was clicked.");
                fileToInputTextField.setAlignment(Pos.BOTTOM_LEFT);
                fileToInputTextField.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.ENTER)
                    {
                        System.out.println("Enter was pressed");
                        Color colourSourcePrint2= Color.RED;
                        printSourceOnScreen2.setFill(colourSourcePrint2);
                        printSourceOnScreen2.setFont(Font.font("System",FontWeight.BOLD, 18));
                        System.out.println("Create PDF File.");
                        System.out.println("This creates a blank PDF");
                        String fileName=fileToInputTextField.getText()+".pdf";

                        printSourceOnScreen2.setText(fileToInputTextField.getText()+" was successfully created!!!");
                        printSourceOnScreen.setVisible(true);
                        printSourceOnScreenTitle.setVisible(true);
                        selectPDFFile.setVisible(true);
                        Color colourSourcePrint= Color.RED;
                        printSourceOnScreen.setFill(colourSourcePrint);
                        printSourceOnScreen.setFont(Font.font("System",FontWeight.BOLD, 14));
                        System.out.println("Single file selection is valid");

                        try
                        {
                            PDDocument doc=new PDDocument();
                            doc.addPage(new PDPage()); ///Duplicate to make multiple pages in single document!
                            doc.addPage(new PDPage());
                            doc.save(fileName);
                            doc.close();
                            System.out.println("File has been created!");
                            time();
                        }

                        catch (IOException | InterruptedException ex)
                        {
                            throw new RuntimeException(ex);
                        }

                    }
                        else
                        {
                            System.out.println("Try again.");
                        }


                });
                HBox hbox = new HBox(10);
                VBox pane = new VBox(10);
                pane.setPadding(new Insets(325, 480, 415, 485));
                pane.getChildren().addAll(fileToInputTextField, hbox);
                this.getChildren().add(pane);
                System.out.println("Single file selection is invalid!");



        buttonView.setFillWidth(false);
        buttonView.setAlignment(Pos.CENTER);
        buttonView.setSpacing(15);
        buttonView.setPadding(new Insets(10, 10, 10, 10));

        this.getChildren().addAll(printSourceOnScreen2);
        this.getChildren().addAll(titleName,buttonView);
        this.getChildren().addAll(printSourceOnScreen,printSourceOnScreenTitle);
    }


    public void time() throws InterruptedException {
        selectSingleFile.setVisible(true);
        selectSingleFile.setAlignment(Pos.BOTTOM_LEFT);
        selectSingleFile.setOnAction(actionEvent ->
        {
        System.exit(0);
            System.out.println("Process terminated");

        });
        printSourceOnScreen2.setVisible(true);
        Thread.sleep(1500);

        this.getChildren().add(selectSingleFile);



    }




}
