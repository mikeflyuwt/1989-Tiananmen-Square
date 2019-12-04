/**
 * The lowest level of representation. Contained by categories, Items are representative of actual files within the FileSystem.
 * @author Sam
 */
package insides;

import java.nio.file.Path;

public class Item extends GFile
{
	private static final long serialVersionUID = -3094981139422206289L;

	/**
	 * Builds the Item. Make sure the extension is included within the path when called.
	 * @param path
	 * @param name
	 */
	public Item(Path path, String name)
	{
		super(path, name);
	}

}
