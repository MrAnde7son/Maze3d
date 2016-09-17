package view;

import java.io.BufferedReader;
import java.io.PrintWriter;

import controller.Controller;
import controller.MyController;
/***
 * View component in MVC. Designed to work with Maze3d.
 * @author Itamar & Chen
 *
 */
public class MyView extends CommonView {

	public MyView(BufferedReader in, PrintWriter out){
		super(in,out);
	}
	
	@Override
	public void UpdateMessage(String name) {
		this.controller.UpdateMessage(name);
	}
	
	@Override
	public void start(){
		cli = new CLI(in,out, hashCommand);
		cli.start();
	}
	
	@Override
	public void setController(Controller controller){
		this.controller = controller;
		this.hashCommand = ((MyController)controller).getCommands();
	}
	
}
