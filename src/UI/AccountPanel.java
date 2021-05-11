package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.BankAccountDAO;

public class AccountPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel routeLabel = new JLabel("Routing  Address");
	private JLabel accountLabel = new JLabel("Account Address");
	
	private JTextField routing = new JTextField(20);
	private JTextField account = new JTextField(20);
	
	private JButton newAccount = new JButton("New Account");
	private JButton findAccount = new JButton("Find Account");
	private JButton deleteAccount = new JButton("Delete Account");
	
	private BankAccountDAO baDAO = new BankAccountDAO();
	
	private JFrame frame;
	
	public AccountPanel(JFrame frame) {
		
		this.setLayout(new GridLayout(9,3));
		
		this.add(routeLabel);
		this.add(routing);
		this.add(accountLabel);
		this.add(account);
		this.add(newAccount());
		//this.add(findAccount);
		this.add(deleteAccount());
		
		this.setVisible(true);
		
		this.frame = frame;
	}
	
	public JButton newAccount() {
		
		Runnable r = ()->{
			NewAccount na = new NewAccount();
			
			na.setVisible(true);
		};
		
		newAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				r.run();
				
			}
		});
		
		return newAccount;
	}
	
	public JButton findAccount() {
		
		findAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		return findAccount;
	}
	
	public JButton deleteAccount() {
		deleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int routingNum = Integer.parseInt(routing.getText().trim());
				int accountNum = Integer.parseInt(account.getText().trim());
				
				if((routingNum ==0)||(accountNum ==0)) {
					//add joption pane popup
					
					Runnable r =()->{
						JOptionPane.showMessageDialog(frame,"No Account Found");
				};
				
				r.run();
				}
				baDAO.deleteAccount(accountNum , routingNum);
				
			}
		});
		return deleteAccount;
	}

}
