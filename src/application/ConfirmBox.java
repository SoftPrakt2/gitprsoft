package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	
	//speichert antwort je nach dem welcher knopf gedr�ckt wird
	static boolean answer;

		
		public static boolean display(String title, String message) {
			Stage window = new Stage();
			
			//kann hinteres windows nicht klicken
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(250);
			Label label = new Label();
			label.setText(message);
			
			//create two buttons
			Button yesButton = new Button("yes");
			Button noButton = new Button("no");
			
			yesButton.setOnAction(e -> {
				answer = true;
				window.close();
				
			});
			
			noButton.setOnAction(e -> {
				answer = false;
				window.close();
				
			});
			
		
			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, yesButton, noButton);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			return answer;
		}
		
		
		
		
		
		
		
		
	

}
