/**
 * The Filetree is responsible for all IO duties and property handling of all the classes that inherit from GFile.
 * This can be thought of as the controller.
 * Last Edited: 12/4/2019
 * @author Sam
 */
package insides;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileTree {
	
	private Folder<Tab> _root;
	private static final Path ROOTPATH = Paths.get(System.getProperty("user.dir"), "//data");
	private static final Path PROJECTSPATH = Paths.get(ROOTPATH.toString(), "//Projects");
	private static final Path CONFIGPATH = Paths.get(ROOTPATH.toString(), "//config.info");
	
	private Map<GFile, Map<String, String>> _itemProperties;
	
	/**
	 * Initializes values for the FileTree class.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param file
	 */
	public FileTree()
	{
		try
		{
			if(!Files.exists(ROOTPATH)) //Fresh install
			{
				Files.createDirectory(ROOTPATH);
				Files.createDirectories(PROJECTSPATH);
			}
			if(!Files.exists(CONFIGPATH)) Files.createFile(CONFIGPATH);
			else if(CONFIGPATH.toFile().length() != 0L)
			{
				File config = CONFIGPATH.toFile();
				FileInputStream f = new FileInputStream(config);
				BufferedInputStream b = new BufferedInputStream(f);
				ObjectInputStream reader = new ObjectInputStream(b);
				_itemProperties = (Map<GFile, Map<String, String>>) reader.readObject();
				reader.close();
			}
			build();
		}
		catch (IOException e)
		{
			
			System.out.println("Building tree failed:" + e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Deserializing config failed:" + e.getMessage());
		}
		
	}
	
	/**
	 * Closes the FileTree and writes the current value of the properties map to the config file.
	 * Should be called before the program is terminated.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 */
	public void close()
	{
		try
		{
			File config = CONFIGPATH.toFile();
			FileOutputStream fout = new FileOutputStream(config);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(_itemProperties);
			oout.close();
		}
		catch(IOException e)
		{
			System.out.println("Serializing config failed:" + e.getMessage());
		}
	}

	/**
	 * Recursive helper to build the FileTree.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 */
	private void build()
	{
		_root = new Folder<Tab>(ROOTPATH, "root");
		buildHelper(ROOTPATH, _root ,  0);
	}
	/*
	 * Jim added the "\\" for all the paths so it would work
	 */

	/**
	 * Takes a GFile and recursively deletes both its children and itself.
	 * Calling this method will eliminate the reference passed to it.
	 * Last Edited: 12/4/2019
	 * @param file
	 * @author Sam
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
			file = null;
		}
		catch (IOException e)
		{
			System.out.println("Problem deleting files: " + e.getMessage());
		}

	}
	
	/**
	 * Returns a Map of Property Names to Values for a given GFile.
	 * You can change them yourself, or call changeProperty for added safety.
	 * Last Edited: 12/4/2019
	 * @param item
	 * @author Sam
	 * @return The Map of Properties
	 */
	public Map<String, String> getProperties(GFile item)
	{
		return _itemProperties.get(item);
	}
	
	/**
	 * Puts a new value or overwrites an old value for a property of a GFile.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param target
	 * @param property
	 * @param value
	 */
	public void changeProperty(GFile target, String property, String value)
	{
		_itemProperties.get(target).put(property, value);
	}
	
	/**
	 * Builds and returns a new Tab object. Changes are immediately made within the FileSystem.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param name
	 * @return The new Tab
	 */
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
	/**
	 * Builds and returns a new Project object. Changes are immediately made within the FileSystem.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param name
	 * @param parent
	 * @return The new Project.
	 */
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
	
	/**
	 * Builds and returns a new Category object. Changes are immediately made within the FileSystem.
	 * Last Edited: 12/4/2019
	 * @param name
	 * @param parent
	 * @return The new Category.
	 */
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
	
	/**
	 * Builds and returns a new Item object. Changes are immediately made within the FileSystem.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param nameplusext
	 * @param itempath
	 * @param parent
	 * @return the new Item.
	 */
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
	
	/**
	 * An easy way to get access to the highest level of folder.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @return the Tabs.
	 */
	public List<Tab> getTabs()
	{
		return _root.getContents();
	}
	
	/**
	 * A recursive helper to build the FileTree. The current layer corresponds to the current depth of the call in the FileTree.
	 * This means that we can conclude the type of the folder based upon the depth.
	 * Last Edited: 12/4/2019
	 * @author Sam
	 * @param curPath
	 * @param parent
	 * @param layer
	 */
	private void buildHelper(Path curPath, Folder parent, int layer)
	{
		File[] files = curPath.toFile().listFiles();
		GFile temp = new GFile();
		if(layer < 3) //if we are not yet at the item level
		{
			for(File f : files)
			{
				if(f.getName().equals("config.info")) continue;
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
