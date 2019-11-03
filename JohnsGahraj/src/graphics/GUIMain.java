package graphics;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;


import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.TableItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JWindow;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import insides.Version;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class AboutActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("dd");
	}
}


public class GUIMain {
 
  protected Shell shell;
 
  /**
  * Launch the application.
  * @param args
  */
  public static void main(String[] args) {
    try {
      GUIMain window = new GUIMain();
      window.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
 
  /**
  * Open the window.
  */
  public void open() {
    Display display = Display.getDefault();
    createContents();
    shell.open();
    shell.layout();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }
 
  /**
  * Create contents of the window.
  */
  protected void createContents() {
    shell = new Shell();
    shell.setSize(844, 457);
    shell.setText("SWT Application");
    
    Menu menu = new Menu(shell, SWT.BAR);
    shell.setMenuBar(menu);
    
    
    
    MenuItem mntmAbout = new MenuItem(menu, SWT.NONE);
    mntmAbout.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {

    		GUIAbout aboutWind = new GUIAbout();
    		aboutWind.setVisible(true);
    	}
    });
    mntmAbout.setText("About");
    
    
  }
  
}