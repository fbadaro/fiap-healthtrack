package br.com.tci;

public class Atendimento implements BaseRepository<Atendimento> {

	private int id;
	private String segunda;
	private String terca;
	private String quarta;
	private String quinta;
	private String sexta;
	private String sabado;
	private String domingo;
	private String feriado;
	private Empresa empresaid;

	public Atendimento() {

	}

	public Atendimento(String segunda, String terca, String quarta, String quinta, String sexta, String sabado,
			String domingo, String feriado, Empresa empresaid) {
		super();
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.domingo = domingo;
		this.feriado = feriado;
		this.empresaid = empresaid;
	}

	public Atendimento(int id, String segunda, String terca, String quarta, String quinta, String sexta, String sabado,
			String domingo, String feriado, Empresa empresaid) {
		this.id = id;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.domingo = domingo;
		this.feriado = feriado;
		this.empresaid = empresaid;
	}

	public int getId() {
		return id;
	}

	public String getSegunda() {
		return segunda;
	}

	public String getTerca() {
		return terca;
	}

	public String getQuarta() {
		return quarta;
	}

	public String getQuinta() {
		return quinta;
	}

	public String getSexta() {
		return sexta;
	}

	public String getSabado() {
		return sabado;
	}

	public String getDomingo() {
		return domingo;
	}

	public String getFeriado() {
		return feriado;
	}

	public Empresa getEmpresaid() {
		return empresaid;
	}

	@Override
	public Atendimento Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Atendimento type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Atendimento type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Atendimento type) {
		// TODO Auto-generated method stub

	}
	
}
