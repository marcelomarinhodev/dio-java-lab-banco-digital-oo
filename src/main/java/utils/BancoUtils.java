package utils;

import banco.Banco;
import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

import java.util.Objects;
import java.util.Scanner;

public class BancoUtils {

    private static Banco banco;

    public static void listarContas() {
        System.out.println("Listando as contas cadastradas...");
        getBanco().getContas().forEach(conta -> {
            System.out.println("Conta " + conta.getNumero() + ":");
            conta.imprimirExtrato();
        });
    }

    public static void criarNovaConta(Scanner scanner) {
        Cliente cliente = null;
        Conta conta = null;
        while (Objects.isNull(cliente)) {
            System.out.println("Digite o nome do cliente (ou SAIR para cancelar):");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("SAIR"))
                break;
            cliente = ClienteUtils.buscaPorNome(nome);
            if (Objects.isNull(cliente)) System.out.println("Cliente nao encontrado!");
            else System.out.println("CLIENTE: " + cliente.getNome());
        }
        boolean tipoContaValido = false;
        while (!Objects.isNull(cliente) && !tipoContaValido) {
            System.out.println("Escolha o Tipo de Conta (ou SAIR para cancelar):");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Poupança");
            String tipoConta = scanner.nextLine();
            boolean isSair = false;
            switch (tipoConta.toUpperCase()) {
                case "1":
                    conta = new ContaCorrente(cliente);
                    tipoContaValido = true;
                    break;
                case "2":
                    conta = new ContaPoupanca(cliente);
                    tipoContaValido = true;
                    break;
                case "SAIR":
                    isSair = true;
                    break;
                default:
                    break;
            }
            if (isSair) break;
        }
        if (tipoContaValido) {
            getBanco().getContas().add(conta);
            imprimeMensagemSucesso();
        }
    }

    private static void imprimeMensagemSucesso() {
        System.out.println("Conta cadastrada com sucesso!");
    }

    private static Banco getBanco() {
        if (Objects.isNull(banco)) {
            banco = new Banco("DIO Banco");
        }
        return banco;
    }

}
