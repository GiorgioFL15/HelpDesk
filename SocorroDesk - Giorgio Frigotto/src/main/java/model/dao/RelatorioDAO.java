package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dto.RelatorioDTO;

public class RelatorioDAO {

	DateTimeFormatter formaterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public ArrayList<RelatorioDTO> listarRelatorioIdUsuarioDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioDTO> DadosRelatorio = new ArrayList<RelatorioDTO>();

		String query = "SELECT USUARIO.IDUSUARIO, " + 
				"USUARIO.NOME, " + 
				"USUARIO.CPF, " + 
				"USUARIO.EMAIL, " + 
				"CHAMADOS.DATAABERTURA," + 
				"CHAMADOS.DATAFECHAMENTO, " + 
				"CHAMADOS.DESCRICAO, " + 
				"CHAMADOS.TITULO, " + 
				"CHAMADOS.SOLUCAO " + 
				"FROM " + 
				"USUARIO INNER JOIN CHAMADOS ON " +idUsuario+" = CHAMADOS.IDUSUARIO";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				RelatorioDTO relatorioDTO = new RelatorioDTO();
				relatorioDTO.setIdUsuario(resultado.getInt(1));
				relatorioDTO.setNome(resultado.getString(2));
				relatorioDTO.setCpf(resultado.getString(3));
				relatorioDTO.setEmail(resultado.getString(4));
				if (resultado.getString(5) != null) {
				relatorioDTO.setDataAbertura(LocalDate.parse(resultado.getString(5), formaterDate));
				}
				if (resultado.getString(6) != null) {
					relatorioDTO.setDataFechamento(LocalDate.parse(resultado.getString(6), formaterDate));
				}
				relatorioDTO.setDescricao(resultado.getString(7));
				relatorioDTO.setTitulo(resultado.getString(8));
				relatorioDTO.setSolucao(resultado.getString(9));
				DadosRelatorio.add(relatorioDTO);
		   
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica a existencia do relatorio por idusuario.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return DadosRelatorio;
	}
	
	
	public ArrayList<RelatorioDTO> relatorioQuantidadeChamados(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioDTO> dadosRelatorio = new ArrayList<RelatorioDTO>();
		
		String query = " SELECT usuario.idusuario, usuario.nome, usuario.cpf, usuario.email, count(chamados.idchamado) "
						+  " FROM usuario INNER JOIN chamados ON "+ idUsuario +" = chamados.idusuario "
						+  " GROUP BY usuario.idusuario, usuario.nome, usuario.cpf, usuario.email ";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				RelatorioDTO relatorioDTO = new RelatorioDTO();
				relatorioDTO.setIdUsuario(resultado.getInt(1));
				relatorioDTO.setNome(resultado.getString(2));
				relatorioDTO.setCpf(resultado.getString(3));
				relatorioDTO.setEmail(resultado.getString(4));
				relatorioDTO.setTotalChamados(resultado.getInt(5));
				dadosRelatorio.add(relatorioDTO);
		   
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica a existencia do relatorio por idusuario.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return dadosRelatorio;
	}


}
