package utils;

import java.util.Scanner;

public class MenuUtils {

    public static void iniciaMenu() {
        String opcao;
        Scanner scanner = new Scanner(System.in);
        do {
            imprimeMenu();

            opcao = scanner.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    BancoUtils.listarContas();
                    break;
                case "2":
                    BancoUtils.criarNovaConta(scanner);
                    break;
                case "3":
                    ClienteUtils.listarClientes();
                    break;
                case "4":
                    ClienteUtils.criarNovoCliente(scanner);
                    break;
                case "S":
                    System.out.println("Finalizando...");
                    break;
                default:
                    imprimirMensagemOpcaoInvalida();
                    break;
            }

        } while (!opcao.equalsIgnoreCase("S"));
        scanner.close();
        imprimeMensagemFinalizacao();
    }

    private static void imprimeMenu() {
        System.out.println("======DIO Banco======");
        System.out.println("1 - Listar Contas");
        System.out.println("2 - Cadastrar Conta");
        System.out.println("3 - Listar Clientes");
        System.out.println("4 - Cadastrar Clientes");
        System.out.println("S - Sair");
        System.out.println("=====================");
    }

    private static void imprimeMensagemFinalizacao() {
        System.out.println("Obrigado por usar o DIO Banco!");
    }

    private static void imprimirMensagemOpcaoInvalida() {
        System.out.println("Opcao invalida!");
    }

}
