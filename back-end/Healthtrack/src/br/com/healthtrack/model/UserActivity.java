package br.com.healthtrack.model;

import java.time.LocalDate;
//import java.time.LocalTime;

/** Classe que abstrai um usuário
 * @see Classe Person
 * @author Grupo Lovelace - XV
 * @version 1.0
 */
public class UserActivity implements BaseRepository<UserActivity> {
	
	/**
	 * Instância de usuário
	 */
	private User user;
	
	/**
	 * Instância de atividade
	 */
	private Activity activity;
	
	/**
	 * id único da classe
	 */
	private int id;
	
	/**
	 * Duração da atividade
	 */
	private LocalDate activityDuration;
	
	/**
	 * Data da atividade
	 */
	private LocalDate date;
	
	
	public UserActivity(User user, Activity activity, LocalDate activityDuration, LocalDate date) {
		
		this.id = ((int) (Math.random() * (100 - 50) + 50));
		this.user = user;
		this.activity = activity;
		this.activityDuration = activityDuration;
		this.date = date;
		
		ValidateUserActivity();
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateUserActivity() {
		if(this.user == null || this.activity == null || this.activityDuration == null || this.date == null) {
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
	 * Método para retorno da atividade
	 * @return atividade
	 */
	public Activity getActivity() {
		return activity;
	}
	
	/**
	 * Método para retorno da duração da atividade	
	 * @return duração
	 */
	public LocalDate getActivityDuration() {
		return activityDuration;
	}
	
	/** 
	 * Método para retorno da data de atividade
	 * @return data
	 */
	public LocalDate getDate() {
		return date;
	}

	@Override
	public UserActivity Get(int id) {
		System.out.println(String.format("Retornando a atividade do usuario %s da base com sucesso", this.activity.getName()));	
		return this;
	}

	@Override
	public void Add(UserActivity userActivity) {
		System.out.println(String.format("Atividade do usuario %s adicionada na base com sucesso", this.activity.getName()));	
	}

	@Override
	public void Update(UserActivity userActivity) {
		System.out.println(String.format("Atividade do usuario %s atualizada na base com sucesso", this.activity.getName()));
	}

	@Override
	public void Delete(UserActivity userActivity) {
		System.out.println(String.format("Atividade do usuario %s deletada da base com sucesso", this.activity.getName()));	
	}
}
