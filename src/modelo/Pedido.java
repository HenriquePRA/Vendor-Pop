package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {
	private static int contador;
	private int id;
	private LocalDateTime datahora;
	private double valortotal;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido(Cliente cliente) {
		Pedido.contador++;
		cliente.addPedidos(this);
		this.id = contador;
		this.cliente = cliente;
		this.datahora = LocalDateTime.now();
	}	

	
	// Adicionar ou Remover produtos
	public void addProduto(Produto prod) {
		try {
			if (!pago) {
				produtos.add(prod);
				prod.addPedido(this);
				valortotal += prod.getPreco();
			} else {
				throw new Exception("Não é possível alterar um pedido pago");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void removerProduto(Produto prod) {
		try {
			if (produtos.contains(prod) && !pago) {
				prod.removerPedido(this);
				produtos.remove(prod);			
				valortotal -= prod.getPreco();
			} else {
				throw new Exception("Não é possível alterar um pedido pago");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void esvaziar() {
		try {
			if (!pago) {
				for (Produto prod : produtos) {
					if (produtos.contains(prod)) {
						prod.removerPedido(this);
					}				
				}
				produtos.clear();
			} else {
				throw new Exception("Não é possível alterar um pedido pago");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	// Getters
	public int getId() {
		return id;
	}
	public LocalDateTime getDatahora() {
		return datahora;
	}
	public double getValortotal() {
		return valortotal;
	}
	public String getEntregador() {
		return entregador;
	}
	public boolean isPago() {
		return pago;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	@Override
	public String toString() {
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dataArrumada = agora.format(formatador);		
		
		String strEntregador = null;
		if (entregador == null) {
			strEntregador = "Não definido";
		}
		
		String strProdutos = "\n";
		for (Produto prod : produtos) {
			strProdutos += "\n     * " + prod.getNome() + ": " + prod.getPreco() +" $";
		}
		
		return "\n  |-------------------------------|\n" +
				"\n   id: " + id +
				"\n   DataHora: " + dataArrumada +
				"\n   Entregador: " + strEntregador +
				"\n   Cliente: " + cliente.getNome() +
				"\n   Produtos: " +  strProdutos +
				"\n\n   ValorTotal: " + valortotal + " $" +
				"\n   Pago: " + (pago ? "Sim" : "Não") + "\n";
	}
}







