package com.example.test;
import com.example.test.Gates.NAND_2_Input;
import com.example.test.Gates.NAND_7400;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
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
    private Text title = new Text("xGate");
    private Text title2 = new Text("xGate#");
    private Text content = new Text("content");///This is new path that is created
    private Text inputAmountUniversalInputs = new Text("Input the amount of universal inputs:");
    public static String amountInputs; ///String to int have to convert..
    private Label inputAmountUniversalInputsLabel= new Label("Input amount universal inputs:");
    private static TextField inputAmountUniversalInputsTextField = new TextField(amountInputs);
    private Text inputAmountGates = new Text("Input the amount of gates:");
    public static String amountGates; ///String to int have to convert...
    private Label inputAmountGatesLabel= new Label("Input the amount of gates:");
    private static TextField inputAmountGatesTextField = new TextField(amountGates);
    private Text inputTypeGate = new Text("Input the type of gate:");
    public static String inputTypeGates; ///String to int have to convert...
    private Label inputTypeGatesLabel= new Label("Input the type of gate:");
    private static TextField inputTypeTextField = new TextField(inputTypeGates);
    private Text inputInputsGate = new Text("Input amount of inputs on x gate");
    public static String inputInputsGates; ///String to int have to convert...
    private Label inputInputsLabel= new Label("Input amount of inputs on x gate");
    private static TextField inputInputsTextField = new TextField(inputInputsGates);
    private Button closeWindow= new Button("X"); ///Redirects to home
    private Button closeTerminal= new Button("X"); ///Redirects to home
    private Button terminalInputSetup= new Button("Terminal Main"); ///Container of visual elements produced

    private Button visualSymbolsTerminal= new Button("Gate Container"); ///Container of visual elements produced
    private Button terminalTableResults= new Button("Terminal Table"); ///Container of visual elements produced
    private Button openTerminal= new Button("Open Terminal"); ///Redirects to home
    private Button openVisual= new Button("Open Blueprint Workspace"); ///Redirects to home
    private HBox buttonTopVisualPane=new HBox(title,openTerminal,closeWindow);
    private HBox buttonTopTerminalPane=new HBox(terminalInputSetup,terminalTableResults,visualSymbolsTerminal,closeTerminal);
    private Canvas canvasVisual = createCanvasGrid();

    private VBox gateVisualVBox =new VBox(buttonTopVisualPane, content,canvasVisual);
    private GridPane terminalInputField=new GridPane();
    private GridPane saveInputField=new GridPane();

    ////private VBox gateTerminalCommands =new VBox(closeTerminal,title2,inputAmountUniversalInputs,inputAmountGates,inputTypeGate,inputInputGate);
    public static String fileNameInputted; ///File name that user inputs
    private String sourceDirectory;
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text saveAsText = new Text("Save as:");
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);
    private ToolBar toolBarMain = new ToolBar();
    private Button selectSingleFile=new Button("Open");
    private Button newProjectButton= new Button("New");
    private Button writeSingleFileButton= new Button("Save");
    private Button writeButton= new Button("Save As");
    private Button closeSaveWindow= new Button("Close Dialogue Box");

    private Label fileToInputLabel = new Label("Input file name");
    private static TextField fileToInputTextField = new TextField(fileNameInputted);

    private static TableView truthTable = new TableView();

    private VBox gateTerminalCommands =new VBox(buttonTopTerminalPane,truthTable,terminalInputField);
    private final VBox vboxTruthTable = new VBox();
    private final Label labelTruthTable = new Label("Truth Table");
    public static String filenameInputtedByUser()
    {
        return fileToInputTextField.getText();
    }

    private static int userInputtedGateNumber; ///Gate number this will increment as instances iterate
    private static int userInputtedICNumber;   ///Ic number this will increment as instances iterate


    public GateScenePane()
    {
        userInputtedGateNumber=2;
        ///Terminal stuff not visible
        terminalInputField.setVisible(false);
        truthTable.setVisible(false);
        labelTruthTable.setVisible(false);

        ///Main toolbar at top of the page
        VBox toolbar = new VBox(toolBarMain);
        toolBarMain.getItems().add(newProjectButton);
        toolBarMain.getItems().add(selectSingleFile);
        toolBarMain.getItems().add(writeSingleFileButton);
        toolBarMain.getItems().add(new Separator());
        toolBarMain.getItems().add(openTerminal);
        toolBarMain.getItems().add(openVisual);
        ///Scroll Pane inside the window
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background: rgb(3, 5, 20);");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        ///Fonts
        title.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 35));
        title.setFill(Color.WHITE);
        title2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 35));
        title2.setFill(Color.WHITE);
        content.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        content.setFill(Color.WHITE);

        ///Text box for terminal questions
        inputAmountUniversalInputs.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputAmountUniversalInputs.setFill(Color.WHITE);
        inputAmountGates.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputAmountGates.setFill(Color.WHITE);
        inputTypeGate.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputTypeGate.setFill(Color.WHITE);
        inputInputsGate.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        inputInputsGate.setFill(Color.WHITE);
        saveAsText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 12));
        saveAsText.setFill(Color.YELLOW);
        ///Border for save as
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        Border border = new Border(borderStroke);

        ///Save as layout
        saveInputField.setMinSize(50,50);
        saveInputField.setVgap(15.0);
        saveInputField.setHgap(5.0);
        saveInputField.setAlignment(Pos.CENTER);
        saveInputField.add(saveAsText, 0, 0);
        saveInputField.add(fileToInputTextField, 1, 0);
        saveInputField.add(closeSaveWindow, 0, 1);
        saveInputField.add(writeButton, 2, 0);;
        ///Input Single File Panel
        VBox writePanel= new VBox(saveInputField);
        writePanel.setLayoutX(15.5);
        writePanel.setLayoutY(40.5);
        writePanel.setBorder(border);
        writePanel.setPadding(new Insets(10, 50, 10, 50));
        writePanel.setBackground(new Background(new BackgroundFill(Color.rgb(16, 19, 48,0.5), CornerRadii.EMPTY, Insets.EMPTY)));
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

        closeSaveWindow.setOnAction(actionEvent ->
        {
            writePanel.setVisible(false);
            System.out.println("Save as window closed");
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

        ///Terminal Window Buttons
        ///visualSymbolsTerminal,terminalTableResults,closeTerminal

        terminalInputSetup.setOnAction(actionEvent ->
        {
            System.out.println("Terminal Main is open");
            terminalInputField.setVisible(true);
            truthTable.setVisible(false);
            labelTruthTable.setVisible(false);
        });

        terminalTableResults.setOnAction(actionEvent ->
        {
            System.out.println("Terminal Table is open");
            truthTable.setVisible(true);
            labelTruthTable.setVisible(true);
            terminalInputField.setVisible(false);
        });

        visualSymbolsTerminal.setOnAction(actionEvent ->
        {
            terminalInputField.setVisible(false);
            truthTable.setVisible(false);
            labelTruthTable.setVisible(false);
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


        ///Canvas graphics content
        GraphicsContext gc = canvasVisual.getGraphicsContext2D();
        inputDiagrams(gc);



        ///HBox top of terminal that has buttons visual
        HBox.setMargin(closeTerminal,new Insets(0,0,0,458));
        buttonTopTerminalPane.setSpacing(40);
        buttonTopTerminalPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-color: #262625;"+
                "-fx-border-width: 2.25;" +
                "-fx-border-color: #3f4040;");

        ///HBox top of visual that has buttons visual
        HBox.setMargin(closeWindow,new Insets(0,0,0,458));
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
        gateTerminalCommands.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-background-color: #101330;"+
                "-fx-border-width: 2.25;" +
                "-fx-border-color: #3f4040;");
        gateTerminalCommands.setMaxWidth(1000);
        gateTerminalCommands.setMaxHeight(300);
        gateTerminalCommands.setTranslateX(20.0);///Moves the box x orientation
        gateTerminalCommands.setTranslateY(200.0);///Moves the box y orientation

        ///Gridpane inside terminal main properties
        terminalInputField.setMinSize(350,150);
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
        terminalInputField.setStyle("-fx-background-color: #002082; " +
                                    "-fx-grid-lines-visible: true"
                                   );
        ///Table View for terminal table

        labelTruthTable.setFont(new Font("Arial", 20));
        truthTable.setStyle("-fx-background-color: #002082;"+
                            "-fx-border-color: #3f4040;"
                           );
        /*
        TableColumn titleCol = new TableColumn("Title");
        TableColumn authorCol = new TableColumn("Author");
        truthTable.getColumns().setAll(titleCol, authorCol);
        truthTable.setPrefWidth(450);
        truthTable.setPrefHeight(300);
        truthTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        */

        ///This is the container of objects...
        ///NAND_7400_IC();
        ///NAND_2_Input_Single_Gate();



        vboxTruthTable.setSpacing(5);
        vboxTruthTable.setPadding(new Insets(10, 0, 0, 10));
        vboxTruthTable.setLayoutX(900.0);
        vboxTruthTable.getChildren().addAll(labelTruthTable,truthTable);

        Group group=new Group(gateVisualVBox,toolbar,writePanel,vboxTruthTable);
        scrollPane.setContent(group);
        this.getChildren().addAll(scrollPane,gateTerminalCommands);
    }



    public void NAND_2_Input_Single_Gate()
    {
        NAND_2_Input<Object, Object, Object, Object> logicGate=
                new NAND_2_Input<>(NAND_2_Input.gateName(),userInputtedGateNumber,true,false,true);
        logicGate.gateNumberOutput();
        logicGate.NAND_2_Output();
    }
public void NAND_7400_IC()
{
    NAND_7400<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> logicGate=
            new NAND_7400<>(NAND_7400.ICName(),userInputtedICNumber,false,true,true,false,14.0,false,true,false,false,5.0);
    logicGate.gateNumberOutput();
    logicGate.voltageInput();
    logicGate.groundOutput();
    logicGate.gateOutput_1Y();
    logicGate.gateOutput_2Y();
    logicGate.gateOutput_3Y();
    logicGate.gateOutput_4Y();
}

    private void inputDiagrams(GraphicsContext gc)
    {
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1.0);


    }


    private Canvas createCanvasGrid()
    {

        Canvas canvas = new Canvas(725, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D() ;
        gc.setStroke(Color.WHITE);
        gc.stroke();
        gc.setLineWidth(1.0);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent e)
                    {

                        int gateSelection = 1;///make into user input
                        switch (gateSelection)
                        {
                            case 1 ->
                            {
                                System.out.println("Gate selection:" + gateSelection);
                                ///NAND Gate Entry
                                NAND_2_Input_Single_Gate(); ///This is the function call for when it is selected
                                gc.setFill(Color.RED);
                                gc.fillArc(e.getX(), e.getY(), 80, 80, -105, 210, ArcType.CHORD);
                                gc.setFill(Color.BLUE);
                                gc.fillOval(e.getX() + 25.5, e.getY(), 10, 10); ///Top input A
                                gc.setFill(Color.RED);
                                gc.fillRect(e.getX() + 5.5, e.getY(), 20, 5);
                                gc.setFill(Color.GREEN);
                                gc.fillOval(e.getX() + 25.5, e.getY() + 70, 10, 10); ///Top input B
                                gc.setFill(Color.RED);
                                gc.fillRect(e.getX() + 5.5, e.getY() + 73, 20, 5);
                                gc.setFill(Color.YELLOW);
                                gc.fillOval(e.getX() + 80.5, e.getY() + 35, 10, 10);/// output Y
                                gc.setFill(Color.RED);
                                gc.fillRect(e.getX() + 91.5, e.getY() + 38, 20, 5);
                            }
                            case 2 -> System.out.println("Gate selection:" + gateSelection);
                            case 3 -> System.out.println("Gate selection:" + gateSelection);
                            case 4 -> System.out.println("Gate selection:" + gateSelection);
                            case 5 -> System.out.println("Gate selection:" + gateSelection);
                            case 6 -> System.out.println("Gate selection:" + gateSelection);
                            case 7 -> System.out.println("Gate selection:" + gateSelection);
                            default -> System.out.println("Not valid gate selection!");
                        }

                    }
                });

        /*
        canvas.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            if (newValue)
            {
                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(220, 30, 50, 50);
                gc.fillPolygon(new double[]{220, 270, 220},
                        new double[]{120, 170, 170}, 3);

            }

            else
            {
                gc.setFill(Color.WHITE);
                gc.fillRect(220, 30, 50, 50);
                gc.fillPolygon(new double[]{220, 270, 220},
                        new double[]{120, 170, 170}, 3);

            }
        });
        */

        for (double x = 0.5; x < 729; x+=10)
        {
            gc.moveTo(x, 0);
            gc.lineTo(x, 1000);
            gc.stroke();
        }

        for (double y = 0.5; y < 1500; y+=10)
        {
            gc.moveTo(0, y);
            gc.lineTo(1000, y);
            gc.stroke();
        }

        return canvas;
    }



}
