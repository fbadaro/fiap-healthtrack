package br.com.tci;

public class EmpresaCategoria implements BaseRepository<EmpresaCategoria> {
	
	private Empresa empresaid;
	private Categoria categoriaid;
	private String nome;

	public EmpresaCategoria() {
	}

	public EmpresaCategoria(Empresa empresaid, Categoria categoriaid, String nome) {
		this.empresaid = empresaid;
		this.categoriaid = categoriaid;
		this.nome = nome;
	}

	@Override
	public EmpresaCategoria Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(EmpresaCategoria type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(EmpresaCategoria type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(EmpresaCategoria type) {
		// TODO Auto-generated method stub

	}

}
