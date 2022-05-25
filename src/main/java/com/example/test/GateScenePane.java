package com.example.test;
import com.example.test.Gates.AND_2_Input;
import com.example.test.Gates.NAND_2_Input;
import com.example.test.Gates.NAND_7400;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
import java.util.ArrayList;


public class GateScenePane extends StackPane
{
    private final int NANDGATENUMBER=0;
    private Text title = new Text("xGate");
    private Text title2 = new Text("xGate#");
    private Text content = new Text("content");///This is new path that is created
    private Text NANDGate2Input = new Text("2 Input NAND Gate:");
    private Text ORGate2Input = new Text("2 Input OR Gate:");
    private Text NORGate2Input = new Text("2 Input NOR Gate:");
    private Text XORGate2Input = new Text("2 Input XOR Gate:");
    private Text XNORGate2Input = new Text("2 Input XNOR Gate:");
    private Text NOTGateInput = new Text("NOT/Inverter Gate:");
    private Text BUFFERInput = new Text("Buffer Gate:");

    public static String amountInputs; ///String to int have to convert..
    private Label inputAmountUniversalInputsLabel= new Label("2 Input NAND Gate:");
    private static TextField inputAmountUniversalInputsTextField = new TextField(amountInputs);
    private Text ANDGate2Input = new Text("2 Input AND Gate:");
    public static String amountGates; ///String to int have to convert...
    private Label inputAmountGatesLabel= new Label("2 Input AND Gate:");
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
    private Button closeTerminal2= new Button("X"); ///Redirects to home
    private Button closeTerminal3= new Button("X"); ///Redirects to home
    private Button terminalInputSetup_left= new Button("<"); ///Container of visual elements produced
    private Button terminalInputSetup_right= new Button(">"); ///Container of visual elements produced

    private Button visualSymbolsTerminal= new Button("Terminal"); ///Container of visual elements produced
    private Button terminalTableResults= new Button("Truth Table"); ///Container of visual elements produced
    private Button openTerminal= new Button(" "); ///Open logic gate symbol pane
    private Button openTerminal2= new Button(" "); ///Open source component pane
    private Button openTerminal3= new Button(" "); ///Open source component pane
    private Button openMeasurements= new Button(" "); ///Make all component on-screen measurements visible
    private Button documentInformation= new Button(" "); ///Make document information visible
    private Button openVisual= new Button(" "); ///Open Blueprint Workspace
    private HBox buttonTopVisualPane=new HBox(title,openTerminal,closeWindow);
    private HBox buttonTopTerminalPane=new HBox(terminalInputSetup_left,terminalInputSetup_right,closeTerminal);
    private HBox buttonTopTerminalPane2=new HBox(closeTerminal2);
    private HBox buttonTopTerminalPane3=new HBox(closeTerminal3);
    private Canvas canvasVisual = createCanvasGrid();

    private VBox gateVisualVBox =new VBox(buttonTopVisualPane, content,canvasVisual);
    private GridPane terminalInputField_page_1=new GridPane();
    private GridPane terminalInputField2=new GridPane();
    private GridPane terminalInputField3=new GridPane();
    private GridPane saveInputField=new GridPane();

    ////private VBox gateTerminalCommands =new VBox(closeTerminal,title2,inputAmountUniversalInputs,inputAmountGates,inputTypeGate,inputInputGate);
    public static String fileNameInputted; ///File name that user inputs
    private String sourceDirectory;
    private Text printSourceOnScreen = new Text(sourceDirectory);
    private Text saveAsText = new Text("Save as:");
    private Text printSourceOnScreenTitle = new Text(sourceDirectory);
    private ToolBar toolBarMain = new ToolBar();
    private ToolBar toolBarSecondary = new ToolBar();
    private Button selectSingleFile=new Button("Open");
    private Button newProjectButton= new Button("New");
    private Button  moveComponetButton= new Button(" ");////Move Component
    private Button  removeComponetButton= new Button(" "); ///Remove Component
    private Button   addNodeButton= new Button(" "); ///Add Node
    private Button   addWireButton= new Button(" "); //Add Wire
    private Button   expandButton= new Button("v\n");
    private Button   shrinkButton= new Button("^\n");

    private Button writeSingleFileButton= new Button("Save");
    private Button writeButton= new Button("Save As");
    private Button closeSaveWindow= new Button("Close Dialogue Box");

    private Button workspaceSizeButton= new Button(" ");///Workspace Size


    private Label fileToInputLabel = new Label("Input file name");
    private static TextField fileToInputTextField = new TextField(fileNameInputted);

    private static TableView truthTable = new TableView();

