package insides;

import java.util.ArrayList;
import java.util.List;

public abstract class Folder<T extends File> extends File{
	private static final long serialVersionUID = -781660998510515160L;
	private ArrayList<T> _contents;
	
	public Folder(String path, String name)
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
