package fachada;
import modelo.Cliente;
import modelo.Produto;
import modelo.Pedido;
import modelo.PedidoExpress;
import repositorio.Repositorio;

import java.util.ArrayList;




public class Fachada {
	private static Repositorio repositorio = new Repositorio();

	// Getters
	public ArrayList<Produto> listarProdutos(String texto) {
		if (texto.isEmpty()) {
			return repositorio.getProdutos();
		} else {
			ArrayList<Produto> encontrados = new ArrayList<>();			
			for (Produto prod: repositorio.getProdutos()) {
				if (prod.getNome().contains(texto)) {
					encontrados.add(prod);
				}
			}
			return encontrados;
		}
	}
	
	
	public ArrayList<Cliente> listarClientes() {
		return repositorio.getClientes();
	}
	
	
	public ArrayList<Pedido> listarPedidos() {
		return repositorio.getPedidos();
	}
	
	
	public ArrayList<Pedido> listarPedidos(String telefone, int tipo) throws Exception {
		if (telefone.isEmpty()) {
			throw new Exception("Telefone inválido.");
		} else if (tipo < 1 || tipo > 3) {
			throw new Exception("Tipo inválido.");
		} else {
			ArrayList<Pedido> encontrados = new ArrayList<>();
			
			if (tipo == 1) {
				for (Pedido ped: repositorio.getPedidos()) {
					if (ped.isPago() && (ped.getCliente().getTelefone().equals(telefone))) {
						encontrados.add(ped);
					}
				}
			} else if (tipo == 2) {
				for (Pedido ped: repositorio.getPedidos()) {
					if (!ped.isPago() && (ped.getCliente().getTelefone().equals(telefone))) {
						encontrados.add(ped);
					}
				}
			} else if (tipo == 3) {
				for (Pedido ped: repositorio.getPedidos()) {
					if (ped.getCliente().getTelefone().equals(telefone)) {
						encontrados.add(ped);
					}
				}
			}		
			
			return encontrados;
		}			
		
	}
	
	
	public Produto cadastrarProduto(String nome, double preco) throws Exception {
		if (nome.isEmpty()) {
			throw new Exception("Nome inválido.");
		}
		if (preco <= 0) {
			throw new Exception("Preço inválido.");
		}
		for (Produto prod: repositorio.getProdutos()) {
			if (prod.getNome() == nome) {
				throw new Exception("Produto já cadastrado.");
			}
		}
		
		Produto prod = new Produto(nome, preco);
		Fachada.repositorio.addProduto(prod);
		return prod;		
	}
	
	
	public Cliente cadastrarCliente(String telefone, String nome, String endereco) throws Exception {
		// telefone
		if (telefone.isEmpty()) {
			throw new Exception("Telefone inválido.");
		} else {
			for (Cliente cli: repositorio.getClientes()) {
				if (telefone == cli.getTelefone()) {
					throw new Exception("Telefone já cadastrado.");
				}
			}
		}
		
		// nome
		if (nome.isEmpty()) {
			throw new Exception("Nome inválido.");
		}
		
		// endereco
		if (endereco.isEmpty()) {
			throw new Exception("Endereço inválido.");
		}
		
		Cliente cli = new Cliente(telefone, nome, endereco);
		Fachada.repositorio.addCliente(cli);
		return cli;
	}
	
	
	public Pedido criarPedido(String telefone) throws Exception {
		if (telefone.isEmpty()) {
			throw new Exception("Telefone inválido.");
		}
		 Cliente cli = null;
		 
		 for (Cliente clie : repositorio.getClientes()) {
			 if (clie.getTelefone().equals(telefone)) {
				 cli = clie;
			 }
		 }
		 		 
		 if (cli == null) {
			 throw new Exception("Cliente não encontrado.");
		 } 
		 
		 Pedido ped = new Pedido(cli);
		 repositorio.addPedido(ped);
		 
		 return ped;
	}
	
	
	public Pedido criarPedidoExpress(String telefone, double taxa) throws Exception {
		if (telefone.isEmpty()) {
			throw new Exception("Telefone inválido.");
		}
		if (taxa < 0) {
			throw new Exception("Taxa inválida.");
		}
		
		 Cliente cli = null;
		 
		 for (Cliente clie : repositorio.getClientes()) {
			 if (clie.getTelefone().equals(telefone)) {
				 cli = clie;
			 }
		 }
		 
		 if (cli == null) {
			 throw new Exception("Cliente não encontrado.");
		 } 
		 
		 Pedido ped = new PedidoExpress(cli, taxa);
		 repositorio.addPedido(ped);
		 
		 return ped;
	}
	
	
	public void adicionarProdutoPedido(int idpedido, int idproduto) throws Exception {
		Pedido ped = repositorio.buscarPedido(idpedido);
		Produto prod = repositorio.buscarProduto(idproduto);
		if (ped == null) {
			throw new Exception("Pedido não encontrado.");
		} else if (prod == null) {
			throw new Exception("Produto não encontrado.");
		} else {
			ped.addProduto(prod);
		}
	}
	
	
	public void removerProdutoPedido(int idpedido, int idproduto) throws Exception {
		Pedido ped = repositorio.buscarPedido(idpedido);
		Produto prod = repositorio.buscarProduto(idproduto);
		if (ped == null) {
			throw new Exception("Pedido não encontrado.");
		} else if (prod == null) {
			throw new Exception("Produto não encontrado.");
		} else {
			ped.removerProduto(prod);				
		}
	}
	
	
	public Pedido consultarPedido(int idpedido) throws Exception {
		Pedido ped = repositorio.buscarPedido(idpedido);
		if (ped != null) {
			return ped;
		} else {
			throw new Exception("Pedido não encontrado.");
		}
	}
	
	
	public void pagarPedido(int idpedido, String nomeentregador) throws Exception {
		if (nomeentregador.isEmpty()) {
			throw new Exception("Nome inválido para entregador.");
		}
		Pedido ped = repositorio.buscarPedido(idpedido);
		if (ped == null) {
			throw new Exception("Pedido não encontrado.");
		}
		if (ped.isPago()) {
			throw new Exception("Não é possível pagar um pedido já pago.");
		}
		if (ped.getProdutos().isEmpty()) {
			throw new Exception("Não é possível pagar um pedido vazio.");
		}
		ped.setEntregador(nomeentregador);
		ped.setPago(true);
	}
	
	
	public void cancelarPedido(int idpedido) throws Exception {
		Pedido ped = repositorio.buscarPedido(idpedido);
		if (ped == null) {
			throw new Exception("Pedido não encontrado.");
		} else if (ped.isPago()) {
			throw new Exception("Não é possível cancelar um pedido pago.");
		} else {
			ped.esvaziar();
			repositorio.cancelarpedido(ped);
		}
	}
}