    private VBox gateTerminalCommands =new VBox(buttonTopTerminalPane,truthTable,terminalInputField_page_1);
    private VBox gateTerminalCommands2 =new VBox(buttonTopTerminalPane2,terminalInputField2);
    private VBox gateTerminalCommands3 =new VBox(buttonTopTerminalPane3,terminalInputField3);
    private final VBox vboxTruthTable = new VBox();
    private final Label labelTruthTable = new Label("Truth Table");
    public static String filenameInputtedByUser()
    {
        return fileToInputTextField.getText();
    }

    private static int userInputtedGateNumber; ///Gate number this will increment as instances iterate
    private static int userInputtedICNumber;   ///Ic number this will increment as instances iterate
    private int selectedByUserGateImage;

    ArrayList<String>  gateAmount = new ArrayList<String>();             ///All of the gates/global list
    ArrayList<String>  NANDGateAmount = new ArrayList<String>();         ///All of the 2 input NAND gates/global list
    ArrayList<String>  componentAmount = new ArrayList<String>();        ////All of the components/global list
    ArrayList<String>  NANDGate2InputAmount = new ArrayList<String>();   /// All 2 input NAND Gates
    ArrayList<Boolean> NANDGateAInputAmount = new ArrayList<Boolean>();   ///All inputs in list
    ArrayList<Boolean> NANDGateBInputAmount = new ArrayList<Boolean>();   ///All inputs in list
    ArrayList<Boolean> NANDGateYOutputAmount = new ArrayList<Boolean>();  ///All outputs in list



