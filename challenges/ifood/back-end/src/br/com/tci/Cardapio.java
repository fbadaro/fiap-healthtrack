package br.com.tci;

import java.sql.Date;

public class Cardapio implements BaseRepository<Cardapio> {

	private int id;
	private String titulo;
	private char destaque;
	private Date criadoem;
	private Empresa empresa;

	public Cardapio() {

	}

	public Cardapio(int id, String titulo, char destaque, Date criadoem, Empresa empresa) {
		this.id = id;
		this.titulo = titulo;
		this.destaque = destaque;
		this.criadoem = criadoem;
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public char getDestaque() {
		return destaque;
	}

	public Date getCriadoem() {
		return criadoem;
	}

	public Empresa getEmpresaid() {
		return empresa;
	}

	@Override
	public Cardapio Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Cardapio type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Cardapio type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Cardapio type) {
		// TODO Auto-generated method stub

	}
	
}