package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Log_In extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st1) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		
        
		Text t1 = new Text();
        t1.setText("Login");
        t1.setLayoutX(300);
        t1.setLayoutY(100);
        t1.setFill(Color.BLACK);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 60));
        t1.setUnderline(true);
        
        Label l1 = new Label("ID:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l1.setLayoutX(330);
        l1.setLayoutY(200);
        TextField tf= new TextField();
        tf.setLayoutX(370);
        tf.setLayoutY(200);
        
        Label l2 = new Label("Password:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l2.setLayoutX(270);
        l2.setLayoutY(240);
        PasswordField pf = new PasswordField();
        pf.setLayoutX(370);
        pf.setLayoutY(240);
        CheckBox c = new CheckBox("Show Password");
        c.setLayoutX(370);
        c.setLayoutY(270);
        Label l3 = new Label();
        l3.setLayoutX(370);
        l3.setLayoutY(290);
        
        TextField text = new TextField();
        text.setLayoutX(1000);
        text.setLayoutY(240);
        
        c.setOnAction(event -> {
        	if (c.isSelected()) {
                l3.setText(pf.getText());
                text.setText(pf.getText());
                text.setLayoutX(370);
                pf.setLayoutX(5000);
            } else {
                l3.setText("");
                text.setLayoutX(1000);
                pf.setLayoutX(370);
            }
        });
        
        
        
        Button b1 = new Button();
        b1.setText("Login");
        b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 17));
        b1.setLayoutX(330);
        b1.setLayoutY(320);
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String n,p;
			
				n=tf.getText();
				p=pf.getText();
				
				Connection cnn = new Connection();
				cnn.openLoginFile();
				boolean check= cnn.readLoginFile(n, p);
				if(check==true) {
					Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Login Successfull");
                    a.setHeaderText(null);
                    a.showAndWait();
                    Welcome w= new Welcome();
                    try {
						w.start(st1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Login Unsuccessfull");
                    a.setHeaderText(null);
                    a.showAndWait();
				}
			}
			
		});
        
        
        
        Label l4 = new Label("OR");
        l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 17));
        l4.setLayoutX(340);
        l4.setLayoutY(360);
        Button b2 = new Button();
        b2.setText("SignUp");
        b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 17));
        b2.setLayoutX(330);
        b2.setLayoutY(390);
        
        
        b2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Sign_Up snup = new Sign_Up();
				try {
					snup.start(st1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
		
		Group root = new Group(imgV,text,t1,l1,tf,l2,pf,c,l3,b1,l4,b2);
        Scene scene = new Scene(root, 800, 600);
        st1.setScene(scene);
        st1.setResizable(false);
        st1.setTitle("Student Management System----->Login");
        st1.show();
	}
}
