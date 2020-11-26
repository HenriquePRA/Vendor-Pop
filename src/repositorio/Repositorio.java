
package repositorio;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import java.util.ArrayList;


public class Repositorio {
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	
	// adicionar ao repositorio
	public void addCliente(Cliente cli) {
		if (!clientes.contains(cli)) {
			this.clientes.add(cli);
		}
	}
	public void addPedido(Pedido ped) {
		if (!pedidos.contains(ped)) {
			this.pedidos.add(ped);
		}
	}
	public void addProduto(Produto prod) {
		if (!produtos.contains(prod)) {
			this.produtos.add(prod);
		}
	}
	
	// remover do repositorio
	public void cancelarpedido(Pedido ped) {
		if (!ped.isPago() && pedidos.contains(ped)) {
			pedidos.remove(ped);
		}
	}
	
	// buscar no repositorio
	public Cliente buscaCliente(String telefone) {	
		for (Cliente cli: clientes) {
				if (cli.getTelefone() == telefone) {
					return cli;
				}
			}
		return null;
	}
	public Produto buscarProduto(int id) {
		for (Produto prod: produtos) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}
	public Pedido buscarPedido(int id) {
		for (Pedido ped: pedidos) {
			if (ped.getId() == id) {
				return ped;
			}
		}
		return null;
	}
	
	
	// retorna as arraylists do repositorio	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}	
}

