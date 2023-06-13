package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DeleteStudent extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st4) throws Exception {
		
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
        textArea.setMaxHeight(200);
        textArea.setLayoutX(100);
        textArea.setLayoutY(100);
        textArea.setEditable(false);
		
        
		Label l = new Label("Reg.No.:");
		l.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		l.setLayoutX(240);
		l.setLayoutY(390);
		TextField tf = new TextField();
		tf.setLayoutX(320);
		tf.setLayoutY(390);
		
		Button b = new Button();
		b.setText("Delete");
        b.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		b.setLayoutX(350);
		b.setLayoutY(450);
		
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String del=tf.getText();
				Connection cnn = new Connection();
				cnn.openStudentFile();
				boolean stats = cnn.readStudentFile(del);
				if(stats==true) {
				try {
					cnn.deleteTextFromFile(del);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Student Information Deleted");
                a.setHeaderText(null);
                a.showAndWait();
				}
				else {
					Alert a = new Alert(Alert.AlertType.ERROR);
	                a.setContentText("Student Not Found");
	                a.setHeaderText(null);
	                a.showAndWait();
				}
			}
			
		});
		
		Button b1 = new Button();
        b1.setText("Back");
        b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(100);
        b1.setLayoutY(540);
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Welcome w= new Welcome();
				try {
					w.start(st4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		
		
		
		Group root = new Group(imgV,textArea,tf,b,b1,l);
        Scene scene = new Scene(root, 800, 600);
        st4.setScene(scene);
        st4.setResizable(false);
        st4.setTitle("Student Management System----->Welcome----->Delete Student");
        st4.show();
		
	}

}
