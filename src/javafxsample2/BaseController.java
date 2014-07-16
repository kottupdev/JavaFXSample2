package javafxsample2;

import javafx.stage.Stage;

public abstract class BaseController {
	protected Stage _stage = null;
	public void setStageAndSetupListeners(Stage stage) {
		_stage = stage;
	} 
}
