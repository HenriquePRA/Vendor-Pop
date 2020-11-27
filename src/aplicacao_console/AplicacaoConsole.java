package aplicacao_console;

import java.time.LocalDateTime;

import fachada.Fachada;

public class AplicacaoConsole {
	public static void main(String[] args) {
		Fachada fachada = new Fachada();
		
		// cadastro dos clientes	
		fachada.cadastrarCliente("81476369", "Jose Silva",  "Rua dos Pescadores 15");
		fachada.cadastrarCliente("98541569", "Maria Pereira", "Avenida jose filho 123");
		fachada.cadastrarCliente("81234756", "Lucia Santos", "Rua Instituto Elo 7");
		fachada.cadastrarCliente("91165001", "Adamastor", "Avenida Presidente Medici 255");
		
		// cadastro dos produtos
		fachada.cadastrarProduo("Sanduiche de frango", 4.5);
		fachada.cadastrarProduo("Sanduiche de Presunto", 4);
		fachada.cadastrarProduo("Hamburger", 5.2);
		fachada.cadastrarProduo("Salgado", 3);
		fachada.cadastrarProduo("Refrigerante", 6);

		// cadastro dos pedidos		
		fachada.criarPedido("81476369");
		fachada.adicionarProdutoPedido(1, 1);
		fachada.adicionarProdutoPedido(1, 2);
		fachada.adicionarProdutoPedido(1, 2);
		fachada.removerProdutoPedido(1, 2);
		fachada.pagarPedido(1, "Joao");
		
		fachada.criarPedido("98541569");
		fachada.adicionarProdutoPedido(2, 1);
		fachada.removerProdutoPedido(2, 1);
		fachada.adicionarProdutoPedido(2, 2);
		fachada.pagarPedido(2, "Jose");
		
		fachada.criarPedido("81234756");
		fachada.adicionarProdutoPedido(3, 4);
		fachada.adicionarProdutoPedido(3, 5);
		fachada.cancelarPedido(3);
		
		fachada.criarPedido("91165001");
		fachada.adicionarProdutoPedido(4, 3);
		fachada.adicionarProdutoPedido(4, 3);
		
		fachada.criarPedido("81476369", 10);
		fachada.adicionarProdutoPedido(5, 1);
		fachada.adicionarProdutoPedido(5, 2);
		fachada.adicionarProdutoPedido(5, 3);
		fachada.adicionarProdutoPedido(5, 4);
		fachada.adicionarProdutoPedido(5, 5);
		
		System.out.println("\nListagem total de produtos\n");
		System.out.println(fachada.listarProdutos(""));
		System.out.println("\nListagem de produtos com o nome sanduiche\n");
		System.out.println(fachada.listarProdutos("Sanduiche"));
		System.out.println("\nListagem de todos os clientes\n");
		System.out.println(fachada.listarClientes());
		System.out.println("\nListagem de todos os pedidos\n");
		System.out.println(fachada.listarPedidos());
		System.out.println("\nListagem de todos os pedidos pagos do numero 81476369\n");
		System.out.println(fachada.listarPedidos("81476369", 1));
		System.out.println("\nListagem de todos os pedidos NAO pagos do numero 81476369\n");
		System.out.println(fachada.listarPedidos("81476369", 2));
		System.out.println("\nListagem de todos os pedidos do numero 81476369\n");
		System.out.println(fachada.listarPedidos("81476369", 3));
		System.out.println("\nConsulta pelo pedido de id 1\n" + fachada.consultarPedido(1));
		System.out.println("\nConsulta pela arrecadação do dia atual\n");
		System.out.println(fachada.consultarArrecadacao(LocalDateTime.now().getDayOfMonth()));
		System.out.println("\nConsulta pelos produtos mais vendidos\n");
		System.out.println(fachada.consultarProdutoTop());		
	}
}
