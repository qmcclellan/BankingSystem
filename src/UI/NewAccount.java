package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DAO.BankAccountDAO;
import Entity.BankAccount;
import Entity.CheckingAccount;
import Entity.SavingsAccount;

public class NewAccount extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel accountLabel = new JLabel("Account Number");
	
	private JLabel routingLabel = new JLabel("Routing Number");
	
	private JTextField accountNumber = new JTextField(13);
	
	private JTextField routingNumber = new JTextField(13);
	
	private JButton enterButton = new JButton("enter");
	
	private JButton cancelButton = new JButton("cancel");
	
	private JRadioButton checking = new JRadioButton();
	
	private JRadioButton savings = new JRadioButton();
	
	private ButtonGroup bg = new ButtonGroup();
	
	private JFrame frame;
	
	private BankAccountDAO baDAO = new BankAccountDAO();
	
	public NewAccount() {
		
		this.setLayout(new GridLayout(6, 3));
	/*	
		this.add(accountLabel);
		
		this.add(accountNumber);
		
		this.add(routingLabel);
		
		this.add(routingNumber); */
		checking.setText("Checking");
		
		savings.setText("Savings");
		
		this.add(checking);
		
		this.add(savings);
		
		bg.add(checking);
		
		bg.add(savings);
		
		this.add(enterButton());
		
		this.add(cancelButton());
		
		
		
		this.setSize(300, 300);
		
		this.pack();
		
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 
		 this.setVisible(true);
		
	}
	
	public JButton enterButton() {
		
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//gui works need to add balance column to account table
					if(checking.isSelected()) {
						BankAccount ca = new CheckingAccount();
						baDAO.createAccount(ca);
					//	bg.clearSelection();
						NewAccount.this.dispose();
						
					}else if(savings.isSelected()) {
						BankAccount sa = new SavingsAccount();
						baDAO.createAccount(sa);
					//	bg.clearSelection();
						NewAccount.this.dispose();
					}
					JOptionPane.showMessageDialog(frame, "Checking / Savings needs to be selected");
			}
		});
		return enterButton;
	}
	
	public JButton cancelButton() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAccount.this.dispose();
				
			}
		});
		
		return cancelButton;
	}

}
