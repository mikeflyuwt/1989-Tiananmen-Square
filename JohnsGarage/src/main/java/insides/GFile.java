/**
 * A basic representation of the name and path to a file. Acts as a parent to all of the representations of files within this project.
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
	 * @author Sam
	 */
	public GFile()
	{
		
	}
	
	/**
	 * Sets basic parameters for the file.
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
	 * @author Sam
	 * @return the Path
	 */
	public Path getPath()
	{
		return _path;
	}
	
	/**
	 * Gets the name of the File.
	 * @author Sam
	 * @return the Name
	 */
	public String getName()
	{
		return new String(_name);
	}
	
	/**
	 * Changes the name of the file. Should only be used within FileTree, as this does not change the actual file.
	 * @author Sam
	 * @param newName
	 */
	public void changeName(String newName)
	{
		_name = new String(newName);
	}
}
