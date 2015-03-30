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
 * purpose: Tarayiciyi yönlendirmek icin belirli sayfaya "go" butonnu olusturmak .
 *
 */

@SuppressWarnings("serial")
public class GoButton extends JButton implements ActionListener {

	private String goURL;
	private Browser jEditorPane;

	/**
	 * 
	 * @param Browsers 'myBrowser' 
	 */
	public GoButton(Browser myBrowser) {

		super("Go");
		jEditorPane = myBrowser;
		this.addActionListener(this);
		setGoIcon();

	}

	/*
	 * 
	 */
	public void actionPerformed(ActionEvent e) {

		goURL = jEditorPane.getURlLink().getText();

		if (!checkHTTP(goURL)) {
			goURL = "http://" + goURL;
		}

		try {
			jEditorPane.setURL_Field(goURL);
			jEditorPane.setPage(goURL);
			jEditorPane.addURL_HisotryList(goURL);
			jEditorPane.setURL_Field(goURL);

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Error with link..... Please try different one");
		}
	}

	private boolean checkHTTP(String s) {

		int intIndex = s.indexOf("http://");

		return (intIndex >= 0) ? true : false;

	}

	/**
	 * @param void
	 * "go" butonuna ikon olusturma
	 */
	private void setGoIcon() {

		this.setToolTipText("Go");
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("Go.png")));
		this.setRolloverEnabled(true);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
