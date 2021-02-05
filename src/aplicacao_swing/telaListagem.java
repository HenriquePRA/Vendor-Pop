package aplicacao_swing;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.JScrollPane;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class telaListagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scroll;
	private JTextPane textPane;
	private JLabel label;

	public static void main(String[] args, Fachada fac, Integer chave) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaListagem frame = new telaListagem(fac, chave);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telaListagem(Fachada fac, Integer chave) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scroll = new JScrollPane((Component) null);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0, 0, 434, 213);
		
		label = new JLabel("");
		label.setBounds(10, 227, 424, 14);
		contentPane.add(label);				
		textPane = new JTextPane();
	
		if (chave == 6) {
			try {
				String id = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
		
				ArrayList<Pedido> ped = fac.listarPedidos(id, 2);
				String str = "";
				for (Pedido ped2: ped) {
					str += ped2 + "\n";
				}
				textPane.setText(str);
				label.setText("");
			} catch (Exception e) {
				label.setText(e.getMessage());
			}
		} else if (chave == 5) {
			try {
				String id = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
		
				ArrayList<Pedido> ped = fac.listarPedidos(id, 1);
				String str = "";
				for (Pedido ped2: ped) {
					str += ped2 + "\n";
				}
				textPane.setText(str);
				label.setText("");
			} catch (Exception e) {
				label.setText(e.getMessage());
			}
		} else if (chave == 4) {
			try {
				String id = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
		
				ArrayList<Pedido> ped = fac.listarPedidos(id, 3);
				String str = "";
				for (Pedido ped2: ped) {
					str += ped2 + "\n";
				}
				textPane.setText(str);
				label.setText("");
			} catch (Exception e) {
				label.setText(e.getMessage());
			}
		} else if (chave == 3) {
			setTitle("Sistema de Vendas - listagem de Pedidos");
			ArrayList<Pedido> ped = fac.listarPedidos();
			String str = "";
			for (Pedido ped2: ped) {
				str += ped2 + "\n";
			}
			label.setText("");
			textPane.setText(str);			
		} else if (chave == 2) {
			setTitle("Sistema de Vendas - listagem de Clientes");
			ArrayList<Cliente> cli = fac.listarClientes();
			String str = "";
			for (Cliente cli2: cli) {
				str += cli2 + "\n";
			}
			label.setText("");
			textPane.setText(str);			
		} else {
			setTitle("Sistema de Vendas - listagem de Produtos");
			ArrayList<Produto> pro = fac.listarProdutos("");
			String str = "";
			for (Produto pro2: pro) {
				str += pro2 + "\n";
			}
			label.setText("");
			textPane.setText(str);
		}
		
		contentPane.add(scroll);		
		
		scroll.setViewportView(textPane);
	}
}
