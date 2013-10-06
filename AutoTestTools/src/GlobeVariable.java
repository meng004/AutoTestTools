
public class GlobeVariable {
    private String Name;
    private String Type;
    private String Value;
    
    //构造方法
    public GlobeVariable(String Name, String Type, String value){
    	this.Name = Name;
    	this.Type = Type;
    	this.Value = value;
    }
    
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		this.Value = value;
	}
}
