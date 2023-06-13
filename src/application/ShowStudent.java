package application;

import java.io.BufferedReader;
import java.io.FileReader;
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

public class ShowStudent extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st6) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\2.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.6);
		
		TextArea textArea = new TextArea();
        String filePath = "E:\\study\\Eclipse projects\\OOPProject\\Student.txt";
        StringBuilder contents = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contents.append(line).append("\n");
            }
        }
        
        textArea.setText(contents.toString());
        textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        textArea.setMaxWidth(600);
        textArea.setMaxHeight(400);
        textArea.setMinWidth(600);
        textArea.setMinHeight(400);
        textArea.setLayoutX(100);
        textArea.setLayoutY(100);
        textArea.setEditable(false);
        
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
					w.start(st6);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Group root = new Group(imgV,textArea,b);
        Scene scene = new Scene(root, 800, 600);
        st6.setScene(scene);
        st6.setResizable(false);
        st6.setTitle("Student Management System----->Welcome----->Show Students");
        st6.show();
	}

}
