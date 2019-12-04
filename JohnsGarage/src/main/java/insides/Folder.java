/**
 * Folder class, a subtype of file. Has a list of references to the contents it holds.
 * @author Sam
 */
package insides;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Folder<T extends GFile> extends GFile{
	private ArrayList<T> _contents;
	
	/**
	 * Builds the internal representation of the folder. Usually used as a holder to Tabs, Projects, and Categories.
	 * @param path
	 * @param name
	 */
	public Folder(Path path, String name)
	{
		super(path, name);
		_contents = new ArrayList<T>();
		
	}
	
	/**
	 * Get the contents of the Folder. The return type is dependent on the contents.
	 * Typically requires a cast to store.
	 * @author Sam
	 * @return The list of the Folder's contents.
	 */
	public List<T> getContents()
	{
		return _contents;
	}
	
	/**
	 * Adds a new item to the contents of the folder. Primarily used by FileTree to construct and maintain the relationships between folders and files.
	 * @author Sam
	 * @param newContent
	 */
	public void add(T newContent)
	{
		_contents.add(newContent);
	}
	

}
