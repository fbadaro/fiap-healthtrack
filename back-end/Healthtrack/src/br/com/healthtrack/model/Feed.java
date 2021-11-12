package br.com.healthtrack.model;

import java.util.ArrayList;
import java.util.List;

/** Classe que abstrai Alimentos
 * @author Grupo Lovelace - XV
 * @implNote Implementa a interface BaseRepository
 * @version 1.0
 */
public class Feed implements BaseRepository<Feed>  {
	
	/**
	 * id úncio do alimento
	 */
	private int id;
	
	/**
	 * Nome do alimento
	 */
	private String name;
	
	/**
	 * Lista de alimentos
	 */
	private List<Feed> feeds = new ArrayList<Feed>();
	
	public Feed(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	public Feed(String name) {
		
		this.id = (((int) (Math.random() * (100 - 50) + 50)));
		this.name = name;
	}
	
	/**
	 * Método para retorno do id do alimento
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para retorno do nome do alimento
	 * @return
	 */
	public String getName() {
		return name;
	}	
	
	/**
	 * Método para retorno da lista de alimentos
	 * @return lista
	 */
	public List<Feed> ListAll() {
		return feeds;
	}
	
	/**
	 * Método para adicionar lista de alimentos
	 * @param feeds é a instância a ser adicionada
	 */
	public void setFeeds(Feed feeds) {
		this.feeds.add(feeds);
	}
	
	@Override
	public Feed Get(int id) {
		System.out.println(String.format("Retornando a alimentacao %s da base com sucesso", this.name));	
		return this;
	}

	@Override
	public void Add(Feed feed) {
		System.out.println(String.format("Alimentacao %s adicionada na base com sucesso", feed.name));	
	}

	@Override
	public void Update(Feed feed) {
		System.out.println(String.format("Alimentacao %s atualizada na base com sucesso", feed.name));
	}

	@Override
	public void Delete(Feed feed) {
		System.out.println(String.format("Alimentacao %s deletada da base com sucesso", feed.name));	
	}
	
}
