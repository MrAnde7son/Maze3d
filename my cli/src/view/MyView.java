package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;
import controller.MyController;
/***
 * View component in MVC. Designed to work with Maze3d.
 * @author Itamar & Chen
 *
 */
public class MyView extends CommonView {

	//private MyController controller;
	
	public MyView(BufferedReader in, PrintWriter out){
		super(in,out);	
	}
	
	@Override
	public void notify(String name) {
		this.controller.notify(name);
	}
	
	@Override
	public void start(){
		cli = new CLI(in,out, hashCommand);
		cli.start();
	}
	
	@Override
	public void setCommands(HashMap<String, Command> commands) {
		((MyController)this.controller).getView().setCommands(commands);
	}

	public Controller getController() {
		return controller;
	}

}
