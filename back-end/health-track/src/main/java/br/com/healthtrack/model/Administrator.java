package br.com.healthtrack.model;

import br.com.healthtrack.utils.CryptographyUtils;

/** Classe que abstrai um administrador
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 * @version 1.0
 */
public final class Administrator extends Person {
	
	/**
	 * Administrador ativo
	 */
	private boolean active;
	
	public Administrator(String name, String email, String login, String pass) {
		
		this.id = (int) (Math.random() * (100 - 50) + 50);
		this.name = name;
		this.email = email;
		this.login = login;
		setPass(pass);;
		
		ValidateAdministrator();
		
		System.out.println("Administrador criado com sucesso!");	
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateAdministrator() {		
		if(this.name == "" || this.email == "" || this.login == "" || this.pass == "") {
			throw new IllegalArgumentException("Os campos nao podem estar vazios");
		}						
	}
	
	@Override
	protected void Login(String login, String pass) {
		System.out.println("Usuario logado com sucesso!");		
	}

	@Override
	protected void Logout() {
		System.out.println("Usuario deslogado com sucesso!");		
	}
	
	/**
	 * Método para retorno do nome
	 * @return nome
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método para retorno do email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método para retorno do login
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Método para retorno do password
	 * @return password
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * Método para retorno do status do administrador
	 * @return
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Método para alterar status do administrador
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Método para ativar usuário
	 * @param user é o usuário que será ativado
	 */
	public void ActiveUser(User user) {
		System.out.println(String.format("%s ativado com sucesso", user.name));
	}
	
	/**
	 * Método para desativar usuário
	 * @param user é o usuário que será desativado
	 */
	public void InactiveUser(User user) {
		System.out.println(String.format("%s desativado com sucesso", user.name));
	}
	
	
	public void setPass(String pass) {
		try {
			this.pass = CryptographyUtils.cryptography(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Person Get(int id) {	
		System.out.println(String.format("Retornando o Administrador %s da base com sucesso", this.name));
		return this;
	}

	@Override
	public void Add(Person user) {
		System.out.println(String.format("Administrador %s adicionado na base com sucesso", user.name));	
	}

	@Override
	public void Update(Person user) {
		System.out.println(String.format("Administrador %s atualizado na base com sucesso", user.name));
	}

	@Override
	public void Delete(Person user) {
		System.out.println(String.format("Administrador %s deletado da base com sucesso", user.name));	
	}
}
