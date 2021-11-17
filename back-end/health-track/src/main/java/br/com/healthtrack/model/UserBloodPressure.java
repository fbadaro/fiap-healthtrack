package br.com.healthtrack.model;

import java.time.LocalDate;

/**
 * Classe que abstrai medição de pressão
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 * @version 1.0
 */
public class UserBloodPressure implements BaseRepository<UserBloodPressure> {
	
	/**
	 * Instância de usuário
	 */
	private User user;
	
	/**
	 * id único da classe
	 */
	private int id;
	
	/**
	 * Pressão sistolica
	 */
	private int systolicPressure;
	
	/**
	 * Pressão diastólica
	 */
	private int diastolicPressure;
	
	/**
	 * Data da medição da pressão
	 */
	private LocalDate date;
	
	public UserBloodPressure(int id, User user, int systolicPressure, int diastolicPressure, LocalDate date) {
		
		this.id = id;
		this.user = user;
		this.systolicPressure = systolicPressure;
		this.diastolicPressure = diastolicPressure;
		this.date = date;
		
		ValidateBloodPressure();
	}
	
	public UserBloodPressure(User user, int systolicPressure, int diastolicPressure, LocalDate date) {
		
		this.id = ((int) (Math.random() * (100 - 50) + 50));
		this.user = user;
		this.systolicPressure = systolicPressure;
		this.diastolicPressure = diastolicPressure;
		this.date = date;
		
		ValidateBloodPressure();
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateBloodPressure() {
		if(this.user == null || this.systolicPressure == 0 || this.diastolicPressure == 0) {
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
	 * Método para retorno da pressão sistolica
	 * @return pressão sistolica
	 */
	public int getSystolicPressure() {
		return systolicPressure;
	}
	
	/**
	 * Método para retorno da pressão diastólica
	 * @return pressão diastólica
	 */
	public int getDiastolicPressure() {
		return diastolicPressure;
	}
	
	/**
	 * Método para retorno da data de medição
	 * @return data
	 */
	public LocalDate getDate() {
		return date;
	}

	@Override
	public UserBloodPressure Get(int id) {
		System.out.println(String.format("Retornando a pressão do usuario %s da base com sucesso", this.id));	
		return this;
	}

	@Override
	public void Add(UserBloodPressure userBloodPressure) {
		System.out.println(String.format("Pressão do usuario %s adicionado na base com sucesso", this.id));	
	}

	@Override
	public void Update(UserBloodPressure userBloodPressure) {
		System.out.println(String.format("Pressão do usuario %s atualizado na base com sucesso", this.id));
	}

	@Override
	public void Delete(UserBloodPressure userBloodPressure) {
		System.out.println(String.format("Pressão do usuario %s deletado da base com sucesso", this.id));	
	}

}
