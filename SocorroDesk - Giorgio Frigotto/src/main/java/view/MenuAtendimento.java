package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ChamadoController;
import model.vo.ChamadoVO;
import model.vo.UsuarioVO;

public class MenuAtendimento {

	Scanner input = new Scanner(System.in);
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_LISTAR_CHAMADO = 1;
	private static final int OPCAO_MENU_ATENDER_CHAMADO = 2;
	private static final int OPCAO_MENU_SAIR_CHAMADO = 9;

	private static final int OPCAO_MENU_LISTAR_CHAMADO_ABERTOS = 1;
	private static final int OPCAO_MENU_LISTAR_CHAMADO_FECHADOS = 2;
	private static final int OPCAO_MENU_SAIR_CHAMADO_SAIR = 9;

	public void apresentarMenuAtendimento(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_SAIR_CHAMADO) {
			switch (opcao) {
				case OPCAO_MENU_LISTAR_CHAMADO:
					this.listarChamados(usuarioVO);
					break;

				case OPCAO_MENU_ATENDER_CHAMADO:
					this.atenderChamado(usuarioVO);
					break;
				
				default:
					System.out.println("\nOpção inválida!");
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private void listarChamados(UsuarioVO usuarioVO) {
		int opcao = this.apresentarOpcoesConsulta();
		ChamadoController chamadoController = new ChamadoController();
		while (opcao != OPCAO_MENU_SAIR_CHAMADO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_LISTAR_CHAMADO_ABERTOS:
					opcao = OPCAO_MENU_SAIR_CHAMADO_SAIR;
					ArrayList<ChamadoVO> listaChamadosVO = chamadoController.listarChamadosAbertosController();
					System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%10s  %10s  %10s  %-30s  %-50s  %-15s  %-30s  %-15s", "ID CHAMADO", "ID USUÁRIO", "ID TÉCNICO", "TÍTULO", "DESCRIÇÃO", "DATA ABERTURA", "SOLUÇÃO", "DATA FECHAMENTO");
					for (int i = 0; i < listaChamadosVO.size(); i++) {
						listaChamadosVO.get(i).imprimir();
					}
					System.out.println();
					break;

				case OPCAO_MENU_LISTAR_CHAMADO_FECHADOS:
					opcao = OPCAO_MENU_SAIR_CHAMADO_SAIR;
					ArrayList<ChamadoVO> listaDeChamadosVO = chamadoController.lsitarChamadosFechadosTecnicoController(usuarioVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%10s  %10s  %10s  %-30s  %-50s  %-15s  %-30s  %-15s", "ID CHAMADO", "ID USUÁRIO", "ID TÉCNICO", "TÍTULO", "DESCRIÇÃO", "DATA ABERTURA", "SOLUÇÃO", "DATA FECHAMENTO");
					for (int i = 0; i < listaDeChamadosVO.size(); i++) {
						listaDeChamadosVO.get(i).imprimir();
					}
					System.out.println();
					break;
				
				default:
					System.out.println("\nOpção inválida!");
					opcao = this.apresentarOpcoesConsulta();
			}
		}
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada:");
		System.out.println(OPCAO_MENU_LISTAR_CHAMADO_ABERTOS + "-- Listar chamado");
		System.out.println(OPCAO_MENU_LISTAR_CHAMADO_FECHADOS + "-- Atender chamado");
		System.out.println(OPCAO_MENU_SAIR_CHAMADO_SAIR+ "-- Voltar");
		System.out.print("Insira uma opção: ");
		return Integer.parseInt(input.nextLine());
	}

	private void atenderChamado(UsuarioVO usuarioVO) {
		ChamadoVO chamadoVO = new ChamadoVO();
		chamadoVO.setIDTECNICO(usuarioVO.getIdUsuario());
		System.out.print("\nDigite o código do chamado: ");
		chamadoVO.setIdChamado(Integer.parseInt(input.nextLine()));
		System.out.print("\nDigite a solução: ");
		chamadoVO.setSOLUCAO(input.nextLine());
		chamadoVO.setDATAFECHAMENTO(LocalDate.now());

		if(chamadoVO.getIdChamado() == 0 || chamadoVO.getSOLUCAO().isEmpty()) {
			System.out.println("Os campos código do chamado e solução são obrigatórios");
		} else {
			ChamadoController chamadoController = new ChamadoController();
			chamadoVO = chamadoController.atenderChamadoController(chamadoVO);
			if(chamadoVO.getDATAFECHAMENTO() != null) {
				System.out.println("Chamado fechado com sucesso!");
			} else {
				System.out.println("Não foi possível fechar o chamado!");
			}
		}

	}

	private int apresentarOpcoesMenu() {
		System.out.println("\n---- Sistema Socrro Desk ----");
		System.out.println("\n---- Menu Atendimento de chamados ----");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_LISTAR_CHAMADO + "-- Listar chamado");
		System.out.println(OPCAO_MENU_ATENDER_CHAMADO + "-- Atender chamado");
		System.out.println(OPCAO_MENU_SAIR_CHAMADO+ "-- Voltar");
		System.out.print("Insira uma opção: ");
		return Integer.parseInt(input.nextLine());
	}

}
