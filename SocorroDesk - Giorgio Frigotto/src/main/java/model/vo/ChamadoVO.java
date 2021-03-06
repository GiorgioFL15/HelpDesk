
package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChamadoVO {
    private int idChamado;
    private int IDUSUARIO;
    private int IDTECNICO;
    private String descricao;
    private String titulo;
    private LocalDate DATAABERTURA;
    private LocalDate DATAFECHAMENTO;
    private String SOLUCAO;

	DateTimeFormatter formaterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ChamadoVO(int idChamado, int iDUSUARIO, int iDTECNICO, String descricao, String titulo, LocalDate dATAABERTURA,
    		LocalDate dATAFECHAMENTO, String sOLUCAO) {
		super();
		this.idChamado = idChamado;
		IDUSUARIO = iDUSUARIO;
		IDTECNICO = iDTECNICO;
		this.descricao = descricao;
		this.titulo = titulo;
		DATAABERTURA = dATAABERTURA;
		DATAFECHAMENTO = dATAFECHAMENTO;
		SOLUCAO = sOLUCAO;
	}



	public ChamadoVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdChamado() {
		return idChamado;
	}



	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}



	public int getIDUSUARIO() {
		return IDUSUARIO;
	}



	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}



	public int getIDTECNICO() {
		return IDTECNICO;
	}



	public void setIDTECNICO(int iDTECNICO) {
		IDTECNICO = iDTECNICO;
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



	public LocalDate getDATAABERTURA() {
		return DATAABERTURA;
	}



	public void setDATAABERTURA(LocalDate dATAABERTURA) {
		DATAABERTURA = dATAABERTURA;
	}



	public LocalDate getDATAFECHAMENTO() {
		return DATAFECHAMENTO;
	}



	public void setDATAFECHAMENTO(LocalDate dATAFECHAMENTO) {
		DATAFECHAMENTO = dATAFECHAMENTO;
	}



	public String getSOLUCAO() {
		return SOLUCAO;
	}



	public void setSOLUCAO(String sOLUCAO) {
		SOLUCAO = sOLUCAO;
	}



	@Override
	public String toString() {
		
		return  "\nTitulo: " +this.getTitulo()+
				"\nDescricao: " +this.getDescricao()+
				"\nidChamado: " + this.getIdChamado()+
				 "\nData de Abertura: " + this.validaData(this.getDATAABERTURA())
				+"\nSolu????o: " + this.getSOLUCAO();
	}
	
	private String validaData(LocalDate data) {
		String resultado = "";
		if(data != null) {
			resultado = data.format(formaterDate);
		}
		return resultado;
	}



	public void imprimir() {
	}






    
    
}
