import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * @author Dincer Unal, 
 * 		   Student Number: 101180062
 *     	   Gazi Universitesi
 *     
 *  purpose: Kullanici baglantisini kontrol etme
 *        
 */
public class ActiveHyperLinkListner implements HyperlinkListener {

	private Browser jEditorPane;

	/**
	 * 
	 * @param Browser 'myBrowser'
	 *            
	 */
	public ActiveHyperLinkListner(Browser myBrowser) {

		jEditorPane = myBrowser;

	}
 
	@Override
	
	public void hyperlinkUpdate(HyperlinkEvent e) {

		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				jEditorPane.setURL_Field(e.getURL().toString());
				jEditorPane.setPage(e.getURL());
				jEditorPane.addURL_HisotryList(jEditorPane.getPage().toString());

			} catch (IOException io) {
				JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
						"Input/Output Exception");
			}
		}
	}

}
