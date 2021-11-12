package br.com.tci;

public class Categoria implements BaseRepository<Categoria> {

	private int id;
	private String nome;

	public Categoria() {

	}

	public Categoria(int id, String nome) {

		this.id = id;
		this.nome = nome;
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public Categoria Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Categoria type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Categoria type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Categoria type) {
		// TODO Auto-generated method stub

	}
	
}