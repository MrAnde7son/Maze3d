package controller;

import java.io.File;


/***
 * dir command. Lists all files and folders on a given path.
 * @author Itamar
 *
 */
public class Dir extends CommonCommand{
	
	/**
	 * Dir constructor
	 * @param controller - get the controller to work with him
	 */
	public Dir(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String str) {
		try {
			File file = new File(str);	
			String[] string = file.list();
			String list = "";
			
			for(int i = 0; i <string.length; i++)
				list += string[i] + '\n';
			
			controller.notify(list);
		}
		catch (NullPointerException e){
			controller.notify("Invalid path");
		}
		
	}
}


//@Override
//public void doCommand() {
//	String[] list = file.list();
//	for(String str: list)
//		System.out.println(str + '\t');