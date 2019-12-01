package graphics;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.List;
import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import insides.Category;
import insides.FileTree;
import insides.Tab;

import java.awt.Font;

public class GUITabList extends JPanel {
	
	DefaultListModel model;
	
	public GUITabList() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 156, 287);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 156, 287);
		
		model = new DefaultListModel();
		

		JList list = new JList(model);
		scrollPane.setViewportView(list);
		add(scrollPane);
		
		JLabel listOfTabs = new JLabel("Tabs");
		listOfTabs.setFont(new Font("Tahoma", Font.BOLD, 12));
		listOfTabs.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(listOfTabs);

	}
	
	
	
	public void loadTabs(FileTree theFileTree) {

		List<Tab> joey = theFileTree.getRoot().getContents();
		ArrayList tum = new ArrayList();

		for(int i = 0; i < joey.size(); i++) {
			
			tum.add(joey.get(i));
		}
		
		
		int i;
		for(i = 0; i < tum.size(); i++) {
			model.addElement(tum.get(i));
		}
		
	}
}
