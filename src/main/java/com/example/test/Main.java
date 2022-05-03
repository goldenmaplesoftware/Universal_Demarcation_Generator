package com.example.test;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main extends Application
{
    private ListView<String> listView;
    private Button selectSingleFile=new Button("Single File Browse");
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


    private VBox buttonView =new VBox(selectSingleFile,selectBatchFile,selectPDFFile);

    @Override
    public void start(Stage windowApplication) throws IOException {
        StackPane screen1 = new StackPane();
        Scene scene = new Scene(screen1, 1280,720);
        screen1.setStyle("-fx-background-color: #00308B;"); ///BACKGROUND COLOR 1

        ///Title & Footer Text For Application
        Text titleName= new Text("Universal Demarcation Generator");
        Text authorName= new Text("Golden Maple Software © 2022");


        ///Title Properties
        titleName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleName.setFill(Color.CYAN);
        titleName.setStroke(Color.BLACK);
        StackPane.setAlignment(titleName, Pos.TOP_CENTER);

        ///Footer Text Properties
        authorName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,25));
        authorName.setFill(Color.GOLD);
        authorName.setStroke(Color.BLACK);
        StackPane.setAlignment(authorName, Pos.BOTTOM_CENTER);

        ///Select Single File
        Button selectSingleFile= new Button("Open File To Overwrite");
        selectSingleFile.styleProperty().bind(Bindings.when(selectSingleFile.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        Button selectBatchFile= new Button("Open Multiple Files To Overwrite");
        selectBatchFile.styleProperty().bind(Bindings.when(selectBatchFile.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));



        selectSingleFile.setOnAction(actionEvent ->
        {
            selectSingleFile.setMnemonicParsing(true);
            System.out.println("Browse for single file was clicked.");
            FileChooser fc=new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\Snaker96\\IdeaProjects\\Test")); ///Source directory path to set by user...
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
            File selectFile=fc.showOpenDialog(null);

            if(selectFile != null) ///If the selected file has content
            {
                printSourceOnScreen.setText(selectFile.getAbsolutePath());
                printSourceOnScreenTitle.setText(selectFile.getName());

            }
            else
            {
                System.out.println("Single file selection is invalid!");
            }
        });

        selectBatchFile.setOnAction(actionEvent ->
        {
            selectBatchFile.setMnemonicParsing(true);
            System.out.println("Browse for batch files was clicked.");
            FileChooser fc=new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\Snaker96\\IdeaProjects\\Test"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
            List<File> selectedFiles=fc.showOpenMultipleDialog(null);

            if(selectedFiles != null) ///If the selected file has content
            {
                for (File selectedFile : selectedFiles)
                {
                    System.out.println("Multiple files selection is valid");
                    listView.getItems().add(selectedFile.getAbsolutePath());///This will print the name
                }
            }
            else
            {
                System.out.println("Multiple files selection is invalid!");
            }

        });

        selectBatchFile.setOnAction(actionEvent ->
        {
            selectBatchFile.setMnemonicParsing(true);
            System.out.println("Browse for batch files was clicked.");
            FileChooser fc=new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\Snaker96\\IdeaProjects\\Test"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
            List<File> selectedFiles=fc.showOpenMultipleDialog(null);

            if(selectedFiles != null) ///If the selected file has content
            {
                for (File selectedFile : selectedFiles)
                {
                    System.out.println("Multiple files selection is valid");
                    listView.getItems().add(selectedFile.getAbsolutePath());///This will print the name
                }
            }
            else
            {
                System.out.println("Multiple files selection is invalid!");
            }

        });





        Button jumpToPage= new Button("Create Duplicate File");
        jumpToPage.styleProperty().bind(Bindings.when(jumpToPage.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        jumpToPage.setOnAction(actionEvent ->
        {
            jumpToPage.setMnemonicParsing(true);
            System.out.println("New scene transition");
            windowApplication.setScene(new AddWaterMark()); ///Change Window
            ///windowApplication.setScene(new WaterMarkGenerated());
        });


        ///Button Views
        VBox buttonView = new VBox(selectSingleFile,selectBatchFile,jumpToPage);
        buttonView.setAlignment(Pos.CENTER);
        buttonView.setSpacing(10);
        buttonView.setPadding(new Insets(10, 10, 10, 10));

        ///Imports and GUI Settings
        screen1.getChildren().addAll(titleName,authorName,buttonView);
        windowApplication.setTitle("Universal Demarcation Generator");
        windowApplication.setResizable(false);
        windowApplication.setScene(scene);
        windowApplication.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}