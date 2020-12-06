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
	public void addProduto(Produto prod) throws Exception {
		if (!pago) {
			produtos.add(prod);
			prod.addPedido(this);
			valortotal += prod.getPreco();
		} else {
			throw new Exception("Não é possível alterar um pedido pago");
		}
	}
	public void removerProduto(Produto prod) throws Exception {
		if (!pago) {
			if (produtos.contains(prod)) {
				prod.removerPedido(this);
				produtos.remove(prod);			
				valortotal -= prod.getPreco();				
			} else {
				throw new Exception("Não é possivel remover do pedido um produto que não está contido nele.");
			}
		} else {
			throw new Exception("Não é possível alterar um pedido pago");
			
		}
	}
	public void esvaziar() throws Exception {
		if (!pago) {
			for (Produto prod : produtos) {
				if (produtos.contains(prod)) {
					prod.removerPedido(this);
				}				
			}
			produtos.clear();
		} else {
			throw new Exception("Não é esvaziar alterar um pedido pago");
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
	public void setEntregador(String nomeentregador) {
		this.entregador = nomeentregador;
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
		// formatação da datahora para dd/mm/aaaa
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dataArrumada = datahora.format(formatador);		
		
		// listagem dos ids dos produtos
		ArrayList<Integer> prods = new ArrayList<Integer>();
		for (Produto prod: produtos) {
			prods.add(prod.getId());
		}
		
		return 	"\nid: " + id +
				"\ntipo: normal" +
				"\ndatahora: " + dataArrumada +
				"\nvalortotal: " + valortotal + 
				"\nentregador: " + entregador +
				"\npago: " + pago +
				"\nprodutos: " + prods +
				"\ncliente: [\n" + "  telefone: " + cliente.getTelefone() +
				"\n  nome: "+ cliente.getNome() +
				"\n  endereco: " + cliente.getEndereco() + "\n]";
	}
}







