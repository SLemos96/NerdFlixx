package application;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VitrineAppUser extends Application{

	private AnchorPane pane;
	private TextField txPesquisa; // caixa de pesquisa
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

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try{
			initComponents();
			initListeners();

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("NerdFlix User");
			stage.show();
			initLayout();
			VitrineAppUser.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static void setStage(Stage stage) {
		// TODO Auto-generated method stub
		VitrineAppUser.stage = stage;
		
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
		//this.tbVitrine.setLayoutX((this.pane.getWidth()-this.tbVitrine.getWidth())/2);
		//this.tbVitrine.setLayoutY(this.txPesquisa.getHeight()+6);
		
		/*
		this.columnFilme.prefWidthProperty().bind(this.tbVitrine.widthProperty().multiply(0.2));
		this.columnDescricao.prefWidthProperty().bind(this.tbVitrine.widthProperty().multiply(0.1));
		this.columnCategoria.prefWidthProperty().bind(this.tbVitrine.widthProperty().multiply(0.2));
		this.columnDiretor.prefWidthProperty().bind(this.tbVitrine.widthProperty().multiply(0.2));
		*/
		this.btSair.setLayoutX(0);//(this.pane.getWidth()-this.tbVitrine.getWidth())/2);
		this.btSair.setLayoutY(3);
		
	}
	
	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(800, 600);
		this.pane.setStyle("-fx-background-color: linear-gradient("
				+ "from 0% 0% to 100% 100%, silver 0%, silver 100%);");
		
		this.txPesquisa = new TextField();
		this.txPesquisa.setPromptText("Digite o filme para pesquisa");
		
		//this.tbVitrine = new TableView<Filme>();
		//this.tbVitrine.setPrefSize(780, 550);
		
		this.btSair = new Button("Sair");
		
		/*this.columnFilme = new TableColumn<>("Filme");
		this.columnDescricao = new TableColumn<>("Descricao");
		this.columnAno = new TableColumn<>("Ano");
		this.columnTemporada = new TableColumn<>("Temporada");
		this.columnEpisodio = new TableColumn<>("Episodio");
		this.columnDuracao = new TableColumn<>("Duracao");
		this.columnCategoria = new TableColumn<>("Categoria");
		this.columnDiretor = new TableColumn<>("Diretor");
		this.columnAtor = new TableColumn<>("Ator");
		this.columnFaixa = new TableColumn<>("Faixa");
		
		this.columnFilme.setCellValueFactory(new PropertyValueFactory<Filme, String>("Nome"));
		this.columnDescricao.setCellValueFactory(new PropertyValueFactory<Filme, String>("descricao"));
		this.columnAno.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("Ano"));
		this.columnTemporada.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("temporada"));
		this.columnEpisodio.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("Episodio"));
		this.columnDuracao.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("Duracao"));
		this.columnCategoria.setCellValueFactory(new PropertyValueFactory<Filme, String>("Categoria"));
		this.columnDiretor.setCellValueFactory(new PropertyValueFactory<Filme, String>("Diretor"));
		this.columnAtor.setCellValueFactory(new PropertyValueFactory<Filme, String>("ator"));
		this.columnFaixa.setCellValueFactory(new PropertyValueFactory<Filme, Integer>("faixa"));
		
		this.tbVitrine.getColumns().addAll(columnFilme, columnDescricao, 
						columnAno, columnTemporada, columnEpisodio, columnDuracao, 
						columnCategoria,columnDiretor, columnAtor, columnFaixa);*/
		
		if(admin == true){
			
		}else{
			this.pane.getChildren().addAll(txPesquisa, /*tbVitrine,*/ btSair);
		}
		
		this.setCarrinho(new Carrinho());
		
		initItens();
	}
	
	private void initItens() {
		Vitrine v = new Vitrine();
		v.addFilmes(new Filme(new Image("resources/imgs/pikachu.png"), "Teste", "HAÇA", 12, 8, 35, 100, "Cat", "Dir", "Ator", 10));
		for(Filme filme : v.getFilmes())
			listItens.add(filme);
		
		//this.tbVitrine.setItems(listItens);
		
	}
	
	private ObservableList<Filme> findItems(){
		ObservableList<Filme> itensEncontrados = FXCollections.observableArrayList();
		for(Filme itens : this.listItens){
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
		VitrineAppUser.favList = carrinho;
	}

}