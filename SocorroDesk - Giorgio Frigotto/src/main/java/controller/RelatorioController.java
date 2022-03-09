package controller;

import java.util.ArrayList;

import model.bo.RelatorioBO;
import model.dto.RelatorioDTO;

public class RelatorioController {

	public ArrayList<RelatorioDTO> relatorioChamadosUsuario(int idUsuario) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.relatorioChamadosUsuario(idUsuario);
	}
	
	public ArrayList<RelatorioDTO> relatorioQuantidadeChamados(int idUsuario) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.relatorioQuantidadeChamados(idUsuario);
	}

}
