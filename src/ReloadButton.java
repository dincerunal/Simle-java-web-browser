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
 * purpose: Tarayicida gecerli sayfayi yenileme islemi
 */
@SuppressWarnings("serial")
public class ReloadButton extends JButton implements ActionListener {

	private Browser jEditorPane;
	
	/**
	 * 
	 * @param Browser 'myBrowser' 
	 */
	public ReloadButton(Browser myBrowser) {
		
		super("Refresh");
		jEditorPane = myBrowser;
		myBrowser.getJFrame();
		this.addActionListener(this);
		setReloadIcon();

	}

	/**
	 * Tarayicida yenileme islemini gerceklestirmek.
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			
			jEditorPane.setPage(jEditorPane.getPage().toString());
			jEditorPane.setURL_Field(jEditorPane.getPage().toString());
			jEditorPane.repaint();
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Page Cannot Be Reloaded (Refreshed).");
		}

	}

	/**
	 * "refresh" ikonu olusturma
	 * @param void
	 */
	private void setReloadIcon() {

		
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"refresh.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Reload Page");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
