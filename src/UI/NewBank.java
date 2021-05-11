package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.BankDAO;
import Entity.Bank;

public class NewBank extends JFrame{
	
	private JLabel bankLabel = new JLabel("Bank Name");
	
	private JTextField bank = new JTextField(20);
	
	private JButton enter = new JButton("Enter");
	
	private JButton cancel = new JButton("Cancel");
	
	private BankDAO bdao = new BankDAO();
	
	public NewBank() {
		
		this.setLayout(new GridLayout(4,1));
		
		this.add(bankLabel);
		this.add(bank);
		this.add(enterButton());
		this.add(cancelButton(this));
		
		
		this.setSize(300,300);
		this.pack();
		this.setVisible(true);
		
	}
	
	public JButton enterButton() {
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bank.getText().trim().length() > 0) {
					Bank nb = new Bank(bank.getText());
					bdao.addBank(nb);
					
					bank.setText("");
				}
				
			}

		});
		
		return enter;
	}
	
	public JButton cancelButton(JFrame frame) {
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			
		});
		return cancel;
	}
	

}
