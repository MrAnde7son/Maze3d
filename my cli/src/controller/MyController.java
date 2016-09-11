package controller;

import model.MyModel;
import view.MyView;
/***
 * Controller component in MVC. Designed to work with Maze3d.
 * @author Itamar
 *
 */
public class MyController extends CommonController {
	
	private MyModel model;
	private MyView view;
	
	@Override
	public void notify(String name) {
		// TODO Auto-generated method stub

	}

	public MyModel getModel() {
		return model;
	}


	public MyView getView() {
		return view;
	}


}
