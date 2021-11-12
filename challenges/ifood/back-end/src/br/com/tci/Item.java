package br.com.tci;

import java.awt.image.BufferedImage;
import java.sql.Date;

public class Item implements BaseRepository<Item> {
	
	private int id;
	private String nome;
	private String descricao;
	private Double preco;
	private Date criadoem;
	private BufferedImage foto;
	private Cardapio cardapio;

	public Item(int id, String nome, String descricao, Double preco, Date criadoem, Cardapio cardapio) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.criadoem = criadoem;
		this.cardapio = cardapio;
	}

	public Item(String nome, String descricao, Double preco, Date criadoem, Cardapio cardapio) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.criadoem = criadoem;
		this.cardapio = cardapio;
	}

	public Item() {
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public Date getCriadoem() {
		return criadoem;
	}

	public BufferedImage getFoto() {
		return foto;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	@Override
	public Item Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Item type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Item type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Item type) {
		// TODO Auto-generated method stub

	}

}