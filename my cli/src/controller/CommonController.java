package controller;

import model.CommonModel;
import view.CommonView;

public abstract class CommonController implements Controller {

	private CommonModel model;
	private CommonView view;
	
	public CommonController(CommonModel model, CommonView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public abstract void notify(String name);
	
	public CommonModel getModel() {
		return model;
	}


	public CommonView getView() {
		return view;
	}
}
