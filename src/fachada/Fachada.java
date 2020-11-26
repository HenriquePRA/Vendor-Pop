package fachada;
import modelo.Cliente;
import modelo.Produto;
import modelo.Pedido;
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
	
	
	public void adicionarProdutoPedido(int idpedido, int idproduto) {
		try {
			Pedido ped = repositorio.buscarPedido(idpedido);
			Produto prod = repositorio.buscarProduto(idproduto);
			if (ped == null) {
				throw new Exception("Pedido não encontrado !");
			} else if (prod == null) {
				throw new Exception("Produto não encontrado !");
			} else {
				prod.addPedido(ped);
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
			ped.setPago(true);
			ped.setEntregador(nomeentregador);
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
	
	
	// função para ordenar o hashmap de acordo com os valores
	private static HashMap<Integer, Integer> orderMapa(HashMap<Integer, Integer> hm) {
		// Cria uma lista de elementos do HashMap
        LinkedList<Entry<Integer, Integer>> lista = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
        
        // Ordena a Lista
        Collections.sort(lista, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o2,  Map.Entry<Integer, Integer> o1) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        });
        
       // colocando os dados da lista ordenada no HashMap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : lista) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp;
	}
	
	
	public ArrayList<Produto> consultarProdutoTop() {
		ArrayList<Produto> topList = new ArrayList<Produto>();
		HashMap<Integer, Integer> mapProd = new HashMap<Integer, Integer>();
		
		// contando a quantidade de pedidos feitos para cada produto 
		for (Pedido ped: repositorio.getPedidos()) {
			for (Produto prd: ped.getProdutos()) {
				Integer id = prd.getId();				
				Integer num = mapProd.get(id);
				if (num == null) {
					num = 0;
				}
				mapProd.put(id, num + 1);
			}
		}
		
		// ordenando os produtos
		HashMap<Integer, Integer> mapOrdenado = orderMapa(mapProd);
		
		for (HashMap.Entry<Integer, Integer> mp: mapOrdenado.entrySet()) {
			topList.add(repositorio.buscarProduto(mp.getKey()));
		}
		
		return (ArrayList<Produto>) topList.subList(0, 5);

	}
}














