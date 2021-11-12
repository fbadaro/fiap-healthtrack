package br.com.healthtrack.model;

import java.util.ArrayList;
import java.util.List;

/** Classe que abstrai Amigos
 * @author Grupo Lovelace - XV
 * @version 1.0
 */
public final class Friend {
	
	/**
	 * Instância de usuário
	 */
	private User user;
	
	/**
	 * Lista de usuários amigos
	 */
	private List<UserFriend> userFriend = new ArrayList<UserFriend>();	
	
	public Friend(User user) {
		this.user = user;
	}
	
	/**
	 * Método para retorno de um amigo da lista
	 * @return usuário amigo
	 */
	public List<UserFriend> getUserFriend() {
		return userFriend;
	}
	
	/**
	 * Método para adcionar usuário a lista de amigos
	 * @param userFriend é o usuário a ser adcionado
	 */
	public void setUserFriend(UserFriend userFriend) {
		this.userFriend.add(userFriend);
	}
	
	/**
	 * Método para retorno do usuário
	 * @return usuário
	 * @see Classe User
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Método para alterar usuário
	 * @param user a ser alterado
	 * @see Classe User
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
