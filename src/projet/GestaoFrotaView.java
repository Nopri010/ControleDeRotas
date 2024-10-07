// RA: 1136044 - João Vitor Parizotto Benedetti
// RA: 1136052 - Gabriel Grasik da Rosa
// RA: 1136919 - Alex Gonçalves
// RA: 1136153 - Leonardo Dapper

package projet;

import java.util.Scanner;

import entities.GestaoFrotaService;
import entities.Veiculo;

public class GestaoFrotaView {
    private static GestaoFrotaService frotaService = new GestaoFrotaService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        System.out.println("----- Sistema de Gestão de Frotas -----");
        System.out.println("1 – Cadastrar Novo Veículo");
        System.out.println("2 – Listar todos Veículos cadastrados");
        System.out.println("3 – Pesquisar um Veículo por placa");
        System.out.println("4 – Remover um Veículo");
        System.out.println("0 – Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = lerOpcao();

        switch (opcao) {
            case 1:
                cadastrarVeiculo();
                break;
            case 2:
                listarVeiculos();
                break;
            case 3:
                buscarVeiculo();
                break;
            case 4:
                removerVeiculo();
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        limparTela();
        exibirMenuNovamente();
    }
    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar a tela.");
        }
    }
    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void cadastrarVeiculo() {
        System.out.println("Cadastro de Novo Veículo:");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = lerInteiro();
        System.out.print("Número de Portas: ");
        int numeroPortas = lerInteiro();

        String resultado = frotaService.cadastrarVeiculo(placa, ano, numeroPortas);
        System.out.println(resultado);
    }

    private static void listarVeiculos() {
        System.out.println("Veículos cadastrados:");
        for (Veiculo v : frotaService.listarVeiculos()) {
            System.out.println(v);
        }
    }

    private static void buscarVeiculo() {
        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = frotaService.buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            System.out.println("Veículo encontrado: " + veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void removerVeiculo() {
        System.out.print("Digite a placa do veículo a ser removido: ");
        String placa = scanner.nextLine();
        String resultado = frotaService.removerVeiculo(placa);
        System.out.println(resultado);
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, digite um número: ");
            }
        }
    }

    private static void exibirMenuNovamente() {
    	
        System.out.println("\nPara exibir o menu novamente, digite (1). Para encerrar a sessão, digite (2):");
        int a = scanner.nextInt();
        scanner.nextLine();
        if (a == 1) {
            exibirMenu();
        } else {
            System.out.println("Sessão encerrada.");
            System.exit(0);
        }
    }
}