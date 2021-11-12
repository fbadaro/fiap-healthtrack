package br.com.healthtrack.model;

import java.awt.image.BufferedImage;

/** Classe que abstrai uma pessoa
 * Classe abstrata que não gera instâncias
 * @author Grupo Lovelace - XV
 * @version 1.0
 */
public abstract class Person implements BaseRepository<Person> {
	
	/**
	 * id único
	 */
	protected int id;
	
	/**
	 * Nome da pessoa
	 */
	protected String name;
	
	/**
	 * Email da pessoa
	 */
	protected String email;
	
	/**
	 * Login da pessoa
	 */
	protected String login;
	
	/**
	 * Senha da pessoa
	 */
	protected String pass;
	
	/**
	 * Foto da pessoa
	 */
	protected BufferedImage photo;
	
	/**
	 * Método para realizar login no aplicativo
	 * @param login da pessoa
	 * @param pass é a senha da pessoa
	 */
	protected abstract void Login(String login, String pass);
	
	/**
	 * Método para deslogar do aplicativo
	 */
	protected abstract void Logout();
}
