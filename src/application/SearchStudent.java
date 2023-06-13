package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SearchStudent extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st7) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\2.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.6);
		
		
		
		Label l = new Label("Reg.No.:");
		l.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l.setLayoutX(250);
        l.setLayoutY(100);
        TextField tf= new TextField();
        tf.setLayoutX(340);
        tf.setLayoutY(100);
		
        
        Button b1 = new Button();
        b1.setText("Search");
        b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(350);
        b1.setLayoutY(150);
        
        
        TextArea textArea = new TextArea();
        textArea.setLayoutX(5000);
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Connection cnn = new Connection();
				
				try {
					cnn.searchTextFromFile(tf.getText());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				
		        String filePath = "E:\\study\\Eclipse projects\\OOPProject\\tempFile.txt";
		        StringBuilder contents = new StringBuilder();

		        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                contents.append(line).append("\n");
		            }
		        } catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        textArea.setText(contents.toString());
		        textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		        textArea.setMaxWidth(600);
		        textArea.setMaxHeight(100);
		        textArea.setLayoutX(150);
		        textArea.setLayoutY(300);
		        textArea.setEditable(false);
		        
		        cnn.deleteSearchFile();
				
			}
			
		});
        
        
        Button b = new Button();
        b.setText("Back");
        b.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b.setLayoutX(100);
        b.setLayoutY(540);
        
        b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Welcome w= new Welcome();
				try {
					w.start(st7);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Group root = new Group(imgV,textArea,b,b1,l,tf);
        Scene scene = new Scene(root, 800, 600);
        st7.setScene(scene);
        st7.setResizable(false);
        st7.setTitle("Student Management System----->Welcome----->Search Students");
        st7.show();
		
	}

}
