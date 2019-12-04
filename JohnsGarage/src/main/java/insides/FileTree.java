
package insides;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.List;

/*
 * Author: Sam
 * Sam wrote all of these methods. Thanks Sam.
 */

public class FileTree {
	
	private Folder<Tab> _root;
	private static final Path ROOTPATH = Paths.get(System.getProperty("user.dir"), "//data");
	private static final Path PROJECTSPATH = Paths.get(ROOTPATH.toString(), "//Projects");
	
	public FileTree()
	{
		try
		{
			if(!Files.exists(ROOTPATH)) //Fresh install
			{
				Files.createDirectory(ROOTPATH);
				Files.createDirectories(PROJECTSPATH);
			}
			build();
		}
		catch (IOException e)
		{
			
			System.out.println("Building tree failed:" + e.getMessage());
		}
		
	}

	
	private void build()
	{
		_root = new Folder<Tab>(ROOTPATH, "root");
		buildHelper(ROOTPATH, _root ,  0);
	}
	/*
	 * Jim added the "\\" for all the paths so it would work
	 */

	
	public void delete(GFile file)
	{
		try
		{
			if(!file.getClass().getSimpleName().equals("Item"))
			{
				Folder fold = (Folder) file;
				for(GFile f : (List<GFile>) fold.getContents())
				{
					delete(f);
				}
			}
			Files.delete(file.getPath());
		}
		catch (IOException e)
		{
			System.out.println("Problem deleting files: " + e.getMessage());
		}

	}
	
	public Tab newTab(String name)
	{
		try
		{
			Path temppath = Paths.get(_root.getPath().toString() + "\\" + name);
			System.out.println(temppath.toString());
			Files.createDirectory(temppath);
			System.out.println("1");
			Tab ret = new Tab(temppath, name);
			System.out.println("1");
			return ret;
			
		}
		catch (IOException e)
		{
			System.out.println("Problem making new Tab: " + e.getMessage());
		}
		return null;
	}
	
	public Project newProject(String name, Tab parent)
	{
		try
		{
			Path temppath = Paths.get(parent.getPath().toString() + "\\" + name);
			Files.createDirectory(temppath);
			Project ret = new Project(temppath, name);
			return ret;
			
		}
		catch (IOException e)
		{
			System.out.println("Problem making new Project: " + e.getMessage());
		}
		return null;
	}
	
	public Category newCategory(String name, Project parent)
	{
		try
		{
			Path temppath = Paths.get(parent.getPath().toString() + "\\" + name);
			Files.createDirectory(temppath);
			Category ret = new Category(temppath, name);
			return ret;
			
		}
		catch (IOException e)
		{
			System.out.println("Problem making new category: " + e.getMessage());
		}
		return null;
	}
	
	public Item newItem(String nameplusext, Path itempath, Category parent) //I'm unsure as to how this is going to be called, 
	{
		try
		{
			Path temppath = Paths.get(parent.getPath().toString() + "\\" + nameplusext);
			Files.copy(itempath, temppath);
			Item ret = new Item(temppath, nameplusext);
			return ret;
			
		}
		catch (IOException e)
		{
			System.out.println("Problem making new Item: " + e.getMessage());
		}
		return null;
	}
	
	public List<Tab> getTabs()
	{
		return _root.getContents();
	}
	
	private void buildHelper(Path curPath, Folder parent, int layer)
	{
		File[] files = curPath.toFile().listFiles();
		GFile temp = new GFile();
		if(layer < 3) //if we are not yet at the item level
		{
			for(File f : files)
			{
				switch (layer)
				{
					case 0: 
						temp = new Tab(f.toPath(), f.getName());
						break;
					case 1:
						temp = new Project(f.toPath(), f.getName());
						break;
					case 2: 
						temp = new Category(f.toPath(), f.getName());
						break;
				}
				parent.add(temp);
				buildHelper(temp.getPath(), (Folder) temp,  layer + 1);
			}
		}
		else
		{
			for(File f : files)
			{
				//tag feature goes here
				temp = new Item(f.toPath(), f.getName());
				parent.add(temp);
			}
		}
	}
	
	
}
