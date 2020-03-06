package null;

public class Response{
	private int jsonMember0;
	private Success success;

	public void setJsonMember0(int jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public int getJsonMember0(){
		return jsonMember0;
	}

	public void setSuccess(Success success){
		this.success = success;
	}

	public Success getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}
