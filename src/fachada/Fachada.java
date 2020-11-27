package fachada;
import modelo.Cliente;
import modelo.Produto;
import modelo.Pedido;
import modelo.PedidoExpress;
import repositorio.Repositorio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Fachada {
	private static Repositorio repositorio = new Repositorio();

	// Getters
	public ArrayList<Produto> listarProdutos(String texto) {
		if (texto == "") {
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
	
	
	public ArrayList<Pedido> listarPedidos(String telefone, int tipo) {
		try {
			if (telefone == "") {
				throw new Exception("Telefone inválido");
			} else if (tipo < 1 || tipo > 3) {
				throw new Exception("Tipo inválido");
			} else {
				ArrayList<Pedido> encontrados = new ArrayList<>();		
				if (tipo == 1) {
					for (Pedido ped: repositorio.getPedidos()) {
						if (ped.isPago() && (ped.getCliente().getTelefone() == telefone)) {
							encontrados.add(ped);
						}
					}
				} else if (tipo == 2) {
					for (Pedido ped: repositorio.getPedidos()) {
						if (!ped.isPago() && (ped.getCliente().getTelefone() == telefone)) {
							encontrados.add(ped);
						}
					}
				} else if (tipo == 3) {
					for (Pedido ped: repositorio.getPedidos()) {
						if (ped.getCliente().getTelefone() == telefone) {
							encontrados.add(ped);
						}
					}
				}
				return encontrados;
			}			
		} catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public Produto cadastrarProduo(String nome, double preco) {
		try {
			if (nome == "") {
				throw new Exception("Nome inválido !");
			}
			if (preco <= 0) {
				throw new Exception("Preço inválido !");
			}
			
			Produto prod = new Produto(nome, preco);
			Fachada.repositorio.addProduto(prod);
			return prod;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}		
	}
	
	
	public Cliente cadastrarCliente(String telefone, String nome, String endereco) {
		try {
			// telefone
			if (telefone == "") {
				throw new Exception("Telefone inválido !");
			} else {
				for (Cliente cli: repositorio.getClientes()) {
					if (telefone == cli.getTelefone()) {
						throw new Exception("Telefone já cadastrado !");
					}
				}
			}
			
			// nome
			if (nome == "") {
				throw new Exception("Nome inválido !");
			}
			
			// endereco
			if (endereco == "") {
				throw new Exception("Endereço inválido !");
			}
			
			Cliente cli = new Cliente(telefone, nome, endereco);
			Fachada.repositorio.addCliente(cli);
			return cli;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public Pedido criarPedido(String telefone) {
		try {
			if (telefone == "") {
				throw new Exception("Telefone inválido");
			}
			
			 Cliente cli = null;
			 
			 for (Cliente clie : repositorio.getClientes()) {
				 if (clie.getTelefone() == telefone) {
					 cli = clie;
				 }
			 }
			 
			 if (cli == null) {
				 throw new Exception("Cliente não encontrado.");
			 } 
			 
			 Pedido ped = new Pedido(cli);
			 repositorio.addPedido(ped);
			 
			 return ped;
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public Pedido criarPedido(String telefone, double taxa) {
		try {
			if (telefone == "") {
				throw new Exception("Telefone inválido");
			}
			if (taxa < 0) {
				throw new Exception("Taxa inválida");
			}
			
			 Cliente cli = null;
			 
			 for (Cliente clie : repositorio.getClientes()) {
				 if (clie.getTelefone() == telefone) {
					 cli = clie;
				 }
			 }
			 
			 if (cli == null) {
				 throw new Exception("Cliente não encontrado.");
			 } 
			 
			 Pedido ped = new PedidoExpress(cli, taxa);
			 repositorio.addPedido(ped);
			 
			 return ped;
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public void adicionarProdutoPedido(int idpedido, int idproduto) {
		try {
			Pedido ped = repositorio.buscarPedido(idpedido);
			Produto prod = repositorio.buscarProduto(idproduto);
			if (ped == null) {
				throw new Exception("Pedido não encontrado !");
			} else if (prod == null) {
				throw new Exception("Produto não encontrado !");
			} else {
				ped.addProduto(prod);
			}			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void removerProdutoPedido(int idpedido, int idproduto) {
		try {
			Pedido ped = repositorio.buscarPedido(idpedido);
			Produto prod = repositorio.buscarProduto(idproduto);
			if (ped == null) {
				throw new Exception("Pedido não encontrado !");
			} else if (prod == null) {
				throw new Exception("Produto não encontrado !");
			} else {
				ped.removerProduto(prod);				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Pedido consultarPedido(int idpedido) {
		try {
			Pedido ped = repositorio.buscarPedido(idpedido);
			if (ped != null) {
				return ped;
			} else {
				throw new Exception("Pedido não encontrado !");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public void pagarPedido(int idpedido, String nomeentregador) {
		try {
			if (nomeentregador == "") {
				throw new Exception("Nome inválido para entregador.");
			}
			Pedido ped = repositorio.buscarPedido(idpedido);
			if (ped == null) {
				throw new Exception("Pedido não encontrado !");
			}
			ped.setEntregador(nomeentregador);
			ped.setPago(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void cancelarPedido(int idpedido) {
		try {
			Pedido ped = repositorio.buscarPedido(idpedido);
			if (ped == null) {
				throw new Exception("Pedido não encontrado !");
			}
			
			ped.esvaziar();
			repositorio.cancelarpedido(ped);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public double consultarArrecadacao(int dia) {
		double total = 0;
		for (Pedido ped: repositorio.getPedidos()) {
			if ((ped.getDatahora().getDayOfMonth() == dia) && (ped.isPago())) {
				total += ped.getValortotal();
			}
		}
		return total;
	}
		
	
	public ArrayList<Produto> consultarProdutoTop() {
		ArrayList<Produto> topList = new ArrayList<Produto>();
		Produto produtoTop = null;
		int contadorTop = -1;
		
		for (Produto prod: repositorio.getProdutos()) {
			int contador = 0;
			for (Pedido ped: repositorio.getPedidos()) {
				for (Produto prod2: ped.getProdutos()) {
					if (prod2.equals(prod)) {
						contador += 1;
					}
				}
			}
			if (contador > contadorTop) {
				produtoTop = prod;
				contadorTop = contador;
			}
		}
		topList.add(produtoTop);
		return topList;
	}
}














