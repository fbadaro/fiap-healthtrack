package br.com.healthtrack.model;

import java.time.LocalDate;

/**
 * Classe que abstrai medição de peso
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 * @version 1.0
 */
public class UserWeight implements BaseRepository<UserWeight> {
	
	/**
	 * Instância de usuário
	 */
	private User user;	
	
	/**
	 * id único da classe
	 */
	private int id;
	
	/**
	 * altura
	 */
	private double height;
	
	/**
	 * Peso
	 */
	private double weight;
	
	/**
	 * Data da pesagem
	 */
	private LocalDate date;
	
	
	public UserWeight() {
		
	}
	
	public UserWeight(int id, User user, double height, double weight, LocalDate date) {
		
		this.id = id;
		this.user = user;
		this.height = height;
		this.weight = weight;
		this.date = date;
		
		ValidateUserIMC();
	}
	
	public UserWeight(User user, double height, double weight, LocalDate date) {
		
		this.id = ((int) (Math.random() * (100 - 50) + 50));
		this.user = user;
		this.height = height;
		this.weight = weight;
		this.date = date;
		
		ValidateUserIMC();
	}

	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateUserIMC() {
		if(this.user == null || this.height == 0 || this.weight == 0) {
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
	 * Método para retorno da altura
	 * @return altura
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Método para alterar altura
	 * @param height é a altura 
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Método para retorno do peso
	 * @return peso
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Método para alterar peso
	 * @param weight é o peso
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Método para retorno da data
	 * @return data
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Método para alterar data
	 * @param date é a data
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public UserWeight Get(int id) {
		System.out.println(String.format("Retornando o IMC do usuario %s da base com sucesso", this.id));	
		return this;
	}

	@Override
	public void Add(UserWeight imc) {
		System.out.println(String.format("IMC do usuario %s adicionado na base com sucesso", this.id));	
	}

	@Override
	public void Update(UserWeight imc) {
		System.out.println(String.format("IMC do usuario %s atualizado na base com sucesso", this.id));
	}

	@Override
	public void Delete(UserWeight imc) {
		System.out.println(String.format("IMC do usuario %s deletado da base com sucesso", this.id));	
	}
}
