
public class Board {

	Square[][] b;
	int size;
	Board ( int s ){
		size = s;

		b = new Square[s][s];

		for ( int i = 0 ; i < s ; i++ ){
			for ( int j = 0 ; j < s ; j++ ){
				b[i][j] = new Square();
			}
		}
	}

	public boolean put ( Player p, int i , int j ){
		try {
			if ( b[i][j].checkFree() ){
				b[i][j].setValue( p.getSymbol());
				return true;
			}

		} catch (Exception e) { }

		return false;
	}

	public void printBoard(){
		
		for ( int i = 0 ; i < size + 1 ; i++ ){
			
			System.out.print( i + " ");
		}
		
		System.out.println();
		for ( int i = 0 ; i < size ; i++ ){
			
			System.out.print(i + 1 + " ");
			for ( int j = 0 ; j < size ; j++ ){
				
				System.out.print(b[i][j].toString()+ " ");
			}
			
			System.out.println();
		}
	}

	public boolean checkHori(String sym){
		
		try{
			
			String res = "";
			for(int i = 0 ;  i < size; i++){
				
				for(int j = 0 ; j < size; j++){
					
					if(res == "" && b[i][j].v.value == sym){
						
						res = b[i][j].v.value;
						continue;
					}
					
					if(b[i][j].v.value == sym) res += b[i][j].v.value;
					else res = "";
					
					if(res.length() == 5) return true;
				}
			}
		}catch(Exception e){ }
		return false;
	}

	public boolean checkVerti(String sym){
		try{
			String res = "";
			for(int j = 0 ;  j < size; j++){
				for(int i = 0 ; i < size; i++){
					if(res == "" && b[i][j].v.value == sym) {
						res = b[i][j].v.value;
						continue;
					}
					if(b[i][j].v.value == sym) 
						res += b[i][j].v.value;
					else res = "";
					if(res.length() == 5) return true;
				}
			}
		}catch(Exception e){

		}
		return false;
	}
	
	public boolean checkDiag(String sym) {
		String diagonal = "";
		String consec = "";
		for (int i = 0; i < 5; i++) {
			consec += sym;
		}
		for (int k = 0;k<size;k++) {
			for (int i = k,j = 0;i<size && j < size;i++,j++) {
				diagonal += b[i][j].toString();
			}
			if (diagonal.contains(consec)) return true; else diagonal = "";
		}
		for (int k = 0;k<size;k++) {
			for (int i = k,j = size-1;i<size && j >= 0;i++,j--) {
				diagonal += b[i][j].toString();
			}
			if (diagonal.contains(consec)) return true; else diagonal = "";
		}
		
		return false;
	}
	
	
	
	
}
