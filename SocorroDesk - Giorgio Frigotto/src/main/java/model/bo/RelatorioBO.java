package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.RelatorioDTO;


public class RelatorioBO {

	public ArrayList<RelatorioDTO> relatorioChamadosUsuario(int idUsuario) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<RelatorioDTO> relatoriosDTO = relatorioDAO.listarRelatorioIdUsuarioDAO(idUsuario);
		if (relatoriosDTO.isEmpty()) {
			System.out.println("\nLista de Relatório está vazia!");
		}
		return relatoriosDTO;

}
	
	public ArrayList<RelatorioDTO> relatorioQuantidadeChamados(int idUsuario) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<RelatorioDTO> relatoriosDTO = relatorioDAO.relatorioQuantidadeChamados(idUsuario);
		if (relatoriosDTO.isEmpty()) {
			System.out.println("\nLista de Relatório está vazia!");
		}
		return relatoriosDTO;

}
}
