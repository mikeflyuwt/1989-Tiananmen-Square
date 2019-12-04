package graphics;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;  
import javax.swing.JMenuBar;  
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import insides.FileTree;
import insides.Tab;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JList;

public class GUIMainVer1 {

	private JFrame frame;
	
	public static FileTree theFileTree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		//testing stuff don't worry about it
		theFileTree = new FileTree();
		//Tab timmy = new Tab(theFileTree.getRoot().getPath(), "timmy");
		//theFileTree.newTab("timmy");
		//Tab tommy = theFileTree.newTab("tommy");
		//theFileTree.newProject("dome", tommy);
		
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMainVer1 window = new GUIMainVer1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMainVer1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.setTitle("Jon's Gahraj");
		frame.setBounds(100, 100, 600, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		GUITabList sideList = new GUITabList();
		sideList.loadTabs(theFileTree);
		frame.add(sideList);
		sideList.setBounds(10,11,156,287);
		sideList.setVisible(true);
		frame.getContentPane().add(sideList);
		sideList.setLayout(null);
		
		// Title panel
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(176, 11, 390, 287);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		// Title label
		JLabel lblNewLabel_1 = new JLabel("Jon's Gahraj");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 370, 44);
		panel_1.add(lblNewLabel_1);
		
		// Projects button
		JButton btnProjects = new JButton("Projects");
		btnProjects.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fill in
				System.out.println("Projects!");
			}
		});
		//btnProjects.setBounds(10, 5, 136, 23);
		//panel.add(btnProjects);
		
		// Add Tab button
		JButton btnAddTab = new JButton("Add Tab");
		btnAddTab.setText("<html><center>"+"Add"+"<br>"+"Tab"+"</center></html>");
		btnAddTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fill in
				System.out.println("Tab added!");
			}
		});
		btnAddTab.setBounds(10, 301, 79, 34);
		frame.getContentPane().add(btnAddTab);
		
		// Remove Tab button
		JButton btnRemoveTab = new JButton("Remove Tab");
		btnRemoveTab.setText("<html><center>"+"Remove"+"<br>"+"Tab"+"</center></html>");
		btnRemoveTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fill in
				System.out.println("Tab removed!");
			}
		});
		btnRemoveTab.setBounds(87, 301, 79, 34);
		frame.getContentPane().add(btnRemoveTab);
		
		// Export button
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Fill in
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showSaveDialog(null);
				
				System.out.println("Export");
			}
		});
		btnExport.setBounds(487, 301, 79, 34);
		frame.getContentPane().add(btnExport);
		
		// Import button
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fill in
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				
				System.out.println("Import");
			}
		});

		btnImport.setBounds(410, 301, 79, 34);
		frame.getContentPane().add(btnImport);
		
		
		
		// Menu bar
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIAbout aboutWind = null;
				try {
					aboutWind = new GUIAbout();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		aboutWind.setVisible(true);
			}
		});
		menuBar.add(mntmAbout);
		
				
	}
}