package UI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	private BankPanel bp;
	private UserPanel up;
	private AccountPanel ap;
	
	public MainFrame() {
		
		JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP);
		
		jtp.add( "Bank", bp = new BankPanel(this));
		jtp.add( "User", up = new UserPanel(this));
		jtp.add( "Account", ap = new AccountPanel(this));
		
		this.add(jtp);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setSize(900,900);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}

}
