package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.MyController;
/***
 * View component in MVC. Designed to work with Maze3d.
 * @author Itamar & Chen
 *
 */
public class MyView extends CommonView {

	private MyController controller;
	private CLI cli;
	
	public MyView(BufferedReader in, PrintWriter out){
		this.in = in;
		this.out = out;		
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
		this.controller.getView().setCommands(commands);
	}

	public MyController getController() {
		return controller;
	}

}
