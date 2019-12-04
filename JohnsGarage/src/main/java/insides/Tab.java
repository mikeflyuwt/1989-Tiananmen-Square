/**
 * The Tab is the highest level of folder within the FileSystem representation. Tabs are folders of projects.
 * @author Sam
 * Last Edited: 12/4/2019
 */
package insides;

import java.nio.file.Path;

public class Tab extends Folder<Project>
{
	private static final long serialVersionUID = 7392335020587911126L;

	/**
	 * Initializes the Tab. 
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param path
	 * @param name
	 */
	public Tab(Path path, String name) 
	{
		super(path, name);
	}

}
