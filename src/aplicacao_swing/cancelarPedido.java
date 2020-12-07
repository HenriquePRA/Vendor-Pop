package aplicacao_swing;

import fachada.Fachada;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;


public class cancelarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JButton button;
	private JLabel label_1;

	public static void main(String[] args, Fachada fac) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelarPedido frame = new cancelarPedido(fac);
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

	public cancelarPedido(Fachada fac) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Sistema de Vendas - Cancelar Pedido");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(57, 86, 288, 31);
		contentPane.add(textField);
		
		label = new JLabel("ID do Pedido:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(57, 61, 139, 14);
		contentPane.add(label);
		
		button = new JButton("Cancelar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(57, 128, 139, 31);
		contentPane.add(button);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(57, 170, 387, 31);
		contentPane.add(label_1);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText().isEmpty()) {
						throw new Exception("Campo ID do pedido vazio !");
					} else if (!isNumero(textField.getText())) {
						throw new Exception("ID do pedido inválido !");
					} else {
						int idped = Integer.parseInt(textField.getText());
						fac.cancelarPedido(idped);
						label_1.setText("Pedido cancelado com sucesso !");
					}
				} catch (Exception e) {
					label_1.setText(e.getMessage());
				}
			}
		});	
	}
}