    public GateScenePane()
    {
        System.out.println(gateAmount);

            userInputtedGateNumber = 2;
            ///Terminal stuff not visible
            terminalInputField_page_1.setVisible(false);
            terminalInputField2.setVisible(false);
            terminalInputField3.setVisible(false);
            truthTable.setVisible(false);
            labelTruthTable.setVisible(false);

            ///Main toolbar at top of the page
            VBox toolbar1 = new VBox(toolBarMain);

            ///Properties for icon new project button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(newProjectButton);
            toolBarMain.setBackground(new Background(new BackgroundFill(Color.rgb(11, 11, 137), CornerRadii.EMPTY, Insets.EMPTY)));
            ImageView newIconImage = new ImageView("file:src/main/java/com/example/test/new.png");
            newIconImage.setFitWidth(20.0);
            newIconImage.setFitHeight(20.0);
            newIconImage.setPreserveRatio(true);
            newIconImage.setPickOnBounds(true); // allows click on transparent areas
            newProjectButton.setGraphic(newIconImage);
            newProjectButton.setLayoutX(10);
            newProjectButton.setLayoutY(10);
            newProjectButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for icon open project button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(selectSingleFile);
            ImageView openIconImage = new ImageView("file:src/main/java/com/example/test/open.png");
            openIconImage.setFitWidth(20.0);
            openIconImage.setFitHeight(20.0);
            openIconImage.setPreserveRatio(true);
            openIconImage.setPickOnBounds(true); // allows click on transparent areas
            selectSingleFile.setGraphic(openIconImage);
            selectSingleFile.setLayoutX(10);
            selectSingleFile.setLayoutY(10);
            selectSingleFile.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for icon save project button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(writeSingleFileButton);
            ImageView saveIconImage = new ImageView("file:src/main/java/com/example/test/save.png");
            saveIconImage.setFitWidth(20.0);
            saveIconImage.setFitHeight(20.0);
            saveIconImage.setPreserveRatio(true);
            saveIconImage.setPickOnBounds(true); // allows click on transparent areas
            writeSingleFileButton.setGraphic(saveIconImage);
            writeSingleFileButton.setLayoutX(10);
            writeSingleFileButton.setLayoutY(10);
            writeSingleFileButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Seperator from the file query on main toolbar
            toolBarMain.getItems().add(new Separator());

            ///Properties for icon add logic gate button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(openTerminal); ///Add logic gates
            ImageView addLogicGateImage = new ImageView("file:src/main/java/com/example/test/addGate.png");
            addLogicGateImage.setFitWidth(75.0);
            addLogicGateImage.setFitHeight(60.0);
            addLogicGateImage.setPreserveRatio(true);
            addLogicGateImage.setPickOnBounds(true); // allows click on transparent areas
            openTerminal.setGraphic(addLogicGateImage);
            openTerminal.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for icon add IC button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(openTerminal2);
            ImageView addICImage = new ImageView("file:src/main/java/com/example/test/addIC.png");
            addICImage.setFitWidth(50);
            addICImage.setFitHeight(40);
            addICImage.setPreserveRatio(true);
            addICImage.setPickOnBounds(true); // allows click on transparent areas
            openTerminal2.setGraphic(addICImage);
            openTerminal2.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for icon add component button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(openTerminal3);
            ImageView addComponentImage = new ImageView("file:src/main/java/com/example/test/addComponet.png");
            addComponentImage.setFitWidth(75);
            addComponentImage.setFitWidth(75);
            addComponentImage.setPreserveRatio(true);
            addComponentImage.setPickOnBounds(true); // allows click on transparent areas
            openTerminal3.setGraphic(addComponentImage);
            openTerminal3.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Seperator from the add components on main toolbar
            toolBarMain.getItems().add(new Separator());

            ///Properties for icon measurement display button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(openMeasurements);
            ImageView measurementsImage = new ImageView("file:src/main/java/com/example/test/sinewavemeasurement.png");
            measurementsImage.setFitWidth(100);
            measurementsImage.setFitHeight(200);
            measurementsImage.setPreserveRatio(true);
            measurementsImage.setPickOnBounds(true); // allows click on transparent areas
            openMeasurements.setGraphic(measurementsImage);
            openMeasurements.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for document information button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(documentInformation);
            ImageView documentInformationImage = new ImageView("file:src/main/java/com/example/test/document_information.png");
            documentInformationImage.setFitWidth(25);
            documentInformationImage.setFitWidth(25);
            documentInformationImage.setPreserveRatio(true);
            documentInformationImage.setPickOnBounds(true); // allows click on transparent areas
            documentInformation.setGraphic(documentInformationImage);
            documentInformation.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for open toolbar 2 button with in the main toolbar/toolbar 1
            toolBarMain.getItems().add(expandButton);
            expandButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Toolbar 2/Secondary toolbar
            VBox toolbar2 = new VBox(toolBarSecondary);
            toolbar2.setLayoutY(57.5);
            toolbar2.setLayoutX(257.0);

            ///Properties for move component button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(moveComponetButton);
            toolBarSecondary.setBackground(new Background(new BackgroundFill(Color.rgb(11, 11, 146), CornerRadii.EMPTY, Insets.EMPTY)));
            ImageView moveImage = new ImageView("file:src/main/java/com/example/test/move.png");
            moveImage.setFitWidth(25);
            moveImage.setFitWidth(25);
            moveImage.setPreserveRatio(true);
            moveImage.setPickOnBounds(true); // allows click on transparent areas
            moveComponetButton.setGraphic(moveImage);
            moveComponetButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");

            ///Properties for add node button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(addNodeButton);
            ImageView addNodeImage = new ImageView("file:src/main/java/com/example/test/addNode.png");
            addNodeImage.setFitWidth(75);
            addNodeImage.setFitWidth(75);
            addNodeImage.setPreserveRatio(true);
            addNodeImage.setPickOnBounds(true); // allows click on transparent areas
            addNodeButton.setGraphic(addNodeImage);
            addNodeButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
            ///Properties for add wire button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(addWireButton);
            ImageView addWireImage = new ImageView("file:src/main/java/com/example/test/addWire.png");
            addWireImage.setFitWidth(75);
            addWireImage.setFitWidth(75);
            addWireImage.setPreserveRatio(true);
            addWireImage.setPickOnBounds(true); // allows click on transparent areas
            addWireButton.setGraphic(addWireImage);
            addWireButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
            ///Properties for remove component button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(removeComponetButton);
            ImageView removeComponentImage = new ImageView("file:src/main/java/com/example/test/trashcan.png");
            removeComponentImage.setFitWidth(25);
            removeComponentImage.setFitWidth(25);
            removeComponentImage.setPreserveRatio(true);
            removeComponentImage.setPickOnBounds(true); // allows click on transparent areas
            removeComponetButton.setGraphic(removeComponentImage);
            removeComponetButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
            ///Separator from component properties to workspace properties
            toolBarSecondary.getItems().add(new Separator());

            ///Properties for open workspace button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(openVisual);
            ImageView blueprintOpen = new ImageView("file:src/main/java/com/example/test/blueprint.png");
            blueprintOpen.setFitWidth(25);
            blueprintOpen.setFitWidth(25);
            blueprintOpen.setPreserveRatio(true);
            blueprintOpen.setPickOnBounds(true); // allows click on transparent areas
            openVisual.setGraphic(blueprintOpen);
            openVisual.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
            ///Properties for workspace size button with in the secondary toolbar/toolbar 2
            toolBarSecondary.getItems().add(workspaceSizeButton);
            ImageView workspaceSizeImage = new ImageView("file:src/main/java/com/example/test/expandicon.png");
            workspaceSizeImage.setFitWidth(25);
            workspaceSizeImage.setFitWidth(25);
            workspaceSizeImage.setPreserveRatio(true);
            workspaceSizeImage.setPickOnBounds(true); // allows click on transparent areas
            workspaceSizeButton.setGraphic(workspaceSizeImage);
            workspaceSizeButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
            toolBarSecondary.getItems().add(shrinkButton);
            shrinkButton.setStyle("-fx-background-color: #0b0bc1; " +
                    "-fx-text-fill: #FFFFFF;");
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
            NANDGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            NANDGate2Input.setFill(Color.WHITE);
            ORGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            ORGate2Input.setFill(Color.WHITE);
            NORGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            NORGate2Input.setFill(Color.WHITE);
            XORGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            XORGate2Input.setFill(Color.WHITE);
            XNORGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            XNORGate2Input.setFill(Color.WHITE);
            ORGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            NOTGateInput.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            NOTGateInput.setFill(Color.WHITE);
            BUFFERInput.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            BUFFERInput.setFill(Color.WHITE);

            ANDGate2Input.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 12));
            ANDGate2Input.setFill(Color.WHITE);
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
            saveInputField.setMinSize(50, 50);
            saveInputField.setVgap(15.0);
            saveInputField.setHgap(5.0);
            saveInputField.setAlignment(Pos.CENTER);
            saveInputField.add(saveAsText, 0, 0);
            saveInputField.add(fileToInputTextField, 1, 0);
            saveInputField.add(closeSaveWindow, 0, 1);
            saveInputField.add(writeButton, 2, 0);
            ;
            ///Input Single File Panel
            VBox writePanel = new VBox(saveInputField);
            writePanel.setLayoutY(58.5);
            writePanel.setBorder(border);
            writePanel.setPadding(new Insets(10, 10, 10, 10));
            writePanel.setBackground(new Background(new BackgroundFill(Color.rgb(16, 19, 48, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
            writePanel.setMaxWidth(270);
            writePanel.setMaxHeight(250);
            writePanel.setVisible(false);


            ///Button properties
            selectSingleFile.setOnAction(actionEvent ->
            {

                selectSingleFile.setMnemonicParsing(true);
                System.out.println("Browse for single file was clicked.");
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("C:\\Users\\Snaker96\\IdeaProjects\\Test")); ///Source directory path to set by user...
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
                File selectFile = fc.showOpenDialog(null);

                if (selectFile != null) ///If the selected file has content
                {
                    printSourceOnScreen.setText(selectFile.getAbsolutePath());
                    printSourceOnScreenTitle.setText(selectFile.getName());

                } else {
                    System.out.println("Single file selection is invalid!");
                }
            });

            newProjectButton.setOnAction(actionEvent ->
            {
                System.out.println("New Project");

            });


            workspaceSizeButton.setOnAction(actionEvent ->
            {
                System.out.println("Enter workspace size x & y");

            });

            moveComponetButton.setOnAction(actionEvent ->
            {
                System.out.println("Move component button clicked,  click component to move in scene.");

            });

            removeComponetButton.setOnAction(actionEvent ->
            {
                System.out.println("Remove component button clicked,  click component to remove from scene.");

            });

            addNodeButton.setOnAction(actionEvent ->
            {
                System.out.println("Add node button clicked,  click workspace to add node to bridge connections.");

            });

            addWireButton.setOnAction(actionEvent ->
            {
                System.out.println("Add wire button clicked,  click workspace to add wire to make connection.");

            });

            shrinkButton.setOnAction(actionEvent ->
            {
                System.out.println("Shrink toolbar 2.");
                toolbar2.setVisible(false);
            });

            expandButton.setOnAction(actionEvent ->
            {
                System.out.println("Expand toolbar 2.");
                toolbar2.setVisible(true);
            });

            openMeasurements.setOnAction(actionEvent ->
            {
                System.out.println("Display measurements");

            });

            documentInformation.setOnAction(actionEvent ->
            {
                System.out.println("Display document information");

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
                System.out.println("Logic Gate Symbol Importer closed");
            });


            closeTerminal2.setOnAction(actionEvent ->
            {
                gateTerminalCommands2.setVisible(false);
                System.out.println("Add Source Importer closed");
            });

            closeTerminal3.setOnAction(actionEvent ->
            {
                gateTerminalCommands3.setVisible(false);
                System.out.println("Add Components Importer closed");
            });

            openTerminal.setOnAction(actionEvent ->
            {
                gateTerminalCommands.setVisible(true);
                gateTerminalCommands2.setVisible(false);
                gateTerminalCommands3.setVisible(false);
                System.out.println("Logic Gate Symbol Importer opened");
            });

            openVisual.setOnAction(actionEvent ->
            {
                System.out.println("Open visual field");
                gateVisualVBox.setVisible(true);
            });

            openTerminal2.setOnAction(actionEvent ->
            {
                gateTerminalCommands2.setVisible(true);
                gateTerminalCommands.setVisible(false);
                gateTerminalCommands3.setVisible(false);
                System.out.println("IC importer open");
            });

            openTerminal3.setOnAction(actionEvent ->
            {
                gateTerminalCommands3.setVisible(true);
                gateTerminalCommands.setVisible(false);
                gateTerminalCommands2.setVisible(false);
                System.out.println("Components importer opened");
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
                    try {

                        PDDocument doc = new PDDocument();
                        doc.addPage(new PDPage()); ///Duplicate to make multiple pages in single document!
                        doc.addPage(new PDPage());
                        doc.save(fileName);
                        doc.close();
                        System.out.println("File has been created!");

                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }

                    try {
                        LocalFileHistory.fileSaved(fileToInputTextField.getText()); ///This tracks application progress
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    System.out.println("Try again.");
                }


            });

            ///Terminal Window Buttons
            ///visualSymbolsTerminal,terminalTableResults,closeTerminal

            terminalInputSetup_left.setOnAction(actionEvent ->
            {
                System.out.println("Page move to left");
                terminalInputField_page_1.setVisible(true);
                truthTable.setVisible(false);
                labelTruthTable.setVisible(false);
            });

            terminalInputSetup_right.setOnAction(actionEvent ->
            {
                System.out.println("Page move to right");
                terminalInputField_page_1.setVisible(false);
                ///terminalInputField2.setVisible(true);
                truthTable.setVisible(false);
                labelTruthTable.setVisible(false);
            });

            ///VBox visual properties
            gateVisualVBox.setVisible(false);
            gateVisualVBox.setAlignment(Pos.CENTER);
            gateVisualVBox.setSpacing(10);
            gateVisualVBox.setPadding(new Insets(10, 15, 15, 15));

            gateVisualVBox.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #002082;" +
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
            HBox.setMargin(closeTerminal, new Insets(0, 0, 0, 458));
            buttonTopTerminalPane.setSpacing(40);
            buttonTopTerminalPane.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #262625;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");

            HBox.setMargin(closeTerminal2, new Insets(0, 0, 0, 458));
            buttonTopTerminalPane2.setSpacing(40);
            buttonTopTerminalPane2.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #262625;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");

            HBox.setMargin(closeTerminal3, new Insets(0, 0, 0, 458));
            buttonTopTerminalPane3.setSpacing(40);
            buttonTopTerminalPane3.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #262625;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");

            ///HBox top of visual that has buttons visual
            HBox.setMargin(closeWindow, new Insets(0, 0, 0, 458));
            buttonTopVisualPane.setSpacing(40);
            buttonTopVisualPane.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #262625;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");

            ///VBox terminal properties
            gateTerminalCommands.setVisible(false);
            gateTerminalCommands.setAlignment(Pos.TOP_CENTER);
            gateTerminalCommands.setSpacing(10);
            gateTerminalCommands.setPadding(new Insets(10, 10, 10, 10));
            gateTerminalCommands.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #101330;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");
            gateTerminalCommands.setMaxWidth(1000);
            gateTerminalCommands.setMaxHeight(300);
            gateTerminalCommands.setTranslateX(20.0);///Moves the box x orientation
            gateTerminalCommands.setTranslateY(200.0);///Moves the box y orientation

            ///VBox terminal 2 properties
            gateTerminalCommands.setVisible(false);
            gateTerminalCommands2.setAlignment(Pos.TOP_CENTER);
            gateTerminalCommands2.setSpacing(10);
            gateTerminalCommands2.setPadding(new Insets(10, 10, 10, 10));
            gateTerminalCommands2.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #201330;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");
            gateTerminalCommands2.setMaxWidth(1000);
            gateTerminalCommands2.setMaxHeight(300);
            gateTerminalCommands2.setTranslateX(20.0);///Moves the box x orientation
            gateTerminalCommands2.setTranslateY(200.0);///Moves the box y orientation

            ///VBox terminal 3 properties
            gateTerminalCommands.setVisible(false);
            gateTerminalCommands3.setAlignment(Pos.TOP_CENTER);
            gateTerminalCommands3.setSpacing(10);
            gateTerminalCommands3.setPadding(new Insets(10, 10, 10, 10));
            gateTerminalCommands3.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-background-color: #365330;" +
                    "-fx-border-width: 2.25;" +
                    "-fx-border-color: #3f4040;");
            gateTerminalCommands3.setMaxWidth(1000);
            gateTerminalCommands3.setMaxHeight(300);
            gateTerminalCommands3.setTranslateX(20.0);///Moves the box x orientation
            gateTerminalCommands3.setTranslateY(200.0);///Moves the box y orientation

            ///Image toolbox

            ImageView nandGate2InputImage = new ImageView("file:src/main/java/com/example/test/NANDGate.png");
            nandGate2InputImage.setFitWidth(150.0);
            nandGate2InputImage.setFitHeight(150.0);
            nandGate2InputImage.setPreserveRatio(true);
            nandGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            nandGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input NAND Gate!"); // change functionality
                selectedByUserGateImage = 1;
            });

            ImageView andGate2InputImage = new ImageView("file:src/main/java/com/example/test/ANDGate.png");
            andGate2InputImage.setFitWidth(150.0);
            andGate2InputImage.setFitHeight(150.0);
            andGate2InputImage.setPreserveRatio(true);
            andGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            andGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input AND Gate!"); // change functionality
                selectedByUserGateImage = 2;
            });

            ImageView orGate2InputImage = new ImageView("file:src/main/java/com/example/test/OR.png");
            orGate2InputImage.setFitWidth(150.0);
            orGate2InputImage.setFitHeight(150.0);
            orGate2InputImage.setPreserveRatio(true);
            orGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            orGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input OR Gate!"); // change functionality
                selectedByUserGateImage = 3;
            });

            ImageView norGate2InputImage = new ImageView("file:src/main/java/com/example/test/NOR.png");
            norGate2InputImage.setFitWidth(150.0);
            norGate2InputImage.setFitHeight(150.0);
            norGate2InputImage.setPreserveRatio(true);
            norGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            norGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input NOR Gate!"); // change functionality
                selectedByUserGateImage = 4;
            });

            ImageView xorGate2InputImage = new ImageView("file:src/main/java/com/example/test/XOR.png");
            xorGate2InputImage.setFitWidth(150.0);
            xorGate2InputImage.setFitHeight(150.0);
            xorGate2InputImage.setPreserveRatio(true);
            xorGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            xorGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input XOR Gate!"); // change functionality
                selectedByUserGateImage = 5;
            });

            ImageView xnorGate2InputImage = new ImageView("file:src/main/java/com/example/test/XNOR.png");
            xnorGate2InputImage.setFitWidth(150.0);
            xnorGate2InputImage.setFitHeight(150.0);
            xnorGate2InputImage.setPreserveRatio(true);
            xnorGate2InputImage.setPickOnBounds(true); // allows click on transparent areas
            xnorGate2InputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the 2 Input XNOR Gate!"); // change functionality
                selectedByUserGateImage = 6;
            });

            ImageView notInputImage = new ImageView("file:src/main/java/com/example/test/NOT.png");
            notInputImage.setFitWidth(150.0);
            notInputImage.setFitHeight(150.0);
            notInputImage.setPreserveRatio(true);
            notInputImage.setPickOnBounds(true); // allows click on transparent areas
            notInputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the NOT Gate!"); // change functionality
                selectedByUserGateImage = 7;
            });

            ImageView bufferInputImage = new ImageView("file:src/main/java/com/example/test/BUFFER.png");
            bufferInputImage.setFitWidth(150.0);
            bufferInputImage.setFitHeight(150.0);
            bufferInputImage.setPreserveRatio(true);
            bufferInputImage.setPickOnBounds(true); // allows click on transparent areas
            bufferInputImage.setOnMouseClicked((MouseEvent e) ->
            {
                System.out.println("User selected the buffer gate!"); // change functionality
                selectedByUserGateImage = 8;
            });

            ImageView junctionInputImage = new ImageView("file:src/main/java/com/example/test/junction.png");
            junctionInputImage.setFitWidth(150.0);
            junctionInputImage.setFitHeight(150.0);
            junctionInputImage.setPreserveRatio(true);
            junctionInputImage.setPickOnBounds(true); // allows click on transparent areas
            junctionInputImage.setOnMouseClicked((MouseEvent e) ->
            {

                System.out.println("User selected the junction!"); // change functionality
                ///selectedByUserGateImage=10;


            });


            ///Gridpane inside terminal main properties
            terminalInputField_page_1.setMinSize(350, 150);
            terminalInputField_page_1.setPadding(new Insets(15, 15, 15, 15));
            terminalInputField_page_1.setVgap(10.0);
            terminalInputField_page_1.setHgap(10.0);
            terminalInputField_page_1.setAlignment(Pos.CENTER);
            terminalInputField_page_1.add(nandGate2InputImage, 0, 0);
            terminalInputField_page_1.add(andGate2InputImage, 0, 1);
            ;
            terminalInputField_page_1.add(orGate2InputImage, 1, 0);
            terminalInputField_page_1.add(norGate2InputImage, 1, 1);
            terminalInputField_page_1.add(xorGate2InputImage, 2, 0);
            terminalInputField_page_1.add(xnorGate2InputImage, 2, 1);
            terminalInputField_page_1.add(notInputImage, 3, 0);
            terminalInputField_page_1.add(bufferInputImage, 3, 1);
            ///2,0
            terminalInputField_page_1.setStyle("-fx-background-color: #002082; " +
                    "-fx-grid-lines-visible: true"
            );


            ///Gridpane source importer
            terminalInputField2.setMinSize(350, 150);
            terminalInputField2.setPadding(new Insets(15, 15, 15, 15));
            terminalInputField2.setVgap(10.0);
            terminalInputField2.setHgap(10.0);
            terminalInputField2.setAlignment(Pos.CENTER);

            terminalInputField2.add(junctionInputImage, 0, 0);
        /*
        terminalInputField.add(andGate2InputImage, 0, 1);;
        terminalInputField.add(orGate2InputImage, 1 ,0);
        terminalInputField.add(norGate2InputImage, 1, 1);
        terminalInputField.add(xorGate2InputImage, 2, 0);
        terminalInputField.add(xnorGate2InputImage, 2, 1);
        terminalInputField.add(notInputImage, 3, 0);
        terminalInputField.add(bufferInputImage, 3 ,1);
        */
            terminalInputField2.setStyle("-fx-background-color: #102082; " +
                    "-fx-grid-lines-visible: true"
            );

            ///Componet source importer
            terminalInputField3.setMinSize(350, 150);
            terminalInputField3.setPadding(new Insets(15, 15, 15, 15));
            terminalInputField3.setVgap(10.0);
            terminalInputField3.setHgap(10.0);
            terminalInputField3.setAlignment(Pos.CENTER);
        /*
        terminalInputField.add(nandGate2InputImage, 0, 0);
        terminalInputField.add(andGate2InputImage, 0, 1);;
        terminalInputField.add(orGate2InputImage, 1 ,0);
        terminalInputField.add(norGate2InputImage, 1, 1);
        terminalInputField.add(xorGate2InputImage, 2, 0);
        terminalInputField.add(xnorGate2InputImage, 2, 1);
        terminalInputField.add(notInputImage, 3, 0);
        terminalInputField.add(bufferInputImage, 3 ,1);
        */
            terminalInputField3.setStyle("-fx-background-color: #142582; " +
                    "-fx-grid-lines-visible: true"
            );

        /*



        terminalInputField.add(nandGate2InputImage ,0, 4);
        terminalInputField.add(title2, 1, 4);
        terminalInputField.setStyle("-fx-background-color: #002082; " +
                                    "-fx-grid-lines-visible: true"
                                   );
                                   */
            ///Table View for terminal table

            labelTruthTable.setFont(new Font("Arial", 20));
            truthTable.setStyle("-fx-background-color: #002082;" +
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
            vboxTruthTable.getChildren().addAll(labelTruthTable, truthTable);

            Group group = new Group(gateVisualVBox, writePanel, vboxTruthTable, toolbar1, toolbar2);
            scrollPane.setContent(group);
            this.getChildren().addAll(scrollPane, gateTerminalCommands, gateTerminalCommands2, gateTerminalCommands3);
        }


    public void NAND_2_Input_Single_Gate()
    {
        NAND_2_Input<Object, Object, Object, Object> logicGate=
                new NAND_2_Input<>(NAND_2_Input.gateName(),userInputtedGateNumber,true,false,true);
        logicGate.gateNumberOutput();
        logicGate.NAND_2_Output();
        gateAmount.add("NAND Gate - 2 Input");
        NANDGateAmount.add("NAND Gate - 2 Input");
        componentAmount.add("NAND Gate - 2 Input");
        NANDGateAInputAmount.add(logicGate.NAND_2_Input_A());
        NANDGateBInputAmount.add(logicGate.NAND_2_Input_B());
        NANDGateYOutputAmount.add(logicGate.NAND_2_Output());
        System.out.println("\n***********\nTotal amount of Components: "+componentAmount.size());
        System.out.println("Total amount of Gates: "+gateAmount.size());
        System.out.println("Total amount of NAND Gates: "+NANDGateAmount.size());
        System.out.println("\ninput A: "+NANDGateAInputAmount+
                           "\ninput B: "+NANDGateBInputAmount+
                           "\noutput Y:"+NANDGateYOutputAmount+
                            "\n***********\n");
    }


    public void AND_2_Input_Single_Gate()
    {
        AND_2_Input<Object, Object, Object, Object> logicGate=
                new AND_2_Input<>(AND_2_Input.gateName(),userInputtedGateNumber,true,false,true);
        logicGate.gateNumberOutput();
        logicGate.AND_2_Output();
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

                        switch (selectedByUserGateImage)
                        {
                            case 1 -> ///NAND Gate 2 Input
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                                ///NAND Gate Entry

                                gc.setFill(Color.YELLOW); ///Input A set colour
                                gc.setFont(new Font(20));  ///Input A set font size

                                ///A properties of text
                                TextField localTextFieldA=new TextField();
                                localTextFieldA.setText("A("+NANDGateAInputAmount.size()+")"); ///Retrieves the number in the index of added
                                gc.fillText(String.valueOf(localTextFieldA.getText()),e.getX()-10.85,e.getY()); ///Input A

                                gc.setFill(Color.YELLOW); ///Input B set colour
                                gc.setFont(new Font(20));  ///Input B set font size

                                ///B properties of text
                                TextField localTextFieldB=new TextField();
                                localTextFieldB.setText("B("+NANDGateBInputAmount.size()+")"); ///Retrieves the number in the index of added
                                gc.fillText(String.valueOf(localTextFieldB.getText()),e.getX()-10.85,e.getY()+75); ///Input A


                                NAND_2_Input_Single_Gate(); ///This is the function call for when it is selected
                                gc.setFill(Color.RED);
                                gc.fillArc(e.getX(), e.getY(), 80, 80, -105, 210, ArcType.CHORD);
                                ///gc.setFill(Color.BLUE);
                                ///gc.fillOval(e.getX() + 25.5, e.getY(), 10, 10); ///Top input A
                                gc.setFill(Color.RED); ///A- LEG INPUT TOP
                                gc.fillRect(e.getX() + 12.85, e.getY(), 20, 2.5);
                                ///gc.setFill(Color.GREEN);
                                ///gc.fillOval(e.getX() + 25.5, e.getY() + 70, 10, 10); ///Top input B
                                gc.setFill(Color.RED);  ///B- LEG INPUT BOTTOM
                                gc.fillRect(e.getX() + 12.85, e.getY() + 77.0, 20, 2.5);
                                gc.setFill(Color.YELLOW);
                                gc.fillOval(e.getX() + 80.5, e.getY() + 35, 10, 10);/// output Y
                                gc.setFill(Color.RED);
                                gc.fillRect(e.getX() + 91.5, e.getY() + 38, 20, 2.5);
                            }
                            case 2 -> ///AND Gate 2 Input
                                {
                                    System.out.println("Gate selection:" + selectedByUserGateImage);
                                    AND_2_Input_Single_Gate();
                                    gc.setFill(Color.RED);
                                    gc.fillArc(e.getX(), e.getY(), 80, 80, -105, 210, ArcType.CHORD);
                                   /*
                                    gc.setFill(Color.BLUE);
                                    gc.fillOval(e.getX() + 25.5, e.getY(), 10, 10); ///Top input A
                                   */
                                    gc.setFill(Color.RED); ///A- LEG INPUT TOP
                                    gc.fillRect(e.getX() + 12.85, e.getY(), 20, 2.5);
                                    /*
                                    gc.setFill(Color.GREEN);
                                    gc.fillOval(e.getX() + 25.5, e.getY() + 70, 10, 10); ///Top input B
                                    */
                                    gc.setFill(Color.RED);  ///B- LEG INPUT BOTTOM
                                    gc.fillRect(e.getX() + 12.85, e.getY() + 77.0, 20, 2.5);
                                    gc.setFill(Color.RED);  ///Y-LEG OUTPUT
                                    gc.fillRect(e.getX() + 81.65, e.getY() + 38, 20, 2.5);


                                }
                            case 3 -> ///OR Gate 2 Input
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);

                            }

                            case 4 -> ///NOR Gate 2 Input
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);

                            }

                            case 5 -> ///XOR Gate 2 Input
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);

                            }

                            case 6 -> ///XNOR Gate 2 Input
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                            }

                            case 7 -> ///NOT Gate/Inverter
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                            }

                            case 8 -> ///Buffer
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                            }

                            case 9 -> ///NAND_7400_IC
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                                NAND_7400_IC();
                            }

                            case 10 -> ///AND_7408_IC
                            {
                                System.out.println("Gate selection:" + selectedByUserGateImage);
                                ///AND_7408_IC();
                            }


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

        /// THIS IS THE BLUE PRINT LINES

        /*
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
*/
        return canvas;
    }



}
