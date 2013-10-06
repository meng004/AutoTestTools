
public class Parameters {
	
	private String paramName;
    private String paramType;
    private String paramValue;
    //构造方法
    public Parameters(String paramName, String paramType, String paramValue){
    	this.paramName = paramName;
    	this.paramType = paramType;
    	this.paramValue = paramValue;
    }
    
    public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}
