package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import insides.FileTree;
import insides.Tab;

public class GUITabPane extends JPanel
{
	private FileTree theFileTree;
	
	public GUITabPane(FileTree fileTree)
	{
		setLayout(new BorderLayout());
		theFileTree = fileTree;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(panel);
		
		JList tabList = loadTabs();
		scrollPane.setViewportView(tabList);
		add(scrollPane);
		
		JLabel title = new JLabel("Tabs");
		title.setFont(new Font("Tahoma", Font.BOLD, 12));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(title);
	}
	
	public JList loadTabs()
	{
		List<Tab> tabs = theFileTree.getTabs();
		return new JList(tabs.toArray());
	}
}