/**
 * A basic representation of the name and path to a file. Acts as a parent to all of the representations of files within this project.
 * Last Edited: 12/4/2019
 * @author Sam
 */
package insides;

import java.io.Serializable;
import java.nio.file.Path;

public class GFile implements Serializable{
	private static final long serialVersionUID = -5646752043942919867L;
	private Path _path;
	private String _name;
	
	/**
	 * Used to initialize holder variables within FileTree.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 */
	public GFile()
	{
		
	}
	
	/**
	 * Sets basic parameters for the file.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param path
	 * @param name
	 */
	public GFile(Path path, String name)
	{
		_path = path;
		_name = name;
	}
	
	/**
	 * Gets the Path to the object within the FileSystem.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @return the Path
	 */
	public Path getPath()
	{
		return _path;
	}
	
	/**
	 * Gets the name of the File.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @return the Name
	 */
	public String getName()
	{
		return new String(_name);
	}
	
	/**
	 * Changes the name of the file. Should only be used within FileTree, as this does not change the actual file.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param newName
	 */
	public void changeName(String newName)
	{
		_name = new String(newName);
	}
	
	@Override
	public String toString()
	{
		return _name;
	}
}
