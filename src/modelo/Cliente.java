package modelo;

import java.util.ArrayList;

public class Cliente {
	private String telefone;
	private String nome;
	private String endereco;
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public Cliente(String telefone, String nome, String endereco) {
		this.telefone = telefone;
		this.nome = nome;
		this.endereco = endereco;
	}

	// Adicionar ou remover pedidos
	public void addPedidos(Pedido ped) {
		this.pedidos.add(ped);
	}
	public void removerPedidos(Pedido ped) {
		if (pedidos.contains(ped) && !ped.isPago()) {
			
			// para cada produto no pedido, 
			// remove o pedido da lista do produto
			for (Produto prod: ped.getProdutos()) {
				prod.removerPedido(ped);
			}
			// remocao do pedido
			pedidos.remove(ped);
		}
	}
	
	// Getters
	public String getTelefone() {
		return telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	// Setters
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		
		String strPedidos = "";
			
		for (Pedido ped: pedidos) {
			strPedidos += ped.toString();
		}
		
		if (strPedidos == "") {
			strPedidos += " Nenhum pedido realizado !";
		} else {
			strPedidos += "\n  |-------------------------------|\n";
		}
		
		return 	"\n Nome: " + nome + 
				"\n Telefone: " + telefone +
				"\n Endereço: " + endereco + "\n";
	}	
}
