import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 
 * @author Dincer Unal, 
 * 		   Student Number: 101180062
 *     	   Gazi Universitesi
 *     
 * 
 * purpose: Tarayicida "forward" butonu olusturma 
 * 
 */

public class ForwardButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8404442305936377464L;
	
	
	private Browser jEditorPane;
	
	/**
	 * 
	 * @param Browser 'myBrowser'
	 */
	public ForwardButton(Browser myBrowser) {
		
		super("Forward");
		jEditorPane = myBrowser;
		this.addActionListener(this);
		setForwardButton();
	}

	private void setForwardButton() {

		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Forward.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Forward");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

	/**
	 * "forward" butonuna tiklandiginda ileri gitme islemi
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			int temp = jEditorPane.getHistoryCounterForth();
			String url = jEditorPane.getURL_HisotryList().get(temp);
			jEditorPane.setPage(url);
			jEditorPane.setURL_Field(url);

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(), "Can not go forward further...");
		}
		
		

	}


}
