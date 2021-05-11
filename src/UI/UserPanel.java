package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPanel extends JPanel{
	
	private JTextField input = new JTextField(20);
	
	private JButton newUser = new JButton("Create User");
	
	private JButton findUser = new JButton("Find User");
	
	private JButton deleteUser = new JButton("Delete User");
	
	
	public UserPanel(JFrame frame) {
		this.setLayout(new GridLayout(4,4));
		
		this.add(input);
		
		this.add(newButton());
		
		this.add(findUser);
		
		this.add(deleteUser);
	
		this.setVisible(true);
		
	}
	
	public JButton newButton() {
		
		Runnable r = ()->{
			NewUser nu = new NewUser();
			
			nu.setVisible(true);
		};
		
		newUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				r.run();
				
			}
		});
		
		return newUser;
	}
	
	public JButton findButton() {
		
		findUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		return findUser;
		
	}
	
	public JButton deleteButton() {
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return deleteUser;
	}
	
	
	
	

}
