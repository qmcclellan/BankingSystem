package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.BankDAO;
import Entity.Bank;

public class BankPanel extends JPanel{
	private JLabel bankLabel = new JLabel("Bank");
	
	private JComboBox<Bank> bankBox = new JComboBox<>();
	
	private JButton newBank = new JButton("New Bank");
	private JButton findBank = new JButton("Find Bank");
	private JButton deleteBank = new JButton("Delete Bank");
	
	private BankDAO bdao= new BankDAO();
	
	public BankPanel(JFrame frame) {
		this.setLayout(new GridLayout(6, 2));
		
		this.add(bankLabel);
		this.add(bankBox());
		this.add(newBank());
		this.add(findBank);
		this.add(deleteBank);
		
		this.setVisible(true);
	}
	
	public JComboBox<Bank> bankBox() {
		
		for(Bank bank : bdao.listBanks()) {
			bankBox.addItem(bank);
		}
		
		return bankBox;
	}
	
	public JButton newBank() {
		
		newBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Runnable r = ()->{
					NewBank nb = new NewBank();
					nb.setVisible(true);
				};
				
				r.run();
				
			}
		});
		
		
		return newBank;
	}
	
	public JButton findBank() {
		
		findBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		
		return findBank;
	}
	
	public JButton deleteBank() {
		
		deleteBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		}
		});
		
		return deleteBank;
	}

}
