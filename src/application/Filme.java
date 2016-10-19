package application;

import javafx.scene.image.*;

public class Filme {
	private Image imagem;
	private String nome;
	private String descricao;
	private int ano;
	private int temporada;
	private int episodio;
	private int duracao;
	private String categoria;
	private String diretor;
	private String ator;
	private int faixa;
	
	public Filme(Image imagem, String nome, String descricao, int ano, int temporada,
					int episodio, int duracao, String categoria, String diretor,
					String atorPrincipal, int faixaEt){
		this.nome = nome;
		this.descricao = descricao;
		this.setAno(ano);
		this.setTemporada(temporada);
		this.setEpisodio(episodio);
		this.setDuracao(duracao);
		this.setCategoria(categoria);
		this.setDiretor(diretor);
		this.setAtor(atorPrincipal);
		this.setFaixa(faixaEt);
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getDescricao(){
		//TODO
		return this.descricao;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getEpisodio() {
		return episodio;
	}

	public void setEpisodio(int episodio) {
		this.episodio = episodio;
	}

	public double getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public double getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getFaixa() {
		return faixa;
	}

	public void setFaixa(int faixaEt) {
		this.faixa = faixaEt;
	}

}
