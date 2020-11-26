package modelo;

public class PedidoExpress extends Pedido{
	private double taxaEntrega;
	public PedidoExpress(Cliente cli, double taxaEntrega) {
		super(cli);
		this.setTaxaEntrega(taxaEntrega);
	}
	
	public double getTaxaEntrega() {
		return taxaEntrega;
	}
	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}
}
