package aplicacao_swing;

import fachada.Fachada;
import modelo.Pedido;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class criarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JLabel label;
	private JButton button_1;
	private JLabel label_1;

	/** Launch the application. **/
	public static void main(String[] args, Fachada fac) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					criarPedido frame = new criarPedido(fac);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the frame **/
	public criarPedido(Fachada fac) {
		setTitle("Sistema de Vendas - Cadastrar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label = new JLabel("Telefone:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(48, 56, 139, 14);
		contentPane.add(label);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(48, 81, 288, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		// campo de exibição de mensagem
		label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(48, 165, 386, 31);
		contentPane.add(label_1);		
		
		// criação de pedido normal
		button = new JButton("Pedido Normal");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(48, 123, 139, 31);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pedido ped = fac.criarPedido(textField.getText());
					if (ped != null) {
						label_1.setText("ID do pedido cadastrado: " + ped.getId());
					}					
					
				} catch (Exception e) {
					label_1.setText(e.getMessage());
				}
			}
		});		
		
		// criação de pedido express
		button_1 = new JButton("Pedido Express");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(197, 123, 139, 31);
		contentPane.add(button_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Pedido ped = fac.criarPedidoExpress(textField.getText(), 10);
					if (ped != null) {
						label_1.setText("ID do pedido cadastrado: " + ped.getId());
					}
					
				} catch (Exception e) {
					label_1.setText(e.getMessage());
				}
			}
		});	
		
		
	}
}
