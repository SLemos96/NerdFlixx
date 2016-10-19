package application;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private static List<Filme> filmes = new ArrayList<Filme>();
	
	public void addFilmes(Filme... filmes){
		for(Filme p : filmes)
			this.filmes.add(p);
	}
	
	public List<Filme> getFilmes(){
		return this.filmes;
	}
}
