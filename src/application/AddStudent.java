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
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class AddStudent extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st5) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\2.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.6);
		
		
		Text t1 = new Text();
        t1.setText("Add Student Details");
        t1.setLayoutX(230);
        t1.setLayoutY(100);
        t1.setFill(Color.BLACK);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 50));
        t1.setUnderline(true);
		
        Label l1 = new Label("Name:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l1.setLayoutX(270);
        l1.setLayoutY(180);
        TextField tf1= new TextField();
        tf1.setLayoutX(340);
        tf1.setLayoutY(180);
        
        Label l2 = new Label("Reg.No:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l2.setLayoutX(260);
        l2.setLayoutY(220);
        TextField tf2= new TextField();
        tf2.setLayoutX(340);
        tf2.setLayoutY(220);
        
        Label l3 = new Label("Email Address:");
        l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l3.setLayoutX(200);
        l3.setLayoutY(260);
        TextField tf3= new TextField();
        tf3.setLayoutX(340);
        tf3.setLayoutY(260);
		
        
        Text t2 = new Text();
        t2.setText("Courses:");
        t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        t2.setLayoutX(340);
        t2.setLayoutY(320);
        t2.setUnderline(true);
        
        Text t3 = new Text();
        t3.setText("Marks:");
        t3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        t3.setLayoutX(500);
        t3.setLayoutY(320);
        t3.setUnderline(true);
        
        Label l4 = new Label("1:");
        l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l4.setLayoutX(320);
        l4.setLayoutY(360);
        TextField l5 = new TextField();
        l5.setText("Maths");
        l5.setLayoutX(340);
        l5.setLayoutY(360);
        l5.setEditable(false);
        TextField tf4= new TextField();
        tf4.setLayoutX(500);
        tf4.setLayoutY(360);
        tf4.setPrefWidth(40);
        Label l6 = new Label("/100");
        l6.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l6.setLayoutX(550);
        l6.setLayoutY(360);
        l6.setTextFill(Color.RED);
		
        Label l7 = new Label("2:");
        l7.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l7.setLayoutX(320);
        l7.setLayoutY(390);
        TextField l8 = new TextField();
        l8.setText("Physics");
        l8.setLayoutX(340);
        l8.setLayoutY(390);
        l8.setEditable(false);
        TextField tf5= new TextField();
        tf5.setLayoutX(500);
        tf5.setLayoutY(390);
        tf5.setPrefWidth(40);
        Label l9 = new Label("/100");
        l9.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l9.setLayoutX(550);
        l9.setLayoutY(390);
        l9.setTextFill(Color.RED);
         
        Label l10 = new Label("3:");
        l10.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l10.setLayoutX(320);
        l10.setLayoutY(420);
        TextField l11 = new TextField();
        l11.setText("Chemistry");
        l11.setLayoutX(340);
        l11.setLayoutY(420);
        l11.setEditable(false);
        TextField tf6= new TextField();
        tf6.setLayoutX(500);
        tf6.setLayoutY(420);
        tf6.setPrefWidth(40);
        Label l12 = new Label("/100");
        l12.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l12.setLayoutX(550);
        l12.setLayoutY(420);
        l12.setTextFill(Color.RED);
        
        Label l13 = new Label("4:");
        l13.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l13.setLayoutX(320);
        l13.setLayoutY(450);
        TextField l14 = new TextField();
        l14.setText("English");
        l14.setLayoutX(340);
        l14.setLayoutY(450);
        l14.setEditable(false);
        TextField tf7= new TextField();
        tf7.setLayoutX(500);
        tf7.setLayoutY(450);
        tf7.setPrefWidth(40);
        Label l15 = new Label("/100");
        l15.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l15.setLayoutX(550);
        l15.setLayoutY(450);
        l15.setTextFill(Color.RED);
        
        Label l16 = new Label("5:");
        l16.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l16.setLayoutX(320);
        l16.setLayoutY(480);
        TextField l17 = new TextField();
        l17.setText("Islamiat");
        l17.setLayoutX(340);
        l17.setLayoutY(480);
        l17.setEditable(false);
        TextField tf8= new TextField();
        tf8.setLayoutX(500);
        tf8.setLayoutY(480);
        tf8.setPrefWidth(40);
        Label l18 = new Label("/100");
        l18.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        l18.setLayoutX(550);
        l18.setLayoutY(480);
        l18.setTextFill(Color.RED);
        
        Button b = new Button();
        b.setText("Add");
        b.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b.setLayoutX(380);
        b.setLayoutY(540);
        
        b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				String stDetails="";
				
				stDetails+=tf1.getText()+"\t\t\t";
				stDetails+=tf2.getText()+"\t\t\t";
				stDetails+=tf3.getText()+"\t\t\t\t";
				stDetails+=l5.getText()+"="+tf4.getText()+"\t";
				stDetails+=l8.getText()+"="+tf5.getText()+"\t";
				stDetails+=l11.getText()+"="+tf6.getText()+"\t";
				stDetails+=l14.getText()+"="+tf7.getText()+"\t";
				stDetails+=l17.getText()+"="+tf8.getText();
				
				Connection cnn = new Connection();
				try {
					cnn.writetoStudent(stDetails);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Student Added");
                a.setHeaderText(null);
                a.showAndWait();
                
                Welcome w= new Welcome();
                try {
					w.start(st5);
				} catch (Exception e) {
					e.printStackTrace();
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
				Welcome w = new Welcome();
				try {
					w.start(st5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        
		Group root = new Group(imgV,t1,l1,tf1,l2,tf2,l3,tf3,t2,t3,l4,tf4,l5,l6,l7,l8,l9,
				tf5,l10,l11,l12,tf6,tf7,tf8,l13,l14,l15,l16,l17,l18,b,b1);
        Scene scene = new Scene(root, 800, 600);
        st5.setScene(scene);
        st5.setResizable(false);
        st5.setTitle("Student Management System----->Welcome----->Add Student");
        st5.show();
		
	}

}
