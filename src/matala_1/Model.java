package matala_1;
/**
 * This class contains the phone's (who did the scan) Model
 * @author Bar, Noy, Doriya
 *
 */
public class Model {
	private String Model;

	public Model(String Model){
		this.Model = Model;
	}
	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}
	
	public boolean is_Equal(Model m){
		return this.Model.equals(m);
	}

	@Override
	public String toString() {
		return Model;
	}
}
