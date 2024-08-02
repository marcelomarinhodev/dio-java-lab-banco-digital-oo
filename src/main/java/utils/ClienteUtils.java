package utils;

import cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClienteUtils {

    private static List<Cliente> clientes;

    public static void criarNovoCliente(Scanner scanner) {
        System.out.println("Informe um nome (ou SAIR para cancelar):");
        String nome = null;
        while (Objects.isNull(nome) || nome.isEmpty()) {
            nome = scanner.nextLine().trim();
            if (nome.isEmpty())
                continue;
            String finalNome = nome;
            boolean isClienteCadastrado = !getClientes().stream()
                    .filter(cliente -> cliente.getNome().equalsIgnoreCase(finalNome))
                    .toList().isEmpty();
            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }
            if (isClienteCadastrado) {
                System.out.println("Cliente já cadastrado! Informe um novo nome (ou SAIR para cancelar):");
                nome = null;
            } else {
                getClientes().add(new Cliente(nome));
                imprimeMensagemSucesso();
            }
        }
    }

    public static Cliente buscaPorNome(String nome) {
        List<Cliente> clientes = getClientes().stream()
                .filter(cli -> cli.getNome().equalsIgnoreCase(nome))
                .toList();
        return clientes.isEmpty() ? null : clientes.getFirst();
    }

    public static void listarClientes() {
        System.out.println("Listando os clientes cadastrados...");
        getClientes().forEach(cliente -> System.out.println(cliente.getNome()));
    }

    private static void imprimeMensagemSucesso() {
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static List<Cliente> getClientes() {
        if (Objects.isNull(clientes)) {
            clientes = new ArrayList<>();
        }
        return clientes;
    }

    private static void adicionarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

}
