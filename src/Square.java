
public class Square {
	
	public Symbol v;
	
	Square(){
		v = new Symbol("_");
	}
	
	public boolean checkFree(){
		
		if ( v.getValue() == "_") return true;
		return false;
	}
	
	public void setValue( Symbol value ){
		
		v = value ;
	}
	
	public String toString(){
		return v.getValue();
	}

}
