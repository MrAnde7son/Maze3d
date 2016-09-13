package view;

import java.util.HashMap;
import controller.Command;
import controller.Controller;

/***
 * View component in MVC.
 * @author Itamar&Chen
 *
 */
public interface View {
	
	void start();
	void notify(String message);
	void exit();
	void setCommands(HashMap<String,Command> hashCommand);
	void setController(Controller controller);
}