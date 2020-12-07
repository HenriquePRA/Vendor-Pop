package aplicacao_swing;

import fachada.Fachada;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class alterarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JLabel label_2;
	public static void main(String[] args, Fachada fac) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alterarPedido frame = new alterarPedido(fac);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// checa se uma string pode se tornar um número
	private boolean isNumero(String s) {
	  try {  
	    Double.parseDouble(s);  
	    return true;
	  } catch(NumberFormatException e) {  
	    return false;
	  }
	}

	public alterarPedido(Fachada fac) {
		setTitle("Sistema de Vendas - Alterar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("ID do pedido:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(55, 21, 118, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(55, 43, 321, 31);
		contentPane.add(textField);
		
		label_1 = new JLabel("ID do produto:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(55, 85, 118, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(55, 108, 321, 31);
		contentPane.add(textField_1);
		
		button = new JButton("Adicionar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(55, 162, 154, 31);
		contentPane.add(button);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(55, 204, 389, 31);
		contentPane.add(label_2);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText().isEmpty()) {
						throw new Exception("Campo ID do pedido vazio !");
					} else if (!isNumero(textField.getText())) {
						throw new Exception("ID do pedido inválido !");
					} else if (textField_1.getText().isEmpty()) {
						throw new Exception("Campo ID do produto vazio !");
					} else if (!isNumero(textField_1.getText())) {
						throw new Exception("ID do produto inválido !");
					} else {
						int idped = Integer.parseInt(textField.getText());
						int idprod = Integer.parseInt(textField_1.getText());
						fac.adicionarProdutoPedido(idped, idprod);
						label_2.setText("Produto adicionado ao pedido com sucesso !");
					}
				} catch (Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});	
		
		button_1 = new JButton("Remover");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(219, 162, 157, 31);
		contentPane.add(button_1);
				
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText().isEmpty()) {
						throw new Exception("Campo ID do pedido vazio !");
					} else if (!isNumero(textField.getText())) {
						throw new Exception("ID do pedido inválido !");
					} else if (textField_1.getText().isEmpty()) {
						throw new Exception("Campo ID do produto vazio !");
					} else	if (!isNumero(textField_1.getText())) {
						throw new Exception("ID do produto inválido !");
					} else {
						int idped = Integer.parseInt(textField.getText());
						int idprod = Integer.parseInt(textField_1.getText());
						fac.removerProdutoPedido(idped, idprod);
						label_2.setText("Produto removido do pedido com sucesso !");
					}
				} catch (Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});	
	}
}
