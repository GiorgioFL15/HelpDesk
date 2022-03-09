package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.RelatorioController;
import model.dto.RelatorioDTO;


public class MenuRelatorio {

	DateTimeFormatter formaterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner teclado = new Scanner(System.in);
	public static final int OPCAO_RELATORIO_CHAMADOS_USUARIO = 1;
	public static final int OPCAO_RELATORIO_TOTAL_CHAMADOS_USUARIO = 2;
	public static final int OPCAO_RELATORIO_SAIR = 3;

	public void apresentarMenuRelatorio() {
		// ChamadoController chamadoController = new ChamadoController();
		int opcao = apresentarOpcaoRelatorio();
		while (opcao != OPCAO_RELATORIO_SAIR) {
			switch (opcao) {
			case OPCAO_RELATORIO_CHAMADOS_USUARIO:
				this.verRelatorioChamadosPorIdUsuario();
				break;
			case OPCAO_RELATORIO_TOTAL_CHAMADOS_USUARIO:
				this.verRelatorioQuantidadeChamadosPorUsuario();
				break;
			default: {
				System.out.println("Opção invalida!");
			}
			}
			opcao = apresentarOpcaoRelatorio();
		}
	}

	private void verRelatorioQuantidadeChamadosPorUsuario() {
		RelatorioController relatorioController = new RelatorioController();
		System.out.print("\nInsira o id do usuário a ser consultado: ");
		int id = Integer.parseInt(teclado.nextLine());
		System.out.printf("\n%3s  %-13s  %-20s  %-11s  %-10s  ",
				"ID", "NOME", "CPF", "E-MAIL", "TOTAL CHAMADOS");

		ArrayList<RelatorioDTO> relatorioDTO = relatorioController.relatorioQuantidadeChamados(id);
		for (int c = 0; c < relatorioDTO.size(); c++) {
			relatorioDTO.get(c).imprimirContador();

		}
		System.out.println();
	}

	private void verRelatorioChamadosPorIdUsuario() {
		RelatorioController relatorioController = new RelatorioController();
		ArrayList<RelatorioDTO> relatorioDTO = new ArrayList<RelatorioDTO>();
		System.out.print("\nInsira o id do usuario a ser consultado: ");
		int id = Integer.parseInt(teclado.nextLine());
		System.out.printf("%3s  %-13s  %-20s  %-11s  %-20s  %-15s  %-15s  %-10s  %-10s ",
				"ID", "NOME", "CPF", "E-MAIL", "DATAABERTURA",
				"DATAFECHAMENTO", "descricao", "titulo", "solucao");

		relatorioDTO = relatorioController.relatorioChamadosUsuario(id);
		for (int c = 0; c < relatorioDTO.size(); c++) {
			relatorioDTO.get(c).imprimir();

		}
		System.out.println();
	}

	private int apresentarOpcaoRelatorio() {
		System.out.println("\n---- Sistema Socorro Desk ----");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_RELATORIO_CHAMADOS_USUARIO + "-- Ver chamados por IdUsuario");
		System.out.println(OPCAO_RELATORIO_TOTAL_CHAMADOS_USUARIO + "-- Ver total de chamados de um usuário");
		System.out.println(OPCAO_RELATORIO_SAIR + "-- Sair");
		System.out.print("Insira uma opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
