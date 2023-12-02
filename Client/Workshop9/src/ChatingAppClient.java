import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatingAppClient extends Application {

//	Class Attributes
//	----------------
	private Socket socket;
	private PrintWriter output;
	private String clientName = "";
	private ClientThread client;
	private TextArea chatArea;
	private TextField inputField = new TextField();
	private Button sendButton = new Button("Send");

	@Override
	public void start(Stage primaryStage) {
		
//		Setting up the root pane
//		------------------------
		BorderPane root = new BorderPane();
		VBox chatBox = new VBox(10);
		
//		Configuring the TextArea box of the Chats
//		-----------------------------------------
		chatArea = new TextArea();
		chatArea.setEditable(false);
		chatArea.setDisable(true);

//		Setting up the Children Pane
//		----------------------------
		HBox nameBox = new HBox(10);
		Label nameLbl = new Label("  Enter your name:");
		TextField nameField = new TextField();
		Button nameButton = new Button("Submit");
		
//		Event Handlers
//		--------------
		nameButton.setOnAction(e -> {
			clientName = nameField.getText().trim();
			if (!clientName.isEmpty()) {
				nameField.setDisable(true);
				nameButton.setDisable(true);
				chatArea.setDisable(false);
				inputField.setDisable(false);
				sendButton.setDisable(false);
				output.println(clientName + " Joined the chat");
				if(clientName == "") {
					primaryStage.setTitle("Chat Client");
				}
				else {
					primaryStage.setTitle(clientName);
				}
			}
		});

		nameBox.getChildren().addAll(nameLbl,nameField, nameButton);

//		Setting another Children Pane for the Name Input
//		------------------------------------------------
		HBox inputBox = new HBox(10);
		inputField.setPromptText("Enter your message");
		inputField.setDisable(true);
		sendButton.setDisable(true);

		sendButton.setOnAction(e -> {
			handleInput(inputField);
		});

		inputField.setOnAction(e -> {
			handleInput(inputField);
		});

//		Adding the Nodes to the Panes
//		-----------------------------
		inputBox.getChildren().addAll(inputField, sendButton);
		chatBox.getChildren().addAll(nameBox, chatArea, inputBox);
		root.setCenter(chatBox);
		inputBox.setAlignment(Pos.CENTER);
		chatBox.setAlignment(Pos.CENTER);

//		Configuring the Scene and the Stage Title
//		----------------------------------------
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("Unknown User");
		primaryStage.setScene(scene);
		primaryStage.show();

//		Setting up the Socket
//		---------------------
		try {
			socket = new Socket("localhost", 8000);
			output = new PrintWriter(socket.getOutputStream(), true);
			client = new ClientThread(socket, this);
			new Thread(client).start();
		} catch (IOException e) {
			System.out.println("Client Error: " + e.getMessage());
		}

	}

//	Function to handle the input
//	----------------------------
	private void handleInput(TextField inputField) {
		String inputVal = inputField.getText();
		if (!inputVal.isEmpty()) {
			output.println(clientName + ": " + inputVal);
			inputField.clear();
		}
	}

//	Function to Display the Message
//	-------------------------------
	public void displayMessage(String message) {
		chatArea.appendText(message + "\n");
	}
	
//	Main Function
//	-------------
	public static void main(String[] args) {
		launch(args);
	}
}