import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * 
 * @author Dincer Unal, 
 * 		   Student Number: 101180062
 *     	   Gazi Universitesi
 * 
 * purpose : Butun class lari barindirir ve implemet eder. 
 * 			 JEditor Pane 'e uzanan Temel HTML sayfalarini icerir.
 *
 */


public class Browser extends JEditorPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6030691123934444964L;
	
	private String homePageURL; 
	private JFrame webFrame;
	private JTextField urlLinkTextField;
	private ActiveHyperLinkListner hyperListner;
	private ArrayList<String> urlHistoryList;
	private int url_HistoryIndex;

	/**
	 * Anasayfasi "http://gazi.edu.tr/" olan Browser yaratildi. 
	 * 
	 */
	public Browser() {

		homePageURL = "http://gazi.edu.tr/";
		urlLinkTextField = new JTextField(homePageURL);
		urlHistoryList = new ArrayList<String>();
		iniatBrowser();
	}

	/**
	 * Belirtilen anasayfa ile browser yaratildi. 
	 * 
	 */
	public Browser(String url) throws IOException {
		super(url);
		urlLinkTextField = new JTextField(homePageURL);
		homePageURL = url;
		iniatBrowser();

	}

	/**
	 * @param void
	 * 
	 * WebFrame olan JFrame'in "main body" si olusturuldu.
	 * 
	 */
	void iniatBrowser() {

		// Web Frame olusturuldu.
		webFrame = new JFrame("Dincer Unal: Simple Java Broswer");
		setJFrameIcon();
		setMenuBar();
		webFrame.setLayout(new BorderLayout());

		JPanel webPanel = getWebPanel();

		// Browser da iki adet "main area" olusturuldu.
		JPanel northPanel = getNorthPanel();

		webFrame.add(webPanel, BorderLayout.CENTER);
		webFrame.add(northPanel, BorderLayout.NORTH);

		webFrame.getContentPane();

		webFrame.pack();
		webFrame.setSize(1170, 610);
		webFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		webFrame.setVisible(true);

	}

	/**
	 * Bu panel JFrame "nort" tarafinda eklenecek 
	 * tüm buton ve arama motoru yer alacak.
	 * 
	 * @param  void
	 * @return JPanel 
	 */
	private JPanel getNorthPanel() {

		JPanel north = new JPanel();
		JPanel northWest = new JPanel();
		JPanel northEast = new JPanel();

		FlowLayout northWestLayout = new FlowLayout();
		north.setSize(new Dimension(200, 10));

		north.setLayout(northWestLayout);
		northWest.setLayout(northWestLayout);
		northEast.setLayout(northWestLayout);

		HomeButton homePageButton = new HomeButton(this);
		GoButton goButton = new GoButton(this);
		ReloadButton refresh = new ReloadButton(this);
		YahooSearchEngin temp = new YahooSearchEngin(this);
		BackwardButton backButton = new BackwardButton(this);
		ForwardButton frothButton = new ForwardButton(this);
		urlLinkTextField.setPreferredSize(new Dimension(300, 25));
		urlLinkTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				setpage(urlLinkTextField.getText());
			}

		});
		north.add(northWest, BorderLayout.WEST);
		north.add(northEast, BorderLayout.EAST);

		northWest.add(homePageButton);
		northWest.add(backButton);
		northWest.add(frothButton);
		northWest.add(refresh);
		northWest.add(goButton);
		northWest.add(urlLinkTextField);
		northEast.add(temp);

		return north;

	}

	/**
	 *  
	 * Jpanel' e donmek icin JFrame'in "centre" tarafinda eklenecek.
	 * 
	 * @param  void
	 * @return JPanel 
	 */
	private JPanel getWebPanel() {

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());

		this.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(this);
		center.add(scrollPane, BorderLayout.CENTER);
		hyperListner = new ActiveHyperLinkListner(this);
		this.addHyperlinkListener(hyperListner);
		setpage(getHomePage());
		return center;
	}

	/**
	 * Alinan String URL i browser sayfasini ayarlar.
	 * 
	 * @param url
	 */
	private void setpage(String url){

		try {
			setURL_Field(url);
			this.setPage(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		addURL_HisotryList(this.getPage().toString());
	}

	/**
	 * JFrame in ikonunu ayarlar.
	 * 
	 */
	private void setJFrameIcon() {

		webFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("JFrameIcon.png")));

	}
	/**
	 * Belirli sayfaya URL metin alani ayarlar.
	 * 
	 * @param newUrl
	 */
	public void setURL_Field(String newUrl) {
		urlLinkTextField.setText(newUrl);
	}

	/**
	 * Anasayfaya dönmek icin baska sinif tarafindan kullanilir.
	 * @return String homePageURL
	 */
	public String getHomePage() {

		return homePageURL;
	}

	/**
	 * "back" butonu islevi ile indirilen sayfanin tarih sayaci ile geriye doner
	 * 
	 * @return integer history counter
	 */
	public int getHistoryCounterBack() {

		url_HistoryIndex--;
		if (url_HistoryIndex < 0){
			url_HistoryIndex = 0;
		}
		return url_HistoryIndex;

	}

	/**
	 * "forward" butonu islevi ile gecmis tarih sayaci artirilir
	 * 
	 * @return History Counter
	 */
	 
	public int getHistoryCounterForth() {

		url_HistoryIndex++;
		if (url_HistoryIndex >= urlHistoryList.size()){
			url_HistoryIndex = urlHistoryList.size()-1;
		}
		return url_HistoryIndex;

	}

	/**
	 * 
	 * @return JFrame
	 */
	public JFrame getJFrame() {

		return webFrame;
	}

	/**
	 * URL alanina dönmek icin
	 * @return urlLink 
	 */
	public JTextField getURlLink() {

		return urlLinkTextField;

	}

	/**
	 * Browser gecmis listesi icin 
	 * @return urlHistoryList 
	 */
	public ArrayList<String> getURL_HisotryList() {

		return urlHistoryList;
	}

	/**
	 * 
	 * Gecmis listesine yeni browser sayfasi eklenir
	 * 
	 * @param element 
	 */
	public void addURL_HisotryList(String elem) {

		urlHistoryList.add(elem);
		url_HistoryIndex = urlHistoryList.size()-1;

	}
	
	/**
	 * Frame' e menu bar eklenir.
	 * 
	 */
	private void setMenuBar(){
		
		BrowserMenu menuBar = new BrowserMenu(this);
		webFrame.setJMenuBar(menuBar);
	}

}
