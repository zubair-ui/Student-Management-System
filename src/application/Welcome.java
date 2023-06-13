package application;


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

public class Welcome extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st3) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OOPProject\\src\\images\\2.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.7);
		
		Text t1 = new Text();
        t1.setText("Welcome");
        t1.setLayoutX(300);
        t1.setLayoutY(80);
        t1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 60));
        t1.setUnderline(true);
		
		Button b1 = new Button();
		b1.setText("Add Student");
		b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(170);
        b1.setLayoutY(150);
       
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				AddStudent as = new AddStudent();
				try {
					as.start(st3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
		Button b2 = new Button();
		b2.setText("Show Students");
		b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b2.setLayoutX(430);
        b2.setLayoutY(150);
       
        
        b2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				ShowStudent st = new ShowStudent();
				try {
					st.start(st3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        Button b4 = new Button();
		b4.setText("Delete Student");
		b4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b4.setLayoutX(170);
        b4.setLayoutY(350);
       
        
        b4.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				DeleteStudent dt = new DeleteStudent();
				try {
					dt.start(st3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        Button b3 = new Button();
		b3.setText("Logout");
		b3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b3.setLayoutX(350);
        b3.setLayoutY(530);
       
        
        b3.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				Log_In lg = new Log_In();
				try {
					lg.start(st3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        Button b5 = new Button();
		b5.setText("Search Student");
		b5.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b5.setLayoutX(430);
        b5.setLayoutY(350);
       
        
        b5.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				SearchStudent sst = new SearchStudent();
				try {
					sst.start(st3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		
		Group root = new Group(imgV,b1,b2,b3,b4,b5,t1);
        Scene scene = new Scene(root, 800, 600);
        st3.setScene(scene);
        st3.setResizable(false);
        st3.setTitle("Student Management System----->Welcome");
        st3.show();
		
	}


}
