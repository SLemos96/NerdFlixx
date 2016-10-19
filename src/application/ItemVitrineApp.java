package application;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

public class ItemVitrineApp extends Application{
	
	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbForca, lbNome, lbStamina, lbSaude, LbDefesa, lbTipo, lbVantagem, lbDesvantagem;
	private Button btAddCarrinho;
	private static Stage stage;
	private static Filme filme;
	private static int index;
	private static String[] imgFilmes;
	
	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(600, 400);
		initItens();
		
		this.imgItem = new ImageView(imgFilmes[index]);
		//this.lbForca = new Label("Força: "+filme.getForca());
		this.lbNome = new Label("Nome: "+filme.getNome());
		//this.lbSaude = new Label("Saude: "+filme.getSaude());
		//this.LbDefesa = new Label("Defesa: "+filme.getDefesa());
		//this.lbStamina = new Label("Stamina: "+filme.getStamina());
		//this.lbTipo = new Label("Tipo: "+filme.getTipo());
		//this.lbVantagem = new Label("Vantagem: "+filme.getVantagem());
		//this.lbDesvantagem = new Label("Desvantagem: "+filme.getDesvantagem());
		this.btAddCarrinho = new Button("Adicionar no carrinho");
		
		/*this.pane.getChildren().addAll(this.lbForca, this.lbNome ,this.imgItem, this.btAddCarrinho,
			this.lbDesvantagem, this.lbVantagem, this.lbTipo, this.lbStamina,
			this.LbDefesa, this.lbSaude);*/
		
		this.pane.getChildren().addAll(this.imgItem ,this.lbNome, this.btAddCarrinho);
	}
	
	private void initLayout(){
		//this.imgItem.setLayoutY(this.pane.getHeight()/2 - this.imgItem.getImage().getHeight()/2);
		this.imgItem.setLayoutY(10);
		this.imgItem.setLayoutX(55);
		this.imgItem.setEffect(new Reflection());
		
		this.btAddCarrinho.setLayoutX(this.pane.getWidth()/2 + 80);
		this.btAddCarrinho.setLayoutY(this.pane.getHeight()/2 + 80);
		
		this.lbNome.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbNome.setLayoutY(this.pane.getHeight()/2 - 100);
		
		this.lbForca.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbForca.setLayoutY(this.pane.getHeight()/2 - 80);
		
		this.lbSaude.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbSaude.setLayoutY(this.pane.getHeight()/2 - 60);
		
		this.LbDefesa.setLayoutX(this.pane.getWidth()/2 + 80);
		this.LbDefesa.setLayoutY(this.pane.getHeight()/2 - 40);
		
		this.lbStamina.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbStamina.setLayoutY(this.pane.getHeight()/2 - 20);
		
		this.lbTipo.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbTipo.setLayoutY(this.pane.getHeight()/2 - 0);
		
		this.lbVantagem.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbVantagem.setLayoutY(this.pane.getHeight()/2 + 20);
		
		this.lbDesvantagem.setLayoutX(this.pane.getWidth()/2 + 80);
		this.lbDesvantagem.setLayoutY(this.pane.getHeight()/2 + 40);
	}
	
	private void initItens(){
		imgFilmes = new String[]{
					"resources/imgs/pikachu.png",
					"resources/imgs/charmander.png",
					"resources/imgs/zubat.png",
					"resources/imgs/ratata.png",
					"resources/imgs/pidgey.png"
				};
	}

	private void initListeners(){
		this.btAddCarrinho.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				VitrineAppAdmin.getCarrinho().addFilmes(filme);
				try{
					new CarrinhoApp().start(new Stage());
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	private void fecharAplicacao(){
		System.out.println("flw");
		System.exit(0);
	}
	
	public void start(Stage stage) throws Exception{
		try{
			initComponents();
			initListeners();
			//initLayout();
			
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Detalhes do Filme");
			stage.show();
			initLayout();
			ItemVitrineApp.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		launch(args);
	}*/
	
	public static void setFilme(Filme filme){
		ItemVitrineApp.filme = filme;
		
	}

	public static void setIndex(int index) {
		ItemVitrineApp.index = index;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ItemVitrineApp.stage = stage;
	}

}
