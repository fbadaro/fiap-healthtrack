package br.com.tci;

public class Endereco implements BaseRepository<Endereco> {

	private int id;
	private String logradouro;
	private int numero;
	private String cidade;
	private String uf;
	private String cep;
	private String pais;
	private Empresa empresaid;

	public Endereco() {
	}

	public Endereco(int id, String logradouro, int numero, String cidade, String uf, String cep, String pais,
			Empresa empresaid) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.pais = pais;
		this.empresaid = empresaid;
	}
	
	@Override
	public Endereco Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Endereco type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Endereco type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Endereco type) {
		// TODO Auto-generated method stub

	}

}
