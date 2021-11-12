package br.com.tci;

public class Plano implements BaseRepository<Plano> {
	private int id;
	private String nome;
	private Double preco;

	public Plano() {
	}
	
	public Plano(String nome, Double preco) {		
		this.nome = nome;
		this.preco = preco;
	}

	public Plano(int id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public Plano Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Plano type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Plano type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Plano type) {
		// TODO Auto-generated method stub

	}

}
