
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

public class FileTree {
	
	private Folder<Tab> _root;
	private static final Path ROOTPATH = Paths.get("/data");
	private static final Path PROJECTSPATH = Paths.get("/data/Projects");
	
	public FileTree()
	{
		try
		{
			if(!Files.exists(ROOTPATH)) //Fresh install
			{
				Files.createDirectory(ROOTPATH);
				Files.createDirectories(PROJECTSPATH);
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private void build()
	{
		_root = new Folder<Tab>(ROOTPATH, "root");
		buildHelper(ROOTPATH, _root ,  0);
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
					case 0: temp = new Tab(f.toPath(), f.getName());
					case 1: temp = new Project(f.toPath(), f.getName());
					case 2: temp = new Category(f.toPath(), f.getName());
				}
				parent.add(temp);
			}
		}
		else
		{
			for(File f : files)
			{
				temp = new Item(f.toPath(), f.getName());
				parent.add(temp);
			}
		}
	}
	
	
}
