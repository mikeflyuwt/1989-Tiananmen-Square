package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import insides.Version;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class GUIAbout extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIAbout dialog = new GUIAbout();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIAbout() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout());
		
		
		
		JLabel lblDevelopedByDylan = new JLabel("Developed By Dylan Hill, Mike Fly, Samuel Adams, and James McHugh");
		contentPanel.add(lblDevelopedByDylan);
		
		JLabel lblVersionNumber = new JLabel("Version Number: " + Version.getVersion());
		contentPanel.add(lblVersionNumber);
		
		
		
		
		
	}

}
