package br.com.tci;

import java.awt.image.BufferedImage;
import java.sql.Date;
import java.time.LocalDate;

public class Empresa implements BaseRepository<Empresa> {
	
	private int id;
	private String nome;
	private String descricao;
	private LocalDate criadoem;
	private Double pedidomin;
	private BufferedImage logo;
	private String info;
	private Plano plano;
	private String cnpj;
	private String razaosocial;
	private String telefone;
	private char possuientrega;
	private Responsavel responsavel;

	public Empresa() {
	}

	public Empresa(String nome, String descricao, LocalDate criadoem, Double pedidomin, Plano plano, String cnpj, 
			String razaosocial, String telefone, char possuientrega, Responsavel responsavel) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.criadoem = criadoem;
		this.pedidomin = pedidomin;
		this.plano = plano;
		this.cnpj = cnpj;
		this.razaosocial = razaosocial;
		this.telefone = telefone;
		this.possuientrega = possuientrega;
		this.responsavel = responsavel;
	}

	public Empresa(int id, String nome, String descricao, LocalDate criadoem, Double pedidomin, Plano plano, String cnpj,
			String razaosocial, String telefone, char possuientrega, Responsavel responsavel) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.criadoem = criadoem;
		this.pedidomin = pedidomin;
		this.plano = plano;
		this.cnpj = cnpj;
		this.razaosocial = razaosocial;
		this.telefone = telefone;
		this.possuientrega = possuientrega;
		this.responsavel = responsavel;
	}

	public Empresa(int id, String nome, String descricao, LocalDate criadoem, Double pedidomin, BufferedImage logo,
			String info, Plano plano, String cnpj, String razaosocial, String telefone, char possuientrega,
			Responsavel responsavel) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.criadoem = criadoem;
		this.pedidomin = pedidomin;
		this.logo = logo;
		this.info = info;
		this.plano = plano;
		this.cnpj = cnpj;
		this.razaosocial = razaosocial;
		this.telefone = telefone;
		this.possuientrega = possuientrega;
		this.responsavel = responsavel;
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

	public LocalDate getCriadoem() {
		return criadoem;
	}

	public Double getPedidomin() {
		return pedidomin;
	}

	public BufferedImage getLogo() {
		return logo;
	}

	public String getInfo() {
		return info;
	}

	public Plano getPlano() {
		return plano;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public char getPossuientrega() {
		return possuientrega;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	@Override
	public Empresa Get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Add(Empresa type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Empresa type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Delete(Empresa type) {
		// TODO Auto-generated method stub

	}

}
