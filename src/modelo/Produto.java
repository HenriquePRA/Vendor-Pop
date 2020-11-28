package modelo;
import java.util.ArrayList;


public class Produto {
		private static int contador;
		private int id;
		private String nome;
		private double preco;
		private ArrayList<Pedido> pedidos = new ArrayList<>();
		
		public Produto(String nome,  double preco) {
			Produto.contador++;
			this.id = contador;
			this.nome = nome;
			this.preco = preco;
		}
		
		// Adicionar ou remover Pedidos
		public void addPedido(Pedido ped) {
			if (!ped.isPago()) {
				pedidos.add(ped);
			}
		}
		public void removerPedido(Pedido ped) {
			if (pedidos.contains(ped) && !ped.isPago()) {
				pedidos.remove(ped);
			}
		}

		
		// Getters
		public int getId() {
			return id;
		}		
		public String getNome() {
			return nome;
		}
		public double getPreco() {
			return preco;
		}
		public ArrayList<Pedido> getPedidos() {
			return pedidos;
		}
		
		
		// Setters
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}

		@Override
		public String toString() {
			ArrayList<Integer> pedds = new ArrayList<Integer>();
			for (Pedido ped: this.pedidos) {
				pedds.add(ped.getId());
			}
			return "\nid: " + id + 
				   "\nnome: "+ nome +
				   "\npreco: " + preco +
				   "\nids dos pedidos relacionados:\n" + pedds + "\n";
		}
}
