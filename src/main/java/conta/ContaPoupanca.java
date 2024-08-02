package conta;

import cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato conta.Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
}
