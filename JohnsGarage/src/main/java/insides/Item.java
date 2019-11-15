package insides;

public class Item extends File
{
	private static final long serialVersionUID = -3094981139422206289L;
	private String _extension;

	public Item(String path, String name, String extension)
	{
		super(path, name);
		_extension = extension;
	}
	
	@Override
	public String getPath()
	{
		return super.getPath() + _extension;
	}

}
