package insides;

import java.io.Serializable;

public class File implements Serializable{
	private static final long serialVersionUID = -5646752043942919867L;
	private String _path;
	private String _name;
	
	public File(String path, String name)
	{
		_path = path;
		_name = name;
	}
	
	public String getPath()
	{
		return new String(_path);
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
