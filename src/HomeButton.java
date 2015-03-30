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
 * purpose: Tarayiciyi anasayfa ekranina yönlendirme islemi
 */

@SuppressWarnings("serial")
public class HomeButton extends JButton implements ActionListener {

	private Browser jEditorPane;
	
	/**
	 * 
	 * @param Tarayiciya parametre alma.
	 */
	public HomeButton(Browser myBrowser) {

		super("Home");
		jEditorPane = myBrowser;
		setHomeIcon();
		this.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		try {

			jEditorPane.setURL_Field(jEditorPane.getHomePage());
			jEditorPane.setPage(jEditorPane.getHomePage());
			jEditorPane.addURL_HisotryList(jEditorPane.getHomePage());

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Problem, Can not be redircted to home page.");
		}
	}

	/**
	 * @param void
	 * "home" ikonu olusturma.
	 */
	private void setHomeIcon() {


		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Home.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Home Button");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
