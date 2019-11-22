package insides;

import java.io.Serializable;
import java.nio.file.Path;

public class GFile implements Serializable{
	private static final long serialVersionUID = -5646752043942919867L;
	private Path _path;
	private String _name;
	
	public GFile()
	{
		
	}
	
	public GFile(Path path, String name)
	{
		_path = path;
		_name = name;
	}
	
	public Path getPath()
	{
		return _path;
	}
	
	public String getName()
	{
		return new String(_name);
	}
	
	public void changeName(String newName)
	{
		_name = new String(newName);
	}
}
