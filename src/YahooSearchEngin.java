
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * 
 * @author Dincer Unal, 
 * 		   Student Number: 101180062
 *     	   Gazi Universitesi
 * 
 * description: Arama motoru ekleme islemi.
 * 
 */

@SuppressWarnings("serial")
public class YahooSearchEngin extends JPanel {

	private JButton searchButton;
	private JTextField searchTextFeild;
	private String searchQuery;
	private final String YAHOO_ENGIN = "http://search.yahoo.com/bin/search?p=";
	private Browser jEditorPane;
	
	/**
	 * purpose: Yahoo arama motoru örnegini olusturmak
	 * @param myBrowser
	 */
	
	
	public YahooSearchEngin(Browser myBrowser) {

		jEditorPane = myBrowser;

		setSearchButton();
		setSearchText();
		FlowLayout searchLayout = new FlowLayout();
		this.setLayout(searchLayout);
		this.add(searchButton);
		this.add(searchTextFeild);
		

	}

	/**
	 * Arama motorunun arama metni kismini olusturma
	 * @param void
	 */
	private void setSearchText() {

		searchTextFeild = new JTextField("Yahoo!");
		searchTextFeild.setPreferredSize(new Dimension(150,25));
	}

	/**
	 * Arama butonuna "ActionListener" ekleme .
	 * @param void
	 */
	private void setSearchButton() {

		searchButton = new JButton("Search");

		searchButton.addActionListener(new ActionListener() {

			/**
			 * Metin icerisinde gecerli islemi arama 
			 */
			public void actionPerformed(ActionEvent e) {

				searchQuery = searchTextFeild.getText();

				try {
					
					jEditorPane.setPage((YAHOO_ENGIN + searchQuery));
					jEditorPane.setURL_Field(jEditorPane.getPage().toString());
					jEditorPane.addURL_HisotryList((YAHOO_ENGIN + searchQuery));
		
				} catch (IOException e1) {
					JOptionPane
							.showMessageDialog(jEditorPane.getJFrame(),
									"Cannot deal with your search query, please try again");
				}

			}
		});

		/**
		 * purpose: "search" butonu ikonu düzenleme
		 */
		searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("Search.png")));
		searchButton.setRolloverEnabled(true);
		searchButton.setToolTipText("Search");
		searchButton.setFocusPainted(false);
		searchButton.setContentAreaFilled(false);

	}

}
