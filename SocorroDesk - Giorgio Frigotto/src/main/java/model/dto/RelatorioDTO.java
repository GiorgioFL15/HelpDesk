package model.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelatorioDTO {
	
	DateTimeFormatter formaterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataAbertura;
    private LocalDate dataFechamento;
	private String descricao;
	private String titulo;
	private String solucao;
	private int totalChamados;
	


	
	
	
	public RelatorioDTO(DateTimeFormatter formaterDate, int idUsuario, String nome, String cpf, String email,
			LocalDate dataAbertura, LocalDate dataFechamento, String descricao, String titulo, String solucao,
			int totalChamados) {
		super();
		this.formaterDate = formaterDate;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.descricao = descricao;
		this.titulo = titulo;
		this.solucao = solucao;
		this.totalChamados = totalChamados;
	}

	
	
	public RelatorioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	public DateTimeFormatter getFormaterDate() {
		return formaterDate;
	}



	public void setFormaterDate(DateTimeFormatter formaterDate) {
		this.formaterDate = formaterDate;
	}



	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	public LocalDate getDataFechamento() {
		return dataFechamento;
	}



	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getSolucao() {
		return solucao;
	}



	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}



	public int getTotalChamados() {
		return totalChamados;
	}



	public void setTotalChamados(int totalChamados) {
		this.totalChamados = totalChamados;
	}



	public void imprimir() {
		String dataFechamentoFormatada = "-";
		
		if(this.getDataFechamento() != null) {
			dataFechamentoFormatada = this.getDataFechamento().format(formaterDate);
		}
		
		System.out.printf("\n%3s  %-13s  %-20s  %-11s  %-20s  %-15s  %-15s  %-10s  %-10s  ", 
				this.getIdUsuario(), this.getNome(), this.getCpf(), this.getEmail(), 
				this.getDataAbertura().format(formaterDate), 
				dataFechamentoFormatada, 
				this.getDescricao(), this.getTitulo(), 
				this.getSolucao() == null ? "-" : this.getSolucao());
	}
	
	public void imprimirContador() {
		
		System.out.printf("\n%3s  %-13s  %-20s  %-11s  %-10s  ", 
				this.getIdUsuario(), this.getNome(), this.getCpf(), this.getEmail(), this.getTotalChamados());
	}
}