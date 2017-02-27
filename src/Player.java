
public class Player {

	public String name;
	public Symbol sym;
	
	Player( String n , String s ){
		name = n;
		sym = new Symbol(s);
	}
	
	public Symbol getSymbol(){
		return sym;
	}
}
