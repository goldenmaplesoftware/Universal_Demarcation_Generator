package com.example.test;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.File;
import java.io.IOException;


public class GateScenePane extends StackPane
{
    private Text title = new Text("Visual Pane");
    private Text title2 = new Text("History2");
    private Text content = new Text("content");///This is new path that is created
    private Text inputAmountUniversalInputs = new Text("Input the amount of universal inputs");
    public static String amountInputs; ///String to int have to convert..
    private Label inputAmountUniversalInputsLabel= new Label("Input amount universal inputs");
    private static TextField inputAmountUniversalInputsTextField = new TextField(amountInputs);
    private Text inputAmountGates = new Text("Input the amount of gates");
    public static String amountGates; ///String to int have to convert...
    private Label inputAmountGatesLabel= new Label("Input the amount of gates");
    private static TextField inputAmountGatesTextField = new TextField(amountGates);
    private Text inputTypeGate = new Text("Input the type of gate");
    public static String inputTypeGates; ///String to int have to convert...
    private Label inputTypeGatesLabel= new Label("Input the type of gate");
    private static TextField inputTypeTextField = new TextField(inputTypeGates);
    private Text inputInputsGate = new Text("Input amount of inputs on x gate");
    public static String inputInputsGates; ///String to int have to convert...
    private Label inputInputsLabel= new Label("Input amount of inputs on x gate");
    private static TextField inputInputsTextField = new TextField(inputInputsGates);
    private Button closeWindow= new Button("X"); ///Redirects to home
    private Button closeTerminal= new Button("X"); ///Redirects to home
    private Button visualSymbolsTerminal= new Button("Gate Container"); ///Container of visual elements produced
    private Button terminalTableResults= new Button("Terminal Table"); ///Container of visual elements produced
    private Button openTerminal= new Button("Open Terminal"); ///Redirects to home
    private Button openVisual= new Button("Open Blueprint Workspace"); ///Redirects to home
    private HBox buttonTopVisualPane=new HBox(title,openTerminal,closeWindow);
    private HBox buttonTopTerminalPane=new HBox(visualSymbolsTerminal,terminalTableResults,closeTerminal);
    private VBox gateVisualVBox =new VBox(buttonTopVisualPane, content);
    private GridPane terminalInputField=new GridPane();
    private VBox gateTerminalCommands =new VBox(buttonTopTerminalPane,terminalInputField);
    ////private VBox gateTerminalCommands =new VBox(closeTerminal,title2,inputAmountUniversalInputs,inputAmountGates,inputTypeGate,inputInputGate);
    public static String fileNameInputted; ///File name that user inputs
    private String sourceDirectory;
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);
    private ToolBar toolBarMain = new ToolBar();
    private Button selectSingleFile=new Button("Open");
    private Button newProjectButton= new Button("New");
    private Button writeSingleFileButton= new Button("Save");
    private Button writeButton= new Button("Save As");

    private Label fileToInputLabel = new Label("Input file name");
    private static TextField fileToInputTextField = new TextField(fileNameInputted);

    public static String filenameInputtedByUser()
    {
        return fileToInputTextField.getText();
    }
    public GateScenePane()
    {
        ///Main toolbar at top of the page
        VBox toolbar = new VBox(toolBarMain);
        toolBarMain.getItems().add(newProjectButton);
        toolBarMain.getItems().add(selectSingleFile);
        toolBarMain.getItems().add(writeSingleFileButton);
        toolBarMain.getItems().add(new Separator());
        toolBarMain.getItems().add(openTerminal);
        toolBarMain.getItems().add(openVisual);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background: rgb(75,0,0);");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45));
        title.setFill(Color.RED);
        title2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 45));
        title2.setFill(Color.RED);

        content.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        content.setFill(Color.WHITE);
        ///Text box for terminal questions
        inputAmountUniversalInputs.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputAmountUniversalInputs.setFill(Color.GREEN);
        inputAmountGates.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputAmountGates.setFill(Color.GREEN);
        inputTypeGate.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputTypeGate.setFill(Color.GREEN);
        inputInputsGate.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputInputsGate.setFill(Color.GREEN);

        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        Border border = new Border(borderStroke);

        ///Input Single File Panel
        VBox writePanel= new VBox(fileToInputTextField,writeButton);
        writePanel.setLayoutX(5.5);
        writePanel.setLayoutY(40.5);
        writePanel.setBorder(border);
        writePanel.setPadding(new Insets(10, 10, 10, 10));
        writePanel.setBackground(new Background(new BackgroundFill(Color.rgb(79,0,0,0.5), CornerRadii.EMPTY, Insets.EMPTY)));
        writePanel.setMaxWidth(500);
        writePanel.setMaxHeight(250);
        writePanel.setVisible(false);



        ///Button properties
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

        newProjectButton.setOnAction(actionEvent ->
        {
            System.out.println("New Project");

        });

        closeWindow.setOnAction(actionEvent ->
        {
            System.out.println("Application Closed");
            gateVisualVBox.setVisible(false);
        });

        closeTerminal.setOnAction(actionEvent ->
        {
            gateTerminalCommands.setVisible(false);
            System.out.println("Terminal closed");
        });

        openTerminal.setOnAction(actionEvent ->
        {
            gateTerminalCommands.setVisible(true);
            System.out.println("Terminal opened");
        });

        openVisual.setOnAction(actionEvent ->
        {
            gateVisualVBox.setVisible(true);
            System.out.println("Visual pane opened");
        });

        writeSingleFileButton.setOnAction(actionEvent ->
        {
            writeSingleFileButton.setMnemonicParsing(true);
            System.out.println("Writing pane has been made visiable");
            writePanel.setVisible(true);
        });

        fileToInputTextField.setAlignment(Pos.BOTTOM_LEFT);
        fileToInputTextField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                String fileName = fileToInputTextField.getText() + ".pdf";
                System.out.println("This creates a blank PDF");
                ///String fileName="SampleTextFile.pdf"; ///File name that is generated
                try
                {

                    PDDocument doc=new PDDocument();
                    doc.addPage(new PDPage()); ///Duplicate to make multiple pages in single document!
                    doc.addPage(new PDPage());
                    doc.save(fileName);
                    doc.close();
                    System.out.println("File has been created!");

                }

                catch (IOException  e2)
                {
                    throw new RuntimeException(e2);
                }

                try {
                    LocalFileHistory.fileSaved(fileToInputTextField.getText()); ///This tracks application progress
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            else
            {
                System.out.println("Try again.");
            }


        });



        ///VBox visual properties
        gateVisualVBox.setAlignment(Pos.CENTER);
        gateVisualVBox.setSpacing(10);
        gateVisualVBox.setPadding(new Insets(10, 15, 15, 15));

        gateVisualVBox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-color: #002082;"+
                "-fx-border-width: 1.25;" +
                "-fx-border-color: #7a7a7a;");

        gateVisualVBox.setMaxWidth(1100);
        gateVisualVBox.setMaxHeight(200);
        gateVisualVBox.setTranslateX(255.0);
        gateVisualVBox.setTranslateY(100.0);///Moves the box y orientation

        ///HBox top of terminal that has buttons visual
        HBox.setMargin(closeTerminal,new Insets(0,0,0,658));
        buttonTopTerminalPane.setSpacing(40);
        buttonTopTerminalPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-color: #262625;"+
                "-fx-border-width: 2.25;" +
                "-fx-border-color: #3f4040;");

        ///HBox top of visual that has buttons visual
        HBox.setMargin(closeWindow,new Insets(0,0,0,658));
        buttonTopVisualPane.setSpacing(40);
        buttonTopVisualPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-color: #262625;"+
                "-fx-border-width: 2.25;" +
                "-fx-border-color: #3f4040;");


        ///VBox terminal properties
        gateTerminalCommands.setAlignment(Pos.TOP_CENTER);
        gateTerminalCommands.setSpacing(10);
        gateTerminalCommands.setPadding(new Insets(10, 10, 10, 10));
        gateTerminalCommands.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        gateTerminalCommands.setMaxWidth(1000);
        gateTerminalCommands.setMaxHeight(300);
        gateTerminalCommands.setTranslateX(20.0);///Moves the box x orientation
        gateTerminalCommands.setTranslateY(200.0);///Moves the box y orientation

        ///Gridpane inside terminal properties
        terminalInputField.setMinSize(300,150);
        terminalInputField.setPadding(new Insets(15,15,15,15));
        terminalInputField.setVgap(10.0);
        terminalInputField.setHgap(10.0);
        terminalInputField.setAlignment(Pos.CENTER);
        terminalInputField.add(inputAmountUniversalInputs, 0, 0);
        terminalInputField.add(inputAmountUniversalInputsTextField, 1, 0);
        terminalInputField.add(inputAmountGates, 0, 1);
        terminalInputField.add(inputAmountGatesTextField, 1, 1);
        terminalInputField.add(inputTypeGate, 0, 2);
        terminalInputField.add(inputTypeTextField, 1, 2);
        terminalInputField.add(inputInputsGate, 0, 3);
        terminalInputField.add(inputInputsTextField, 1, 3);
        terminalInputField.add(title, 0, 4);
        terminalInputField.add(title2, 1, 4);
        terminalInputField.setStyle("-fx-background-color: black; -fx-grid-lines-visible: true");
        Group group=new Group(gateVisualVBox,toolbar,writePanel);
        scrollPane.setContent(group);

        this.getChildren().addAll(scrollPane,gateTerminalCommands);
    }





}
