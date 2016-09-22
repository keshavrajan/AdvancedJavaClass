
public class MyClass{

	@FieldAnnotation
	public String myAnnotatedPublicField;

	@FieldAnnotation
	public String myAnnotatedPrivateField;
	
	public String myUnAnnotatedPublicField;

	public String myUnAnnotatedPrivateField;

	public String getMyAnnotatedPublicField() {
		return myAnnotatedPublicField;
	}

	public void setMyAnnotatedPublicField(String myAnnotatedPublicField) {
		this.myAnnotatedPublicField = myAnnotatedPublicField;
	}

	public String getMyAnnotatedPrivateField() {
		return myAnnotatedPrivateField;
	}

	public void setMyAnnotatedPrivateField(String myAnnotatedPrivateField) {
		this.myAnnotatedPrivateField = myAnnotatedPrivateField;
	}

	public String getMyUnAnnotatedPublicField() {
		return myUnAnnotatedPublicField;
	}

	public void setMyUnAnnotatedPublicField(String myUnAnnotatedPublicField) {
		this.myUnAnnotatedPublicField = myUnAnnotatedPublicField;
	}

	public String getMyUnAnnotatedPrivateField() {
		return myUnAnnotatedPrivateField;
	}

	public void setMyUnAnnotatedPrivateField(String myUnAnnotatedPrivateField) {
		this.myUnAnnotatedPrivateField = myUnAnnotatedPrivateField;
	}

	@Override
	public String toString() {
		return "MyClass [myAnnotatedPublicField=" + myAnnotatedPublicField
				+ ", myAnnotatedPrivateField=" + myAnnotatedPrivateField
				+ ", myUnAnnotatedPublicField=" + myUnAnnotatedPublicField
				+ ", myUnAnnotatedPrivateField=" + myUnAnnotatedPrivateField
				+ "]";
	}




	
	

}
