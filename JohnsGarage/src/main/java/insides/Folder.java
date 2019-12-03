package insides;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Folder<T extends GFile> extends GFile{
	private ArrayList<T> _contents;
	
	public Folder(Path path, String name)
	{
		super(path, name);
		_contents = new ArrayList<T>();
		
	}
	
	public List<T> getContents()
	{
		return _contents;
	}
	
	public void add(T newContent)
	{
		_contents.add(newContent);
	}


}
