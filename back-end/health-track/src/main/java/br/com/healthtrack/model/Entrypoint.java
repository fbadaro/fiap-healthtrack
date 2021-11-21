package br.com.healthtrack.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrypoint {

	public static void main(String[] args) {
		
		// User
		System.out.println("****************** METODOS USER ******************");
		
		// Criando um novo usuario na aplicacao
		var user = new User("Fabio Badaro", "email@email.com", "fbadaro", "123456");
		
		// Adicionando o usuario na base
		user.Add(user);
		
		// Retornando o usuario corrent da base
		user.Get(user.id);
		
		// Atualizado o usuario na base
		user.Update(user);
		
		// Deletando o usuario na base
		user.Delete(user);
		
		
		// Administrator
		System.out.println("****************** METODOS ADMINISTRATOR ******************");
				
		// Criando um novo administrador na aplicacao
		var administrator = new Administrator("Camila da Silva", "email@email.com", "csilva", "456789");
		
		// Adminstrador inativando um usuario
		administrator.InactiveUser(user);
		
		// Adminstrador ativando um usuario
		administrator.ActiveUser(user);
		
		
		// Friend
		System.out.println("****************** METODOS FRIENDS ******************");
		
		var friend1 = new Friend(new User("Friend 1", "email@email.com", "friend1", "123456"));
		var friend2 = new Friend(new User("Friend 2", "email@email.com", "friend2", "123456"));
		
		// Adicionando Amigos
		var userFriend1 = new UserFriend(user, friend1);
		userFriend1.Follow(friend1);
		
		var userFriend2 = new UserFriend(user, friend2);
		userFriend2.Follow(friend2);		
		
		System.out.println(String.format("Numero de usuarios que sigo %s", userFriend1.getUserFriendCount()));
		
		
		// Address
		System.out.println("****************** METODOS ADDRESS ******************");
		
		// Adicionando Enderecos
		var address1 = new Address(user, "Street 1", "Cidade 1", 103, "Country 1", "State 1", "ZipCode 1", false);
		var address2 = new Address(user, "Street 2", "CIdade 2", 103, "Country 2", "State 2", "ZipCode 1", true);
		
		user.setUserAddress(address1);
		user.setUserAddress(address2);
		
		// Listando Enderecos do usuario
		user.getUserAddress().forEach(item -> System.out.println(item.getStreet() + " - " + item.getNumber()));
		
		
		// Activity
		System.out.println("****************** METODOS ACTIVITY ******************");		
		
		// Adicionando Atividades na Plataforma pelo administrador
		var activity1 = new Activity("Corrida");
		activity1.Add(activity1);
		
		var activity2 = new Activity("Bicicleta");
		activity2.Add(activity2);
		
		var activity3 = new Activity("Natacao");
		activity3.Add(activity3);
		
		var activity4 = new Activity("Jiu-Jitsu");
		activity4.Add(activity4);
		
		var activity5 = new Activity("Academia");
		activity5.Add(activity5);
		
		
		// User Activity
		System.out.println("****************** METODOS USER ACTIVITY ******************");
		
		var userActivity1 = new UserActivity(user, activity1, 44, LocalDate.now());
		user.setUserActivity(userActivity1);
		
		var userActivity2 = new UserActivity(user, activity2, 50, LocalDate.now());
		user.setUserActivity(userActivity2);
		
		var userActivity3 = new UserActivity(user, activity3, 60, LocalDate.now());
		user.setUserActivity(userActivity3);
		
		// Listando Atividades do Usuario
		user.getUserActivity().forEach(item -> System.out.println(item.getActivity().getName()));
		
		
		// User Activity
		System.out.println("****************** METODOS FEED ******************");
		
		// Adicionando Alimentacoes na Plataforma pelo administrador
		var feed1 = new Feed("Arroz");
		feed1.Add(feed1);
		
		var feed2 = new Feed("Feijao");
		feed2.Add(feed2);
		
		var feed3 = new Feed("Macarrao");
		feed3.Add(feed3);
		
		var feed4 = new Feed("Feijoada");
		feed4.Add(feed4);
		
		
		// User Feed
		System.out.println("****************** METODOS USER FEED ******************");
		
		var userFeed1 = new UserFeed(user, feed1, 10.5, 1, LocalDate.now(), 1.0);
		user.setUserFeed(userFeed1);	
		
		var userFeed2 = new UserFeed(user, feed2, 85.5, 1, LocalDate.now(), 1.0);
		user.setUserFeed(userFeed2);	
		
		var userFeed3 = new UserFeed(user, feed3, 45.5, 2, LocalDate.now(), 1.0);
		user.setUserFeed(userFeed3);	
		
		var userFeed4 = new UserFeed(user, feed4, 35.5, 2, LocalDate.now(), 1.0);
		user.setUserFeed(userFeed4);	
		
		// Listando Alimentacao do Usuario
		user.getUserFeed().forEach(item -> System.out.println(item.getFeed().getName()));
		
	}

}