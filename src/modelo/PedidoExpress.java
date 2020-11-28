package modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
		// formatação da datahora para dd/mm/aaaa
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String dataArrumada = this.getDatahora().format(formatador);		
		
		// listagem dos ids dos produtos
		ArrayList<Integer> prods = new ArrayList<Integer>();
		for (Produto prod: this.getProdutos()) {
			prods.add(prod.getId());
		}
		
		return 	"\nid: " + this.getId() +
				"\ntipo: express" +
				"\ndatahora: " + dataArrumada +
				"\nvalortotal: " + this.getValortotal() + 
				"\nentregador: " + this.getEntregador() +
				"\npago: " + this.isPago() +
				"\nprodutos: " + prods +
				"\ncliente: [\n" + "  telefone: " + this.getCliente().getTelefone() +
				"\n  nome: "+ this.getCliente().getNome() +
				"\n  endereco: " + this.getCliente().getEndereco() + "\n]";
				
				
				
	}
}
