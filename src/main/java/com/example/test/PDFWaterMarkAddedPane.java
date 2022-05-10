package com.example.test;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class PDFWaterMarkAddedPane extends StackPane
{

    private Text title = new Text("History");
    private Text pdfSelected = new Text("fileplaceholderpath"+"Selected!");///This is new path that is created
    private Button returnHome= new Button("Home"); ///Redirects to home
    private VBox buttonView =new VBox(title,pdfSelected,returnHome);

    public PDFWaterMarkAddedPane() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background: rgb(75,0,0);");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45));
        title.setFill(Color.RED);
        pdfSelected.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        pdfSelected.setFill(Color.BLUE);

        returnHome.setOnAction(actionEvent ->
        {
            System.out.println("Test");
            System.exit(0);
        });
        buttonView.setAlignment(Pos.CENTER);
        buttonView.setSpacing(10);
        buttonView.setPadding(new Insets(10, 10, 10, 10));
        buttonView.setBackground(new Background(new BackgroundFill(Color.rgb(79,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonView.setMaxWidth(500);
        buttonView.setMaxHeight(200);
        buttonView.setTranslateX(420.0);///Moves the box

        ///scrollPane.setContent(name);
        scrollPane.setContent(buttonView);
        this.getChildren().add(scrollPane);

    }

}
