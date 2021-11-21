package br.com.healthtrack.model;

import java.time.LocalDate;

/**
 * Classe que abstrai Refeição
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 * @version 1.0
 */
public class UserFeed implements BaseRepository<UserFeed> {
	
	/**
	 * Instância de usuário
	 */
	private User user;
	
	/**
	 * Instância de alimento
	 */
	private Feed feed;
	
	/**
	 * id único da classe
	 */
	private int id;
	
	/**
	 * Quantidade
	 */
	private double quantity;
	
	/**
	 * Calorias
	 */
	private double cal;
	
	/**
	 * Tipo 
	 */
	private int type;
	
	/** 
	 * Data da refeição
	 */
	private LocalDate date;
	
	public UserFeed(int id, User user, Feed feed, double quantity, int type, LocalDate date, double cal) {
		
		this.id = id;
		this.user = user;
		this.feed = feed;
		this.quantity = quantity;
		this.type = type;
		this.date = date;
		this.cal = cal;
		
		ValidateUserFeed();
	}

	public UserFeed(User user, Feed feed, double quantity, int type, LocalDate date, double cal) {
				
		this.user = user;
		this.feed = feed;
		this.quantity = quantity;
		this.type = type;
		this.date = date;
		this.cal = cal;
		
		ValidateUserFeed();
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateUserFeed() {
		if(this.user == null || this.feed == null || this.quantity == 0) {
			throw new IllegalArgumentException("Os campos nao podem estar vazios");
		}		
	}
	
	/**
	 * Método para retorno do id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para retorno do usuário
	 * @return usuário
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Método para retorno do alimento
	 * @return alimento
	 */
	public Feed getFeed() {
		return feed;
	}
	
	/**
	 * Método para retorno da quantidade
	 * @return quantidade
	 */
	public double getQuantity() {
		return quantity;
	}
	
	/**
	 * Método para retorno da caloria
	 * @return quantidade
	 */
	public double getCal() {
		return cal;
	}
	
	/**
	 * Método para retorno do tipo
	 * @return tipo
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Método para retorno da data de refeição
	 * @return data
	 */
	public LocalDate getDate() {
		return date;
	}

	@Override
	public UserFeed Get(int id) {
		System.out.println(String.format("Retornando a alimentacao do usuario %s da base com sucesso", this.feed.getName()));	
		return this;
	}

	@Override
	public void Add(UserFeed feed) {
		System.out.println(String.format("Alimentacao do usuario %s adicionada na base com sucesso", this.feed.getName()));	
	}

	@Override
	public void Update(UserFeed feed) {
		System.out.println(String.format("Alimentacao do usuario %s atualizada na base com sucesso", this.feed.getName()));
	}

	@Override
	public void Delete(UserFeed feed) {
		System.out.println(String.format("Alimentacao do usuario %s deletada da base com sucesso", this.feed.getName()));	
	}
}
