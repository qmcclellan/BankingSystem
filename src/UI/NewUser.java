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

import DAO.UserDAO;
import Entity.Customer;
import Entity.Employee;
import Entity.User;

public class NewUser extends JFrame{
	
	private JLabel fLabel = new JLabel("First Name");
	private JLabel lLabel = new JLabel("Last Name");
	private JLabel emailLabel = new JLabel("Email");
	private JLabel pinLabel = new JLabel("Pin");
	private JTextField fName = new JTextField(20);
	private JTextField lName = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JTextField pin = new JTextField(20);
	
	private JButton enter = new JButton("Enter");
	private JButton cancel = new JButton("Cancel");
	
	private JRadioButton employee = new JRadioButton("Employee");
	private JRadioButton customer = new JRadioButton("Customer");
	
	private ButtonGroup bg = new ButtonGroup();
	
	
	
	private UserDAO uDAO = new UserDAO();
	
	public NewUser() {
		
		this.setLayout(new GridLayout(10,2));
		
		this.add(fLabel);
		this.add(fName);
		this.add(lLabel);
		this.add(lName);
		this.add(emailLabel);
		this.add(email);
		this.add(pinLabel);
		this.add(pin);
		
		this.add(employee);
		this.add(customer);
		
		this.bg.add(employee);
		this.bg.add(customer);
		
		this.add(enterButton());
		this.add(cancelButton());
		
		this.setSize(500,500);
		this.pack();
		this.setVisible(true);
	}
	
	public JButton enterButton() {
		
		
		
	
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  first = fName.getText().trim();
				String last = lName.getText().trim();
				String emailIn = email.getText().trim();
				int pinNum = Integer.parseInt(pin.getText().trim());
				
				
				if((first.isEmpty())|| (last.isEmpty())||(emailIn.isEmpty()) == true) {
					
					JOptionPane.showMessageDialog(NewUser.this,"Must Fill In All Fields");
				
				}else if(pinNum == 0) {
					JOptionPane.showMessageDialog(NewUser.this,"Must Change Pin");
					
				}
				if(customer.isSelected()) {
					User customer = new Customer(first, last, emailIn, pinNum);
					
					uDAO.addUser(customer);
					
				}else if(employee.isSelected()) {
					User employee = new Employee(first, last, emailIn, pinNum);
					
					uDAO.addUser(employee);
				}
				
			//	JOptionPane.showMessageDialog(NewUser.this,"Must Fill In All Fields");
			}
				
		});
		
		return enter;
	}
	
	public JButton cancelButton() {
		
		cancel.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				NewUser.this.dispose();
			}
		});
		return cancel;
	}

}
