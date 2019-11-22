package insides;

import java.nio.file.Path;

public class Project extends Folder<Category>{
	private static final long serialVersionUID = 579981190786066767L;
	
	public Project(Path path, String name)
	{
		super(path, name);
	}

}
