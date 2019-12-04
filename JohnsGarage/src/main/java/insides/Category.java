package insides;

import java.nio.file.Path;

public class Category extends Folder<Item> {

	public Category(Path path, String name)
	{
		super(path, name);
	}
}
