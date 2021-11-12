package br.com.healthtrack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que abstrai Atividades Fisicas
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 * @version 1.0
 */
public class Activity implements BaseRepository<Activity>  {
	
	/**
	 * Número do id único
	 */
	private int id;
	
	/**
	 * Nome da Atividade
	 */
	private String name;
	
	/**
	 * Lista com todas Atividades
	 */
	private List<Activity> activities = new ArrayList<Activity>();
	
	/**
	 * Construtor da classe com parâmetros
	 * @param name da Atividade
	 */
	public Activity(int id, String name) {
		
		this.id = id;
		this.name = name;
		
		ValidateActivity();
	}

	/**
	 * Construtor da classe com parâmetros
	 * @param name da Atividade
	 */
	public Activity(String name) {
		
		this.id = ((int) (Math.random() * (100 - 50) + 50));
		this.name = name;
		
		ValidateActivity();
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateActivity() {
		if(this.name == "") {
			throw new IllegalArgumentException("Os campos nao podem estar vazios");
		}
	}
	
	/**
	 * Método para retorno do id da atividade
	 * @return id da instância
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para retorno do nome da atividade
	 * @return nome da atividade
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método para retorno da lista de atividades
	 * @return lista de atividades
	 */
	public List<Activity> ListAll() {
		return activities;
	}
	
	/**
	 * Método para adcionar Atividade a lista
	 * @param activities
	 */
	public void setActivities(Activity activities) {
		this.activities.add(activities);
	}
	
	@Override
	public Activity Get(int id) {
		System.out.println(String.format("Retornando a atividade %s da base com sucesso", this.name));	
		return this;
	}

	@Override
	public void Add(Activity activity) {
		System.out.println(String.format("Atividade %s adicionada na base com sucesso", activity.name));	
	}

	@Override
	public void Update(Activity activity) {
		System.out.println(String.format("Atividade %s atualizada na base com sucesso", activity.name));
	}

	@Override
	public void Delete(Activity activity) {
		System.out.println(String.format("Atividade %s deletada da base com sucesso", activity.name));	
	}
	
}
