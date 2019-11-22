package insides;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Folder<T extends GFile> extends GFile{
	private static final long serialVersionUID = -781660998510515160L;
	private ArrayList<T> _contents;
	
	public Folder(Path path, String name)
	{
		super(path, name);
		_contents = new ArrayList<T>();
		
	}
	
	public List<T> getContents()
	{
		return (List<T>) _contents.clone();
	}
	
	public void add(T newContent)
	{
		_contents.add(newContent);
	}


}
