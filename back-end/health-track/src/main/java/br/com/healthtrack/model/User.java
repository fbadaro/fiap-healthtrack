	package br.com.healthtrack.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.healthtrack.utils.CryptographyUtils;

/** Classe que abstrai um usuário
 * @see Classe Person
 * @author Grupo Lovelace - XV
 * @version 1.0
 */
public final class User extends Person{
	
	/**
	 * Data de nascimento do usuário
	 */
	private LocalDate birthday;
	
	/**
	 * Altura do usuário
	 */
	private double height;
	
	/**
	 * Peso do usuário
	 */
	private double weight;
	
	/**
	 * Lista de amigos do usuário
	 */
	private List<UserFriend> userFriend = new ArrayList<UserFriend>();
	
	/**
	 * Lista de endereços do usuário
	 */
	private List<Address> userAddress = new ArrayList<Address>();
	
	/**
	 * Lista de atividades do usuário
	 */
	private List<UserActivity> userActivity = new ArrayList<UserActivity>();
	
	/**
	 * Lista de alimentos ingeridos pelo usuário
	 */
	private List<UserFeed> userFeed = new ArrayList<UserFeed>();
	
	/**
	 * Lista de medição de peso do usuário
	 */
	private List<UserWeight> userWeight = new ArrayList<UserWeight>();
	
	/**
	 * Lista de pressão arterial do usuário
	 */
	private List<UserBloodPressure> userBloodPressure = new ArrayList<UserBloodPressure>();
	
	public User(int id, String name, String email, String login, String pass) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		
		ValidateUser();			
	}
	
	public User(int id, String name, String email, String login, String pass, Double height, Double weight, LocalDate birthday) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.pass = pass;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;			
		
		ValidateUser();			
	}

	public User(String name, String email, String login, String pass, Double height, Double weight, LocalDate birthday) {
		
		this.name = name;
		this.email = email;
		this.login = login;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		
		setPass(pass);
		
		ValidateUser();
		
		System.out.println("Usuario criado com sucesso!");	
	}
	
	public User(String name, String email, String login, String pass) {
		
		this.name = name;
		this.email = email;
		this.login = login;
		
		setPass(pass);;
		
		ValidateUser();
		
		System.out.println("Usuario criado com sucesso!");	
	}
	
	/**
	 * Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateUser() {		
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
	 * Método para retorno do id da atividade
	 * @return id da instância
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Método para setar/alterar do id da atividade
	 * @return id da instância
	 */
	public void setId(int id) {
		this.id= id ;
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
	 * Método para retorno da data de nascimento
	 * @return data de nascimento
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * Método para alterar data de nascimento
	 * @param birthday é a data que ira alterar
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
	 * @param height é a altura a ira alterar
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Método para retorno da altura 
	 * @return altura
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Método para alterar altura
	 * @param height é a altura a ira alterar
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Método para retorno da lista de usuários amigos
	 * @return lista de amigos
	 */
	public List<UserFriend> getUserFriend() {
		return userFriend;
	}
	
	/**
	 * Método para adicionar lista de amigos
	 * @param userFriend amigo a ser adicionado
	 */
	public void setUserFriend(UserFriend userFriend) {
		this.userFriend.add(userFriend);
	}
	
	/**
	 * Método para retorno da lista de endereços
	 * @return lista de endereços
	 */
	public List<Address> getUserAddress() {
		return userAddress;
	}
	
	/**
	 * Método para adicionar lista de endereços
	 * @param userAddress endereço a ser adicionado
	 */
	public void setUserAddress(Address userAddress) {
		this.userAddress.add(userAddress);
	}
	
	/**
	 * Método para alterar lista de endereços
	 * @param userAddress nova lista de endereços
	 */
	public void setUserAddress(List<Address> userAddress) {
		this.userAddress = userAddress;
	}
	
	/**
	 * Método para retorno da lista de atividades
	 * @return lista de atividades
	 */
	public List<UserActivity> getUserActivity() {
		return userActivity;
	}
	
	/**
	 * Método para adicionar atividade
	 * @param userActivity atividade que será adicionada
	 */
	public void setUserActivity(UserActivity userActivity) {
		this.userActivity.add(userActivity);
	}
	
	/**
	 * Método para alterar lista de atividades
	 * @param userActivity nova lista de atividades
	 */
	public void setUserActivity(List<UserActivity> userActivity) {
		this.userActivity = userActivity;
	}
	
	/**
	 * Método para retorno da lista de alimentos
	 * @return lista de alimentos
	 */
	public List<UserFeed> getUserFeed() {
		return userFeed;
	}
	
	/**
	 * Método para adicionar alimento
	 * @param userFeed alimento que será adicionado
	 */
	public void setUserFeed(UserFeed userFeed) {
		this.userFeed.add(userFeed);
	}
	
	/**
	 * Método para alterar lista de alimentos
	 * @param userFeed nova lista de alimentos
	 */
	public void setUserFeed(List<UserFeed> userFeed) {
		this.userFeed = userFeed;
	}
	
	/**
	 * Método para retorno da lista de pesos
	 * @return lista de pesos
	 */
	public List<UserWeight> getUserWeight() {
		return userWeight;
	}
	
	/**
	 * Método para adicionar peso
	 * @param userWeight peso que será adicionada
	 */
	public void setUserWeight(UserWeight userWeight) {
		this.userWeight.add(userWeight);
	}
	
	/**
	 * Método para alterar lista de pesos
	 * @param userWeight nova lista de pesos
	 */
	public void setUserWeight(List<UserWeight> userWeight) {
		this.userWeight = userWeight;
	}
	
	/**
	 * Método para retorno da lista de pressão
	 * @return lista de pressão
	 */
	public List<UserBloodPressure> getUserBloodPressure() {
		return userBloodPressure;
	}
	
	/**
	 * Método para adicionar pressão
	 * @param userBloodPressure pressão que será adicionada
	 */
	public void setUserBloodPressure(UserBloodPressure userBloodPressure) {
		this.userBloodPressure.add(userBloodPressure);
	}
	
	/**
	 * Método para alterar lista de pressão
	 * @param userBloodPressure nova lista de pressão
	 */
	public void setUserBloodPressure(List<UserBloodPressure> userBloodPressure) {
		this.userBloodPressure = userBloodPressure;
	}
	
	/**
	 * Método para retorno do password
	 * @return password
	 */
	public String getPass() {
		return pass;
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
		System.out.println(String.format("Retornando o Usuario %s da base com sucesso", this.name));	
		return this;
	}

	@Override
	public void Add(Person user) {
		System.out.println(String.format("Usuario %s adicionado na base com sucesso", user.name));	
	}

	@Override
	public void Update(Person user) {
		System.out.println(String.format("Usuario %s atualizado na base com sucesso", user.name));
	}

	@Override
	public void Delete(Person user) {
		System.out.println(String.format("Usuario %s deletado da base com sucesso", user.name));	
	}
	
}
