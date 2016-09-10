package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI {
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String,Command> commands;
	
	public CLI(BufferedReader in, PrintWriter out, HashMap<String,Command> commands) {
		this.in = in;
		this.out = out;
		this.commands = commands;
	}
	
	public void start() throws IOException {
		String str = new String();
		while(!str.equals("exit")){
			str = this.in.readLine();
			try {
				commands.get(str).doCommand();
			}
			catch(Exception e) {
				out.write("Error executing command.");
			}
		}
	}
}
