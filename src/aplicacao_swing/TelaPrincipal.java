package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.AplicacaoConsole;
import fachada.Fachada;
import modelo.Prateleira;
import modelo.Produto;

public class TelaPrincipal {
	private JFrame frame;
	private JLabel label;
	private JMenu mnPrateleira;
	private JMenuItem mntmCriar;
	private JMenuItem mntmListar_1;
	private JMenuItem mntmInserirProduto;
	private JMenuItem mntmRemoverProduto;
	@SuppressWarnings("unused")
	private JMenuItem menuItem_2;
	private JMenu mnProduto;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmApagar;
	private JMenuItem mntmListar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Bem Muito Mais");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					new AplicacaoConsole().cadastrar();
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(frame, "at� breve !");
			}
		});

		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//imagem de fundo
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight()); //fundo da janela

		ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/imagem1.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagem);
		frame.getContentPane().add(label);
		frame.setResizable(false);

		//-------------BARRA DE MENU-----------------------------------
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		//-------------MENU-----------------------------------
		mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);

		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroProduto j = new TelaCadastroProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmCadastrar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto;
				ArrayList<Produto> lista = Fachada.listarProdutos();
				texto = "Listagem de produtos: \n";
				if (lista.isEmpty())
					texto += "n�o tem produto cadastrado\n";
				else 	
					for(Produto p: lista) 
						texto +=  p + "\n"; 

				TelaListagem j = new TelaListagem(texto);
				j.setVisible(true);
			}
		});

		mntmApagar = new JMenuItem("Apagar");
		mntmApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaApagarProduto j = new TelaApagarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmApagar);
		mnProduto.add(mntmListar);

		//-------------MENU-----------------------------------
		mnPrateleira = new JMenu("Prateleira");
		menuBar.add(mnPrateleira);

		mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPrateleira j = new TelaCadastroPrateleira();
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmCriar);

		mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Prateleira> lista = Fachada.listarPrateleiras();
				String texto = "Listagem de prateleiras: \n";
				if (lista.isEmpty())
					texto += "n�o tem prateleira cadastrada\n";
				else 
					for(Prateleira p: lista) 
						texto +=  p + "\n"; 
				
				TelaListagem j = new TelaListagem(texto);
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmListar_1);

		mntmInserirProduto = new JMenuItem("Inserir produto");
		mntmInserirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProdutoPrateleira j = new TelaProdutoPrateleira();
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmInserirProduto);

		mntmRemoverProduto = new JMenuItem("Remover produto");
		mntmRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProdutoPrateleira j = new TelaProdutoPrateleira();
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmRemoverProduto);

		//-------------MENU-----------------------------------
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaConsulta j = new TelaConsulta();
				j.setVisible(true);
			}
		});


	}
}
