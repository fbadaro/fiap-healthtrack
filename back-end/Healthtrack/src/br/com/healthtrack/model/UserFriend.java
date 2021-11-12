package br.com.healthtrack.model;

/**
 * Classe que abstrai amigos
 * @author Grupo Lovelace - XV
 * @version 1.0
 */
public final class UserFriend {
	
	/**
	 * Instância de usuário
	 */
	private User user;
	
	/**
	 * Amigo
	 */
	private Friend friend;	
	
	public UserFriend(User user, Friend friend) {
		this.user = user;
		this.friend = friend;
		
		ValidateUserFriend();
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateUserFriend() {
		if(this.user == null || this.friend == null) {
			throw new IllegalArgumentException("Os campos nao podem estar vazios");
		}		
	}
	
	public void Follow(Friend friend) {		
		user.setUserFriend(this);
		friend.setUserFriend(this);
		
		System.out.println(String.format("Seguindo o usuario %s", friend.getUser().name));
	}
	
	/**
	 * Método para deixar de seguir outro usuário
	 * @param friend é o usuário amigo
	 */
	public void Unfollow(Friend friend) {		
		System.out.println(String.format("Deixando de seguir o usuario %s", friend.getUser().name));
	}
	
	/**
	 * Método para retorno do usuário
	 * @return usuário é o usuário
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Método para alterar usuário
	 * @return user é o usuário
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Método para retorno do usuário amigo
	 * @return friend é o usuário amigo
	 */
	public Friend getFriend() {
		return friend;
	}
	
	/**
	 * Método para alterar usuário amigo
	 * @return friend é o usuário amigo
	 */
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	/**
	 * Método para retorno do total de usuários amigos
	 * @return friend
	 */
	public int getUserFriendCount() {			
		return user.getUserFriend().size();
	}

}
