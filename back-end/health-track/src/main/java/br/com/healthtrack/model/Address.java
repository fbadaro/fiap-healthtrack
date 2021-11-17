package br.com.healthtrack.model;

import java.util.ArrayList;
import java.util.List;

/** Classe que abstrai endereços
 * @author Grupo Lovelace - XV
 * @implNote Implementa a Interface BaseRepository
 */
public class Address implements BaseRepository<Address> {
	
	/**
	 * Instância de Usuário
	 */
	private User user;
	
	/**
	 * Número de id único
	 */
	private int id;
	
	/**
	 * Nome da rua
	 */
	private String street;
	
	/**
	 * Cidade
	 */
	private String city;
	
	/**
	 * Número da casa
	 */
	private int number;
	
	/**
	 * Nome da Cidade
	 */
	private String country;
	
	/**
	 * Nome do Estado
	 */
	private String state;
	
	/**
	 * Código Postal
	 */
	private String zipCode;
	
	/**
	 * Indica se o endereço é o principal do usuário
	 */
	private boolean principal;
	
	/**
	 * Lista de endereços do usuário
	 */
	private List<Address> addresses = new ArrayList<Address>();
	
	public Address(int id, User user, String street, String city, int number, String country, String state, String zipCode, boolean principal) {
		
		this.id = id;
		this.user = user;
		this.street = street;
		this.city = city;
		this.number = number;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.principal = principal;
		
		ValidateAddress();
	}

	public Address(User user, String street, String city, int number, String country, String state, String zipCode, boolean principal) {
		
		this.id = (int) (Math.random() * (100 - 50) + 50);
		this.user = user;
		this.street = street;
		this.city = city;
		this.number = number;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.principal = principal;
		
		ValidateAddress();
	}
	
	/** Método para garantir que a instâcia seja criada corretamente
	 */
	private void ValidateAddress() {		
		if(this.street == "" || this.zipCode == "" || this.state == "" || this.number == 0) {
			throw new IllegalArgumentException("Os campos nao podem estar vazios");
		}						
	}
	
	/** Método para retorno da rua
	 * @return rua
	 */
	public String getStreet() {
		return street;
	}
	
	/** Método para alterar nome da rua
	 * @param street é o novo nome da rua
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/** Método para retorno da cidade
	 * @return cidade
	 */
	public String getCity() {
		return city;
	}
	
	/** Método para alterar nome da cidade
	 * @param street é o novo nome da cidade
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/** Método para retorno do número
	 * @return número da casa
	 */
	public int getNumber() {
		return number;
	}
	
	/**Método para alterar número da casa
	 * @param number é o número novo da casa
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/** Método para retorno da cidade
	 * @return cidade
	 */
	public String getCountry() {
		return country;
	}
	
	/** Método para retorno do Estado
	 * @return Estado
	 */
	public String getState() {
		return state;
	}
	
	/** Método para retorno do Cep
	 * @return Cep
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Método para retorno do endereço principal
	 * @return Somente se o endereço for o principal
	 */
	public Boolean getPrincipal() {
		return principal;
	}
	
	/**
	 * Método para retorno do Usuário dono do endereço
	 * @return Usuário
	 */
	public User getUser() {
		return user;
	}	
	
	/**
	 * Método para retorna lista de endereços do usuário
	 */
	public List<Address> ListAll() {
		return addresses;
	}
	
	/**
	 * Método para alterar lista de endereços
	 * @param addresses é a instância do endereço
	 */
	public void setAddresses(Address addresses) {
		this.addresses.add(addresses);
	}

	@Override
	public Address Get(int id) {
		System.out.println(String.format("Retornando o endereco %s da base com sucesso", this.id));	
		return this;
	}

	@Override
	public void Add(Address address) {
		System.out.println(String.format("Endereco %s adicionado na base com sucesso", address.id));	
	}

	@Override
	public void Update(Address address) {
		System.out.println(String.format("Endereco %s atualizado na base com sucesso", address.id));
	}

	@Override
	public void Delete(Address address) {
		System.out.println(String.format("Endereco %s deletado da base com sucesso", address.id));	
	}

}
