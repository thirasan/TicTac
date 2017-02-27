
import java.util.Scanner;

public class Game {
	
	static Board b;
	static Player p1,p2;
	
	static Scanner sc = new Scanner (System.in);
	
	
	public static void main(String[] args){
		
		
		
		b = new Board(9);
		b.printBoard();
		
		p1 = new Player ("Stang" , "X");
		p2 = new Player ("Rom" , "O");
		
		int round = 1;
		while ( round > 0 ){
			
			Player player;
			
			if ( round % 2 == 1)player = p1;
			else player = p2;
			
			round++;

			System.out.println();
			System.out.print(player.name + "'s turns \n");
			
			while (true) {
				
				int[]a;
				while (true) {
					
					try {
						a = playerInput();
						
						break;
						
					} catch (Exception e) {
						System.out.println("Enter number !");
						System.out.println();
						continue;
						
					}
				}
				
				
				 
				if ( b.put(player, a[0] - 1, a[1] - 1 ) ){
					b.printBoard();
					break;
				} else System.out.println("You can't place on that square");
				
				System.out.println();
			}
			
			if(b.checkHori(player.sym.value) || b.checkVerti(player.sym.value) || b.checkDiag(player.sym.value)){
				System.out.println(player.name + " win");
				break;
			}
			
		}
		
	}
	
	public static int[] playerInput(){
		
		int [] a = new int[2];
		System.out.print("Select row : ");
		a[0] = Integer.parseInt(sc.nextLine());
		System.out.print("Select column : ");
		a[1] = Integer.parseInt(sc.nextLine());
		System.out.println();
		return a;
	}
	
}
