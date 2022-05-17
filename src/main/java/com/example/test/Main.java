package com.example.test;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application
{
    private Button selectSingleFile=new Button("Single File Browse");
    private Button selectBatchFile=new Button("Batch File Browse");
    private Button selectPDFFile= new Button("Single PDF Create");

    private Button historyButton= new Button("History");
    private String sourceDirectory;
    public static String fileNameInputted; ///File name that user inputs

    private Label fileToInputLabel = new Label("Input file name");
    private static TextField fileToInputTextField = new TextField(fileNameInputted);
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);
    private Text titleName= new Text("Ultimate Electronics Simulator");

    private VBox buttonView =new VBox(selectSingleFile,selectBatchFile,selectPDFFile);


    public static String filenameInputtedByUser()
    {
        return fileToInputTextField.getText();
    }

    @Override
    public void start(Stage windowApplication) throws IOException {
        new LocalFileHistory(); ///Initializes the session being opened

        StackPane screen1 = new StackPane();
        Scene scene = new Scene(screen1, 1280,720);
        screen1.setStyle("-fx-background-color: #9b0000;"); ///BACKGROUND COLOR 1

        ///Title Properties
        titleName.setFont(Font.font("Arial", FontWeight.findByWeight(25), FontPosture.REGULAR,35));
        titleName.setFill(Color.YELLOW);
        titleName.setStroke(Color.BLACK);
        StackPane.setAlignment(titleName, Pos.TOP_CENTER);


        ///Title & Footer Text For Application
        Text authorName= new Text("Golden Maple Software © 2022");
        ///Footer Text Properties
        authorName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,25));
        authorName.setFill(Color.GOLD);
        authorName.setStroke(Color.BLACK);
        StackPane.setAlignment(authorName, Pos.BOTTOM_CENTER);

        ///Buttons
        Button selectSingleFile= new Button("Open Single File");
        selectSingleFile.styleProperty().bind(Bindings.when(selectSingleFile.hoverProperty())
                .then("-fx-background-color: #d43500; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#d1d1d1;-fx-border-width: 1.5px; -fx-font-size: 1.65em;")
                .otherwise("-fx-background-color: #2b2323; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#ffffff;-fx-border-width: 1.5px; -fx-font-size: 1.65em;"));

        Button logicGateSimulator= new Button("Logic Gate Simulator");
        logicGateSimulator.styleProperty().bind(Bindings.when(logicGateSimulator.hoverProperty())
                .then("-fx-background-color: #d43500; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#d1d1d1;-fx-border-width: 1.5px; -fx-font-size: 1.65em;")
                .otherwise("-fx-background-color: #2b2323; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#ffffff;-fx-border-width: 1.5px; -fx-font-size: 1.65em;"));

        historyButton.styleProperty().bind(Bindings.when(historyButton.hoverProperty())
                .then("-fx-background-color: #d43500; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#d1d1d1;-fx-border-width: 1.5px; -fx-font-size: 1.65em;")
                .otherwise("-fx-background-color: #2b2323; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#ffffff;-fx-border-width: 1.5px; -fx-font-size: 1.65em;"));


        Button writeSingleFileButton= new Button("Overwrite Single File");
        writeSingleFileButton.styleProperty().bind(Bindings.when(writeSingleFileButton.hoverProperty())
                .then("-fx-background-color: #d43500; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#d1d1d1;-fx-border-width: 1.5px; -fx-font-size: 1.65em;")
                .otherwise("-fx-background-color: #2b2323; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#ffffff;-fx-border-width: 1.5px; -fx-font-size: 1.65em;"));

        //Adds all the button values and location

        Button writeButton= new Button("Write To File");
        writeButton.styleProperty().bind(Bindings.when(writeButton.hoverProperty())
                .then("-fx-background-color: #d43500; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#d1d1d1;-fx-border-width: 1.5px; -fx-font-size: 1.65em;")
                .otherwise("-fx-background-color: #2b2323; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#ffffff;-fx-border-width: 1.5px; -fx-font-size: 1.65em;"));
        writeButton.setMinWidth(100);
        writeButton.setTranslateY(25);
        writeButton.setTranslateX(170);

        logicGateSimulator.setOnAction(actionEvent ->
        {
            try {
                LocalFileHistory.logicGateSimulatorOpened(); ///Tells us the button has been clicked in session
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            logicGateSimulator.setMnemonicParsing(true);
            windowApplication.setScene(new GateScene()); ///Change Window
        });


        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        buttonView.setPadding(new Insets(10, 10, 10, 10));
        Border border = new Border(borderStroke);


        ///Main Panel
        VBox mainPanel= new VBox();
        mainPanel.setLayoutX(352.55);
        mainPanel.setAlignment(Pos.CENTER);
        mainPanel.setBorder(border);
        mainPanel.setSpacing(10);
        mainPanel.setPadding(new Insets(10, 10, 10, 120));
        mainPanel.setBackground(new Background(new BackgroundFill(Color.rgb(40,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        mainPanel.setMaxWidth(1200);
        mainPanel.setMaxHeight(550);



        ///Button View
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(selectSingleFile, 1, 0);
        gridPane.add(logicGateSimulator, 0,0);
        gridPane.add(writeSingleFileButton, 0,1);
        gridPane.add(historyButton,1,1 );
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        ///Button Panel
        VBox buttonView = new VBox(gridPane);
        buttonView.setAlignment(Pos.CENTER);
        buttonView.setBorder(border);
        buttonView.setSpacing(10);
        buttonView.setPadding(new Insets(10, 10, 10, 10));
        buttonView.setBackground(new Background(new BackgroundFill(Color.rgb(79,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonView.setMaxWidth(500);
        buttonView.setMaxHeight(200);

        /*
        Rectangle historyView=new Rectangle();
        //Setting the properties of the rectangle
        historyView.setX(250.0f);
        historyView.setY(575.0f);
        historyView.setWidth(300.0f);
        historyView.setHeight(450.0f);
        //Setting other properties
        historyView.setFill(Color.DARKCYAN);
        historyView.setStrokeWidth(8.0);
        historyView.setStroke(Color.DARKSLATEGREY);

        historyView.setTranslateX(screen1.getWidth()/1.65);

        historyView.setVisible(false);
        */

        historyButton.setOnAction(actionEvent ->
        {
            try {
                LocalFileHistory.historyButtonOpened();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("History");
            try {
                windowApplication.setScene(new OperationsPerformed()); ///Change Window
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        ///Imports and GUI Settings
        screen1.getChildren().addAll(titleName,authorName, mainPanel,buttonView);
        windowApplication.setTitle("Ultimate Electronics Simulator");
        windowApplication.setResizable(false);
        windowApplication.setScene(scene);
        windowApplication.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}