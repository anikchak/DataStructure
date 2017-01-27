package practice.stack;

public class TowerOfHanoi {

	public static void toh(int disk, char from, char mid, char to){
		if(disk == 1){
			System.out.println("Move Disk = "+disk+" from "+from+" to "+to);
		}else{
			toh(disk-1, from,to,mid);
			System.out.println("Move Disk = "+disk+" from "+from+" to "+to);
			toh(disk-1,mid,from,to);
		}
	}
	public static void main(String args[]){
		toh(3,'A','B','C');
	}
}
