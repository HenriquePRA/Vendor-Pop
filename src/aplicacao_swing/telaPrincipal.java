package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aplicacao_console.AplicacaoConsole;
import fachada.Fachada;


public class telaPrincipal {
	private JFrame frame;
	private JLabel label;
	private Fachada fachada;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal window = new telaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Sistema de Vendas");
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  realização dos testes iniciais
					AplicacaoConsole testes = new AplicacaoConsole();
					fachada = testes.getFachada();
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		});
		
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// label com imagem de fundo
		label = new JLabel("");
		label.setBounds(0, -22, 434, 282);		
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/lanchonete.jpg")); 
		icon = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));		
		label.setIcon(icon);						
		frame.getContentPane().add(label);
		
		// ################# barra de menu ################# //
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		// item criar
		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criarPedido cp = new criarPedido(fachada);
				cp.setVisible(true);
			}
		});
		mnPedido.add(mntmCriar);

		// item pagar
		JMenuItem mntmPagar = new JMenuItem("Pagar");
		mntmPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pagarPedido pg = new pagarPedido(fachada);
				pg.setVisible(true);
			}
		});
		mnPedido.add(mntmPagar);

		// item alterar
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarPedido ap = new alterarPedido(fachada);
				ap.setVisible(true);
			}
		});
		mnPedido.add(mntmAlterar);
		
		// item cancelar
		JMenuItem mntmCancelar = new JMenuItem("Cancelar");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarPedido cc = new cancelarPedido(fachada);
				cc.setVisible(true);
			}
		});
		mnPedido.add(mntmCancelar);
		

		// menu listagem
		JMenu mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);


		JMenuItem mntmLsProdutos = new JMenuItem("Produtos");
		mntmLsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_1 = new telaListagem(fachada, 1);
				tl_1.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsProdutos);
		
		
		JMenuItem mntmLsClientes = new JMenuItem("Clientes");
		mntmLsClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_2 = new telaListagem(fachada, 2);
				tl_2.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsClientes);
		
		
		JMenuItem mntmLsPedClientes = new JMenuItem("Pedidos");
		mntmLsPedClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_3 = new telaListagem(fachada, 3);
				tl_3.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsPedClientes);
		
		JMenuItem mntmLsPedCliente = new JMenuItem("Pedidos do Cliente");
		mntmLsPedCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_4 = new telaListagem(fachada, 4);
				tl_4.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsPedCliente);
		
		JMenuItem mntmLsPedPagoCliente = new JMenuItem("Pedidos pagos do Cliente");
		mntmLsPedPagoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_5 = new telaListagem(fachada, 5);
				tl_5.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsPedPagoCliente);
		
		JMenuItem mntmLsPedNaoPagoCliente = new JMenuItem("Pedidos não pagos do Cliente");
		mntmLsPedNaoPagoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_6 = new telaListagem(fachada, 6);
				tl_6.setVisible(true);
			}
		});		
		mnListagem.add(mntmLsPedNaoPagoCliente);
		
		JMenuItem mntmProdutosTop = new JMenuItem("Produtos Top");
		mntmProdutosTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_7 = new telaListagem(fachada, 7);
				tl_7.setVisible(true);
			}
		});		
		mnListagem.add(mntmProdutosTop);
		
		JMenuItem mntmArrecadacao = new JMenuItem("Arrecadação");
		mntmArrecadacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaListagem tl_8 = new telaListagem(fachada, 8);
				tl_8.setVisible(true);
			}
		});		
		mnListagem.add(mntmArrecadacao);
	}
}
