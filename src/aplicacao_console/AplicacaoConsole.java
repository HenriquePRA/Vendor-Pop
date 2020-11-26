package aplicacao_console;

import java.util.ArrayList;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;

public class AplicacaoConsole {
	public static void main(String[] args) {
		Fachada fachada = new Fachada();
		
		System.out.println("\n|######################################|\n"
						   + "|######## Cadastrando Clientes ########|\n"
						   + "|######################################|");
		System.out.println
		(fachada.cadastrarCliente("81476369", "Jose",  "Rua dos Pescadores 15"));
		System.out.println
		(fachada.cadastrarCliente("98541569", "Maria", "Avenida jose filho 123"));
		System.out.println
		(fachada.cadastrarCliente("81234756", "Lucia", "Rua Instituto Elo 7"));
		System.out.println
		(fachada.cadastrarCliente("91165001", "Adamastor", "Avenida Presidente Medici 255"));
		System.out.println
		(fachada.cadastrarCliente("88900255", "Henrique", "Avenida primeiro de maio 200"));
		
		System.out.println("\n|######################################|\n"
						   + "|######## Cadastrando Produtos ########|\n"
						   + "|######################################|");
		
		System.out.println(fachada.cadastrarProduo("Sanduiche de frango", 4.5));
		System.out.println(fachada.cadastrarProduo("Sanduiche de Presunto", 4));
		System.out.println(fachada.cadastrarProduo("Hamburger", 5.2));
		System.out.println(fachada.cadastrarProduo("Salgado", 3));
		System.out.println(fachada.cadastrarProduo("Refrigerante", 6));
		
		Cliente cle = fachada.cadastrarCliente("111111111", "Jose",  "Rua dos Pescadores 15");
		ArrayList<Pedido> pedd = new ArrayList<>();
		
		PedidoExpress pedExp = new PedidoExpress(cle, 10);
		pedd.add(pedExp);
	}
}
