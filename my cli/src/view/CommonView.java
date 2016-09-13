package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;
import controller.Command;
import controller.Controller;

/**
 * CommonView - implements View
 * abstract class of the view size
 */

public abstract class CommonView implements View {

	protected Controller controller;
	protected CLI cli;
	protected HashMap<String,Command> hashCommand;
	protected BufferedReader in;
	protected PrintWriter out;

	public CommonView(BufferedReader in,PrintWriter out) {
		this.in = in;
		this.out = out;
		hashCommand = new HashMap<>();
		
	}
	
	/*
	 * Configure the controller-view integration
	 *
	 */
	public void setController(Controller controller){
		this.controller = controller;
	}
	
	@Override
	public void exit() {
		cli.setRunning(false);
	}
	
	@Override
	public abstract void start();

	@Override
	public abstract void notify(String message);
	
	@Override
	public void setCommands(HashMap<String,Command> hashCommand){
		this.hashCommand = hashCommand;
	}
}