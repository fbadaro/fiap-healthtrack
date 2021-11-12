package br.com.tci;

public class Responsavel implements BaseRepository<Responsavel> {
	private int id;
	private String email;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String uf;
	private char termos;

	public Responsavel() {
	}

	public Responsavel(int id) {
		this.id = id;
	}
	
	public Responsavel(String email, String nome, String sobrenome, String cpf, String rg, String uf, char termos) {		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.termos = termos;
	}

	public Responsavel(int id, String email, String nome, String sobrenome, String cpf, String rg, String uf, char termos) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.termos = termos;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getUf() {
		return uf;
	}

	public char getTermos() {
		return termos;
	}

	@Override
	public Responsavel Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Responsavel type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Responsavel type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Responsavel type) {
		// TODO Auto-generated method stub

	}

}
