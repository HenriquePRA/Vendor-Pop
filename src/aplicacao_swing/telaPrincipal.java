package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class telaPrincipal {
	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public telaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		// ----------- barra de menu --------------- //
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// menu Pedido
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnPedido.add(mntmCriar);

		JMenuItem mntmPagar = new JMenuItem("Pagar");
		mntmPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnPedido.add(mntmPagar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnPedido.add(mntmAlterar);
		
		JMenuItem mntmCancelar = new JMenuItem("Cancelar");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		mnPedido.add(mntmCancelar);
		

		// menu listagem
		JMenu mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);


		JMenuItem mntmLsProdutos = new JMenuItem("Produtos");
		mntmLsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		mnListagem.add(mntmLsProdutos);
		
		
		JMenuItem mntmLsClientes = new JMenuItem("Clientes");
		mntmLsClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		mnListagem.add(mntmLsClientes);
		
		
		JMenuItem mntmLsPedClientes = new JMenuItem("Pedidos do cliente");
		mntmLsPedClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		mnListagem.add(mntmLsPedClientes);
		
		
		JMenuItem mntmLsPedPagoCli = new JMenuItem("Pedidos pagos do cliente");
		mntmLsPedPagoCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		mnListagem.add(mntmLsPedPagoCli);
		
		
		JMenuItem mntmLsPedNaoPagoCli = new JMenuItem("Pedidos não pagos do cliente");
		mntmLsPedNaoPagoCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
		mnListagem.add(mntmLsPedNaoPagoCli);
		
		
	}
}
