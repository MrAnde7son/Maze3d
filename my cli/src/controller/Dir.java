package controller;

import java.io.File;

/***
 * dir command. Lists all files and folders on a given path.
 * @author Itamar
 *
 */
public class Dir implements Command {

	private File file;
	
	public Dir(String path) {
		file = new File(path);
	}
	
	@Override
	public void doCommand() {
		String[] list = file.list();
		for(String str: list)
			System.out.println(str + '\t');
	}

}
