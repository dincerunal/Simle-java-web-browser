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
 * purpose: Tarayicida "back" islemi için  buton olusturmak
 * 
 */


public class BackwardButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352227016934312497L;

	private Browser jEditorPane;
	
	/**
	 * "back" butonu yaratildi. "Browser" class'i referans edildi.
	 *  
	 * @param Browser myBrowser
	 */
	public BackwardButton(Browser myB) {

		super("Back");
		jEditorPane = myB;
		this.addActionListener(this);
		setBackwardButton();
	}

	/**
	 * @param void
	 * "back" butonu ozellikleri.
	 * 
	 */
	private void setBackwardButton() {

		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Backward.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Go Back");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}
	/**
	 * "back" butonu tiklandiginda bir önceki sayfaya git
	 *  
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			int temp = jEditorPane.getHistoryCounterBack();
			String url = jEditorPane.getURL_HisotryList().get(temp);
			jEditorPane.setPage(url);
			jEditorPane.setURL_Field(url);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Can not go back further...");
		}
	}

}
