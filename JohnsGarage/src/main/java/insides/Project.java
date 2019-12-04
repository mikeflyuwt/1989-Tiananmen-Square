/**
 * A representation of a Project, used by the GUI to construct UI components.]
 * @author Sam
 */
package insides;

import java.nio.file.Path;

public class Project extends Folder<Category>{
	private static final long serialVersionUID = 579981190786066767L;
	
	/**
	 * Initializes the Project.
	 * @param path
	 * @param name
	 */
	public Project(Path path, String name)
	{
		super(path, name);
	}

}
