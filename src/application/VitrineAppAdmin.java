package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VitrineAppAdmin extends Application{

	private AnchorPane pane;
	private TextField txPesquisa; // caixa de pesquisa
	private ImageView imgItem;
	/*private TableView<Filme> tbVitrine; // janela com Filmes
	private TableColumn<Filme, String> columnFilme; // tabela
	private TableColumn<Filme, String> columnDescricao; // tabela
	private TableColumn<Filme, Integer> columnAno; // tabela
	private TableColumn<Filme, Integer> columnTemporada; // tabela
	private TableColumn<Filme, Integer> columnEpisodio; // tabela
	private TableColumn<Filme, Integer> columnDuracao; // tabela
	private TableColumn<Filme, String> columnCategoria; // tabela
	private TableColumn<Filme, String> columnDiretor; // tabela
	private TableColumn<Filme, String> columnAtor; // tabela
	private TableColumn<Filme, Integer> columnFaixa; // tabela*/
	private static ObservableList<Filme> listItens =
							FXCollections.observableArrayList(); //lista dos itens
	private boolean admin = false;
	private static Carrinho favList;
	private Button btSair;
	private static Stage stage;
	private List imageview;

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try{
			initComponents();
			initListeners();

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("NerdFlix Admin");
			stage.show();
			initLayout();
			VitrineAppAdmin.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static void setStage(Stage stage) {
		// TODO Auto-generated method stub
		VitrineAppAdmin.stage = stage;
		
	}

	private void initLayout() {
		// TODO Auto-generated method stub
		DropShadow ds = new DropShadow();
		ds.setSpread(0.3);
		ds.setColor(Color.BLUE);
		this.txPesquisa.setEffect(ds);
		InnerShadow is = new InnerShadow();
		is.setColor(Color.RED);
		this.btSair.setEffect(is);
		
		this.txPesquisa.setLayoutX(this.pane.getWidth()-this.txPesquisa.getWidth());//-((this.pane.getWidth()-this.pane.getWidth())/2));
		this.txPesquisa.setLayoutY(3);
		
		this.btSair.setLayoutX(0);//(this.pane.getWidth()-this.tbVitrine.getWidth())/2);
		this.btSair.setLayoutY(3);
		
	}
	
	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(800, 600);
		this.pane.setStyle("-fx-background-color: linear-gradient("
				+ "from 0% 0% to 100% 100%, silver 0%, silver 100%);");
		
		initItens();
		//this.imgItem = new ImageView();
		
		
		this.txPesquisa = new TextField();
		this.txPesquisa.setPromptText("Digite o filme para pesquisa");
		
		//this.tbVitrine = new TableView<Filme>();
		//this.tbVitrine.setPrefSize(780, 550);
		
		this.btSair = new Button("Sair");
		
		if(admin == true){
			
		}else{
			this.pane.getChildren().addAll(txPesquisa, /*tbVitrine,*/ btSair);
		}
		
		this.setCarrinho(new Carrinho());
	
		for(int i = 0; i < listItens.size(); i++){
		imageview.get(i).setImage(listItens.get(i));
		}
		
		//initItens();
	}
	
	private void initItens() {
		
		Vitrine v = new Vitrine();
		
		imageview = new ArrayList<ImageView>();
		
		v.addFilmes(new Filme(new Image("resources/imgs/pikachu.png"), "Teste", "HAÇA", 12, 8, 35, 100, "Cat", "Dir", "Ator", 10));
		for(Filme filme : v.getFilmes())
			listItens.add(filme);
		
		//this.tbVitrine.setItems(listItens);
		
	}
	
	private ObservableList<Filme> findItems(){
		ObservableList<Filme> itensEncontrados = FXCollections.observableArrayList();
		for(Filme itens :
			this.listItens){
			if(itens.getNome().contains(this.txPesquisa.getText())){
				itensEncontrados.add(itens);
			}
		}
		return itensEncontrados;
	}
	
	private void initListeners(){
		
		/*this.tbVitrine.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event){
				if(event.isPrimaryButtonDown() && event.getClickCount() == 2){
					int indexSelFilme = tbVitrine.getSelectionModel().getSelectedIndex();
					ItemVitrineApp.setFilme(listItens.get(indexSelFilme));
					ItemVitrineApp.setIndex(indexSelFilme);
					
					try{
						new ItemVitrineApp().start(new Stage());
					} catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			}
		});*/
		
		this.txPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(!txPesquisa.getText().equals("")){
					findItems();//tbVitrine.setItems(findItems());
					System.out.println("");
				} else{
					System.out.println("");//tbVitrine.setItems(listItens);
				}
			}
		});
		
		this.btSair.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				fecharAplicacao();
				/*try{
					new CompraConfirmadaApp().start(new Stage());
				}catch (Exception e){
					e.printStackTrace();
				}*/
			}
		});
	}

	private void fecharAplicacao(){
		System.out.println("flw");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}



	public static Carrinho getCarrinho() {
		return favList;
	}



	private static void setCarrinho(Carrinho carrinho) {
		VitrineAppAdmin.favList = carrinho;
	}

}