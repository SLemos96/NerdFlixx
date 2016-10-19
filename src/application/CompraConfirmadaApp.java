package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

public class CompraConfirmadaApp extends Application{
	
	private AnchorPane pane;
	private Label lbConfirmaCompra;
	private static Stage stage;
	
	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(200, 50);
		
		this.lbConfirmaCompra = new Label("Compra Confirmada");
		
		this.pane.getChildren().addAll(lbConfirmaCompra);
	}
	
	private void initLayout(){
		lbConfirmaCompra.setLayoutX((this.pane.getWidth() - lbConfirmaCompra.getWidth()) / 2);
		lbConfirmaCompra.setLayoutY((this.pane.getHeight() - lbConfirmaCompra.getHeight()) / 2);
	}

	private void initListeners(){
	}
	
	public void start(Stage stage) throws Exception{
		try{
			initComponents();
			initListeners();
			//initLayout();
			
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Compra Confirmada");
			stage.show();
			initLayout();
			LoginApp.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CompraConfirmadaApp.stage = stage;
	}

}
