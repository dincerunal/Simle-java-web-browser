import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class BrowserMenu extends JMenuBar {

	
	private static final long serialVersionUID = -3841477989697919287L;
	
	private Browser jEditorPane;
	public BrowserMenu(Browser myB){
		jEditorPane = myB;
		creatMenuBar();
	}

	private void creatMenuBar() {


		JMenu file = new JMenu("File");
		this.add(file);
		JMenuItem newWindow = new JMenuItem("New Window",KeyEvent.VK_N);
		KeyStroke newWindKeyStroke = KeyStroke.getKeyStroke("control N");
		newWindow.setAccelerator(newWindKeyStroke);

		JMenuItem closeWindow = new JMenuItem("Exit", KeyEvent.VK_N);
		KeyStroke closeKeyStroke = KeyStroke.getKeyStroke("control X");
		closeWindow.setAccelerator(closeKeyStroke);

		file.add(newWindow);
		file.add(new JSeparator());
		file.add(closeWindow);

		JMenu help = new JMenu("Help");
		this.add(help);
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_N);
		KeyStroke aboutKeyStroke = KeyStroke.getKeyStroke("alt A");
		about.setAccelerator(aboutKeyStroke);
		help.add(about);


		closeWindow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				//Onaylama
				int confirmation = JOptionPane.showConfirmDialog(jEditorPane.getJFrame(), 
						"is closed", "Confirm!", 
						JOptionPane.YES_NO_OPTION); 

				//Kapatma 
				if (confirmation == JOptionPane.YES_OPTION) 
				{                             
					//Gecerli pencere kapanir.
					jEditorPane.getJFrame().dispose(); 
				} 

			}	
		});

		newWindow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unused")
				Browser newBrowser = new Browser();
			}	
		});

		about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
						"Dincer Unal." +
								"\nGazi Universitesi - Bilgisayar Mühendisligi " +
								"\ndincer.unal0652@gmail.com." +
								"\nOgrenci No: 101180062",
								"Hakkinda!!",
								JOptionPane.PLAIN_MESSAGE);
			}	
		});

	}
}