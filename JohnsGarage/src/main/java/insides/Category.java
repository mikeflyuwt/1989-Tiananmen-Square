/**
 * Categories are a subtype of folders, which contain items.
 * Last Edited: 12/4/2019
 * @author Sam
 */
package insides;

import java.nio.file.Path;

public class Category extends Folder<Item> {

	/**
	 * Builds the category. Used by the FileTree to build new Categories.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param path
	 * @param name
	 */
	public Category(Path path, String name)
	{
		super(path, name);
	}
}
