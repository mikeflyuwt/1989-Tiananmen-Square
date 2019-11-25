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
import java.awt.List;
import java.awt.Scrollbar;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUIProjectList extends JPanel {
	
	DefaultListModel model;
	
	public GUIProjectList() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 156, 287);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 156, 287);
		
		model = new DefaultListModel();
		model.addElement("Peepo");
		model.addElement("feebo");
		loadProjects();
		loadProjects();
		loadProjects();

		JList list = new JList(model);
		scrollPane.setViewportView(list);
		add(scrollPane);
		
		JLabel lblListOfJunk = new JLabel("Projects");
		lblListOfJunk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListOfJunk.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblListOfJunk);

	}
	
	
	
	public void loadProjects() {
		ArrayList tum = new ArrayList();
		tum.add("this");
		tum.add("this1");
		tum.add("this2");
		tum.add("this3");
		tum.add("this4");
		tum.add("this5");
		
		int i;
		for(i = 0; i < tum.size(); i++) {
			model.addElement(tum.get(i));
		}

	}
}
