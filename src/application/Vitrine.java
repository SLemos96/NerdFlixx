package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Vitrine {
	private static List<Filme> filmes = new ArrayList<Filme>();
	
	public void addFilmes(Filme... filmes){
		for(Filme p : filmes)
			this.filmes.add(p);
	}
	
	public List<Filme> getFilmes(){
		return this.filmes;
	}
	
}
