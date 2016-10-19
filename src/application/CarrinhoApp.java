package application;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarrinhoApp extends Application{
	
	private AnchorPane pane;
	private TableView<Filme> tbCarrinho; // janela com pokemons
	private TableColumn<Filme, String> columnFilme; // tabela
	private TableColumn<Filme, String> columnDescricao; // tabela
	private TableColumn<Filme, Integer> columnAno; // tabela
	private TableColumn<Filme, Integer> columnTemporada; // tabela
	private TableColumn<Filme, Integer> columnEpisodio; // tabela
	private TableColumn<Filme, Integer> columnDuracao; // tabela
	private TableColumn<Filme, String> columnCategoria; // tabela
	private TableColumn<Filme, String> columnDiretor; // tabela
	private TableColumn<Filme, String> columnAtor; // tabela
	private TableColumn<Filme, Integer> columnFaixa; // tabela
	private static ObservableList<Filme> listItens =
							FXCollections.observableArrayList(); //lista dos itens
	private static Stage stage;
	private Button btExcluir, btVoltarVitrine, btConfirmarCompra;
	
	private void initItens() {
		// TODO Auto-generated method stub
		List<Filme> filmes = VitrineAppAdmin.getCarrinho().getFilmes();
		listItens.clear();
		
		for(Filme p : filmes)
			listItens.add(p);
		this.tbCarrinho.setItems(listItens);
		
	}

	private void initListeners(){
		btVoltarVitrine.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				CarrinhoApp.getStage().close();
				ItemVitrineApp.getStage().close();
			}
			
		});
		
		this.btConfirmarCompra.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try{
					new CompraConfirmadaApp().start(new Stage());
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
		
	}

	private void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(800, 600);
		this.pane.setStyle("-fx-background-color: linear-gradient("
				+ "from 0% 0% to 100% 100%, silver 0%, silver 100%);");
		
		this.tbCarrinho = new TableView<Filme>();
		this.tbCarrinho.setPrefSize(780, 550);
		
		this.columnFilme = new TableColumn<>("Filme");
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
		
		this.btConfirmarCompra = new Button("Confirmar compra");
		this.btExcluir = new Button("Excluir");
		this.btVoltarVitrine = new Button("Voltar a vitrine");
		
		this.tbCarrinho.getColumns().addAll(columnFilme, columnDescricao, columnAno, columnTemporada, columnEpisodio, columnDuracao, columnCategoria,columnDiretor, columnAtor, columnFaixa);
		this.pane.getChildren().addAll(tbCarrinho, btConfirmarCompra, btExcluir, btVoltarVitrine);
	}

	private void initLayout(){
		
		this.tbCarrinho.setLayoutX((this.pane.getWidth()-this.tbCarrinho.getWidth())/2);
		this.tbCarrinho.setLayoutY(this.btConfirmarCompra.getHeight()+6);
		
		this.btVoltarVitrine.setLayoutX((this.pane.getWidth()-this.tbCarrinho.getWidth()) /2);
		this.btVoltarVitrine.setLayoutY(3);
		
		this.btConfirmarCompra.setLayoutX(this.pane.getWidth()/2 - this.btConfirmarCompra.getWidth()/2);
		this.btConfirmarCompra.setLayoutY(3);
		
		this.btExcluir.setLayoutX(this.pane.getWidth()-this.btExcluir.getWidth()-((this.pane.getWidth()-this.tbCarrinho.getWidth())/2));
		this.btExcluir.setLayoutY(3);
		
		//this.columnPokemon.prefWidthProperty().bind(this.tbCarrinho.widthProperty().multiply(0.1));
		//this.columnForca.prefWidthProperty().bind(this.tbCarrinho.widthProperty().multiply(0.1));
		//this.columnVantagem.prefWidthProperty().bind(this.tbCarrinho.widthProperty().multiply(0.2));
		//this.columnDesvantagem.prefWidthProperty().bind(this.tbCarrinho.widthProperty().multiply(0.2));
		
	}
	
	protected static Stage getStage() {
		// TODO Auto-generated method stub
		return stage;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try{
			initComponents();
			initListeners();

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Carrinho de Pokemons");
			stage.show();
			initLayout();
			CarrinhoApp.setStage(stage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void setStage(Stage stage2) {
		// TODO Auto-generated method stub
		
		stage = stage2;
	}
}
