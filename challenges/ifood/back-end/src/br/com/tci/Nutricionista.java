package br.com.tci;

public class Nutricionista implements BaseRepository<Nutricionista> {
	private int id;
	private String email;
	private String crn;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String uf;
	private char termos;

	public Nutricionista() {
	}

	public Nutricionista(int id) {
		this.id = id;
	}

	public Nutricionista(int id, String email, String crn, String nome, String sobrenome, String cpf, String rg, String uf, char termos) {
		this.id = id;
		this.email = email;
		this.crn = crn;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.termos = termos;
	}
	
	public Nutricionista(String email, String crn, String nome, String sobrenome, String cpf, String rg, String uf, char termos) {		
		this.email = email;
		this.crn = crn;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public char getTermos() {
		return termos;
	}

	public void setTermos(char termos) {
		this.termos = termos;
	}

	@Override
	public Nutricionista Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Nutricionista type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Nutricionista type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Nutricionista type) {
		// TODO Auto-generated method stub

	}
}
