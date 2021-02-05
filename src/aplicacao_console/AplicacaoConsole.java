package aplicacao_console;
import java.util.ArrayList;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class AplicacaoConsole {
	
	private Produto pizza, sushi,coca, guarana, suco;
	
	private static Fachada fachada = new Fachada();

	public AplicacaoConsole() {
		try {
			System.out.println("Cadastrar clientes e produtos");
			fachada.cadastrarCliente("988881111", "paulo", "Rua dos Tronos, 1");
			fachada.cadastrarCliente("988882222", "maria","Rua da Justiça, 2");			
			fachada.cadastrarCliente("988883333", "pedro","Rua da Pesca, 3");			
			fachada.cadastrarCliente("988884444", "ana","Rua do Silencio, 4");		
			fachada.cadastrarCliente("988885555", "katia","Rua da Paz, 5");		

			pizza = fachada.cadastrarProduto("pizza", 30.0);
			sushi = fachada.cadastrarProduto("sushi", 40.0);
			coca = fachada.cadastrarProduto("coca-cola", 10.0);
			guarana = fachada.cadastrarProduto("guarana", 9.0);	
			suco = fachada.cadastrarProduto("suco", 4.0);	

			System.out.println("Criar pedidos");
			fachada.criarPedido("988881111");
			fachada.criarPedido("988882222");
			fachada.criarPedido("988883333");
			fachada.criarPedido("988881111");
			fachada.criarPedidoExpress("988881111", 10.0);

			System.out.println("Adicionar produtos");		
			fachada.adicionarProdutoPedido(1, 1);
			fachada.adicionarProdutoPedido(1, 1);
			fachada.adicionarProdutoPedido(1, 3);

			fachada.adicionarProdutoPedido(2, 2);	
			fachada.adicionarProdutoPedido(2, 2);
			fachada.adicionarProdutoPedido(2, 4);
			fachada.removerProdutoPedido(2, 2);	

			fachada.adicionarProdutoPedido(3, 1);	
			fachada.adicionarProdutoPedido(3, 2);
			fachada.adicionarProdutoPedido(3, 3);	
			fachada.adicionarProdutoPedido(3, 4);
			fachada.removerProdutoPedido(3, 4);	

			//pedido 4 nao possui produtos

			fachada.adicionarProdutoPedido(5, 1);	
			fachada.adicionarProdutoPedido(5, 2);
			fachada.adicionarProdutoPedido(5, 3);	
			fachada.adicionarProdutoPedido(5, 4);
			fachada.adicionarProdutoPedido(5, 5);

			listarProdutos("");
			listarProdutos("i"); //contem a letra i  (contains)
			listarClientes();
			listarPedidos();
			listarPedidos("988881111",1);	//pagos
			listarPedidos("988881111",2);	//nao pagos
			listarPedidos("988881111",3);	//todos

			System.out.println("\nPagar pedidos");				
			fachada.pagarPedido(1, "joao");		//nome do entregador
			fachada.pagarPedido(2, "jose");
			fachada.pagarPedido(5, "jose");
			System.out.println("Cancelar pedido");
			fachada.cancelarPedido(3);

			System.out.println("\nconsultar pedido 1\n"+ fachada.consultarPedido(1)); //idpedido
			System.out.println("\nconsultar pedido 2\n"+ fachada.consultarPedido(2));
			System.out.println("\nconsultar pedido 5\n"+ fachada.consultarPedido(5));

			double calculo = 3*pizza.getPreco()+
							2*sushi.getPreco()+
							2*coca.getPreco()+
							2*guarana.getPreco()+
							1*suco.getPreco() + 10.0;
		
			System.out.println("Cálculo de Produtos: "+calculo);

			//---------------------------------------------
			listarProdutos("");
			listarProdutos("i"); //contem a letra i
			listarClientes();
			listarPedidos();
			listarPedidos("988881111",1);	//pagos
			listarPedidos("988881111",2);	//nao pagos
			listarPedidos("988881111",3);	//todos

			//**************
			testarExcecoes();
			//**************

		} catch (Exception e) {
			System.out.println("EXCESSÃO NÃO PLANEJADA ---> "+e.getMessage());
		}		
	}

	public void listarClientes() {
		System.out.println("\nListagem de clientes:");
		ArrayList<Cliente> clientes = fachada.listarClientes();
		for(Cliente c : clientes)
			System.out.println(c);
	}

	public void listarProdutos(String texto) {
		System.out.println("\nListagem de produtos: " + texto);
		ArrayList<Produto> produtos = fachada.listarProdutos(texto);
		for(Produto p : produtos)
			System.out.println(p);
	}

	public void listarPedidos() {
		System.out.println("\nListagem de pedidos:");
		ArrayList<Pedido> pedidos = fachada.listarPedidos();
		for(Pedido p : pedidos)
			System.out.println(p);
	}

	public void listarPedidos(String telefone, int tipo) throws Exception {
		System.out.println("\nListagem de pedidos de um cliente: - tipo:" + tipo);
		ArrayList<Pedido> pedidos = fachada.listarPedidos(telefone, tipo);
		for(Pedido p : pedidos)
			System.out.println(p);
	}
	
	public Fachada getFachada() {
		return fachada;
	}

	public static void testarExcecoes() {
		System.out.println("\n################## EXCEÇÕES LANÇADAS ##################\n");
		try {
			fachada.cadastrarProduto("pizza", 30.0);
			System.out.println("1 - Nao lançou exceção para: cadastro de produto existente "); 
		}catch (Exception e) {System.out.println("1 - OK ---> "+e.getMessage());}

		try {
			fachada.adicionarProdutoPedido(99, 1);	//pedido 99
			System.out.println("2 - Nao lançou exceção para: pedido inexistente"); 
		}catch (Exception e) {System.out.println("2 - OK ---> "+e.getMessage());}

		try {
			fachada.adicionarProdutoPedido(4, 99);	//produto 99
			System.out.println("3 - Nao lançou exceção para: pedido de produto inexistente"); 
		}catch (Exception e) {System.out.println("3 - OK ---> "+e.getMessage());}

		try {
			fachada.pagarPedido(2,"entregador");	//pedido 2 ja foi pago
			System.out.println("4 - Nao lançou exceção para: pagar pedido ja pago"); 
		}catch (Exception e) {System.out.println("4 - OK ---> "+e.getMessage());}
		
		try {
			fachada.adicionarProdutoPedido(2, 1);   //pedido 2 ja foi pago
			System.out.println("5 - Nao lançou exceção para: adicionar produtos em pedido pago"); 
		}catch (Exception e) {System.out.println("5 - OK ---> "+e.getMessage());}
		
		try {
			fachada.removerProdutoPedido(2, 2);   //pedido 2 ja foi pago
			System.out.println("6 - Nao lançou exceção para: remover produtos em pedido pago"); 
		}catch (Exception e) {System.out.println("5 - OK ---> "+e.getMessage());}
		
		try {
			fachada.removerProdutoPedido(4, 1);   //pedido 2 ja foi pago
			System.out.println("7 - Nao lançou exceção para: remover produto nao existentes em um pedido"); 
		}catch (Exception e) {System.out.println("5 - OK ---> "+e.getMessage());}

		try {
			fachada.cancelarPedido(2);   //pedido 2 ja foi pago
			System.out.println("8 - Nao lançou exceção para: remover produto nao existentes em um pedido"); 
		}catch (Exception e) {System.out.println("5 - OK ---> "+e.getMessage());}
		
	}


	public static void main (String[] args) {
		@SuppressWarnings("unused")
		AplicacaoConsole aplicacaoConsole = new AplicacaoConsole();
	}
}
