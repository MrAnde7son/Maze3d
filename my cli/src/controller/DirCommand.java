package controller;

import java.io.File;

/***
 * dir command. Lists all files and folders on a given path.
 * @author Itamar&Chen
 *
 */
public class Dir extends CommonCommand {

	private File file;
	
	public Dir(CommonController controller) {
		super(controller);
	}
	
	@Override
	public void doCommand(String cmd) {
		try{
			file = new File(cmd);
			String[] list = file.list();
			for(String str: list)
				System.out.println(str + '\t');
		}
		catch(NullPointerException e){
			controller.UpdateMessage("Invalid path.");
		}
	}

}
