package application;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

public class LoginApp extends Application{
	
	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar, btEntrarAdmin, btSair;
	private static Stage stage;
	private boolean admin;
	
	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(400, 300);
		
		
		this.txLogin = new TextField();
		this.txLogin.setPromptText("Digite seu login...");
		this.txSenha = new PasswordField();
		this.txSenha.setPromptText("Digite sua senha...");
		this.btEntrar = new Button("Entrar");
		this.btEntrarAdmin = new Button("Entrar como admin");
		this.btSair = new Button("Sair");
		
		this.pane.getChildren().addAll(txLogin, txSenha, btEntrar, btEntrarAdmin, btSair);
	}
	
	private void initLayout(){
		
		this.pane.getStyleClass().add("pane");
		this.btEntrar.getStyleClass().add("btEntrar");
		this.btEntrar.getStyleClass().add("btEntrarAdmin");
		this.btSair.getStyleClass().add("btSair");
		
		txLogin.setLayoutX((this.pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btEntrarAdmin.setLayoutX((pane.getWidth() - btEntrarAdmin.getWidth()) / 2);
		btEntrarAdmin.setLayoutY(190);
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(230);
	}
	
	private void logar(){
		if(admin){
			if(txLogin.getText().equals("admin")&& //fazer a busca no banco
					txSenha.getText().equals("123")){
				try{
					new VitrineAppAdmin().start(new Stage());
					LoginApp.getStage().close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Login e/ou "
									+ "senha ivalidos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			if(txLogin.getText().equals("user")&& //fazer a busca no banco
					txSenha.getText().equals("123")){
				try{
					new VitrineAppUser().start(new Stage());
					LoginApp.getStage().close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Login e/ou "
									+ "senha ivalidos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	private void initListeners(){
		this.btSair.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				fecharAplicacao();
				
			}
		});
		
		this.btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				admin = false;
				logar();
				
			}
		});
		
		this.btEntrarAdmin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				admin = true;
				logar();
				
			}
		});
		
		/*this.txSenha.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				logar();
				
			}
		});*/
	}
	
	private void fecharAplicacao(){
		System.out.println("flw");
		System.exit(0);
	}
	
	public void start(Stage stage) throws Exception{
		try{
			initComponents();
			initListeners();
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add("application/login.css");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Login - NerdFlix");
			stage.show();
			initLayout();
			LoginApp.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		LoginApp.stage = stage;
	}

}
