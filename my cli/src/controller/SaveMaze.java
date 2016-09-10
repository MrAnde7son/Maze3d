package controller;

import io.MyCompressorOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/***
 * save_maze command. Saves maze to file.
 * @author Itamar
 *
 */
public class SaveMaze implements Command {

	private OutputStream out;
	private String name;
	private String path;
	
	public SaveMaze(String name, String path) throws FileNotFoundException {
		this.name = name;
		this.path = path;
		this.out = new MyCompressorOutputStream(new FileOutputStream(path));
	}
	
	@Override
	public void doCommand() {

		this.out.write(maze.toByteArray());
		this.out.flush();
		this.out.close();
	}

}
