package aplicacao_swing;

import fachada.Fachada;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class pagarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JButton button;
	private JLabel label_2;

	public static void main(String[] args, Fachada fac) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagarPedido frame = new pagarPedido(fac);
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

	public pagarPedido(Fachada fac) {
		setTitle("Sistema de Vendas - Pagar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("ID do pedido:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(47, 36, 118, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(47, 58, 321, 31);
		contentPane.add(textField);
		
		label_1 = new JLabel("Nome do Entregador");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(47, 100, 138, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(47, 123, 321, 31);
		contentPane.add(textField_1);
		
		button = new JButton("Pagar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(47, 165, 154, 31);
		contentPane.add(button);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(47, 207, 386, 31);
		contentPane.add(label_2);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText().isEmpty()) {
						throw new Exception("Campo ID do pedido vazio !");
					} else if (!isNumero(textField.getText())) {
						throw new Exception("ID do pedido inválido !");
					} else {
						int idped = Integer.parseInt(textField.getText());
						fac.pagarPedido(idped, textField_1.getText());
						label_2.setText("Pedido pago com sucesso !");
					}
				} catch (Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});	
	}

}
