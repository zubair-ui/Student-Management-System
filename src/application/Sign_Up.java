package application;

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

public class Sign_Up extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st2) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		
        
		Text t1 = new Text();
        t1.setText("Sign Up");
        t1.setLayoutX(300);
        t1.setLayoutY(100);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 60));
        t1.setUnderline(true);
        
        Label l1 = new Label("Name:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l1.setLayoutX(300);
        l1.setLayoutY(200);
        TextField tf1= new TextField();
        tf1.setLayoutX(370);
        tf1.setLayoutY(200);
        
        Label l2 = new Label("Teacher ID:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l2.setLayoutX(250);
        l2.setLayoutY(240);
        TextField tf2= new TextField();
        tf2.setLayoutX(370);
        tf2.setLayoutY(240);
        
        Label l3 = new Label("Email Address:");
        l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l3.setLayoutX(220);
        l3.setLayoutY(280);
        TextField tf3= new TextField();
        tf3.setLayoutX(370);
        tf3.setLayoutY(280);
        
        Label l4 = new Label("Password:");
        l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l4.setLayoutX(270);
        l4.setLayoutY(320);
        PasswordField pf1 = new PasswordField();
        pf1.setLayoutX(370);
        pf1.setLayoutY(320);
        
        Label l5 = new Label("Confirm Password:");
        l5.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l5.setLayoutX(190);
        l5.setLayoutY(360);
        PasswordField pf2 = new PasswordField();
        pf2.setLayoutX(370);
        pf2.setLayoutY(360);
        
        
        
        
        Button b1 = new Button();
        b1.setText("Sign Up");
        b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(340);
        b1.setLayoutY(440);
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String sDetails="";
				String lDetails="";
				
				sDetails+=tf1.getText()+",";
				sDetails+=tf2.getText()+",";
				sDetails+=tf3.getText()+",";
				sDetails+=pf1.getText();
				
				lDetails+=tf2.getText()+" ";
				lDetails+=pf1.getText();
				
				String tempP=pf1.getText();
				String tempCp=pf2.getText();
				
				if(tempP.equals(tempCp)) {
					Connection cnn = new Connection();
					try {
						cnn.writetoLogin(lDetails);
						cnn.writetoSignup(sDetails);
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Sign Up Confirmed");
                    a.setHeaderText(null);
                    a.showAndWait();
					Log_In lg = new Log_In();
					try {
						lg.start(st2);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				else {
					Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Passwords do not Match");
                    a.setHeaderText(null);
                    a.showAndWait();
				}
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
				Log_In lg = new Log_In();
				try {
					lg.start(st2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
		Group root = new Group(imgV,t1,l1,tf1,l2,tf2,l3,tf3,l4,pf1,l5,pf2,b1,b);
        Scene scene = new Scene(root, 800, 600);
        st2.setScene(scene);
        st2.setResizable(false);
        st2.setTitle("Student Management System----->Sign Up");
        st2.show();
		
	}

}
