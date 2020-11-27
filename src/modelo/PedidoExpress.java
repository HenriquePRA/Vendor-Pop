package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PedidoExpress extends Pedido{
	private double taxaEntrega;
	public PedidoExpress(Cliente cli, double taxaEntrega) {
		super(cli);
		this.setTaxaEntrega(taxaEntrega);
		this.setValortotal(this.getValortotal() + taxaEntrega);
	}
	
	public double getTaxaEntrega() {
		return taxaEntrega;
	}
	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}
	
	@Override
	public String toString() {
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dataArrumada = agora.format(formatador);		
		
		
		String strProdutos = "\n";
		for (Produto prod : this.getProdutos()) {
			strProdutos += "\n     * " + prod.getNome() + ": " + prod.getPreco() +" $";
		}
		
		return "\n  |-------------------------------|\n" +
				"\n   id: " + this.getId() +
				"\n   Tipo: EXPRESS" +
				"\n   DataHora: " + dataArrumada +
				"\n   Entregador: " + this.getEntregador() +
				"\n   Cliente: " + this.getCliente().getNome() +
				"\n   Produtos: " +  strProdutos +
				"\n\n   ValorTotal: " + this.getValortotal() + " $" +
				"\n   Pago: " + (this.isPago() ? "Sim" : "Não") + "\n";
	}
}
