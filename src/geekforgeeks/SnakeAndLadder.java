/*
 * Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell. 
 * Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.
 */
package geekforgeeks;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

	class Cell{
		int cellId;
		int noOfMovesToReachHere = 0;
	}
	public void minSteps(int moves[], int n){
		Queue<Cell> q = new LinkedList<Cell>();
		boolean visited[] = new boolean[n];
		Cell c = new Cell();
		c.cellId = 0;
		c.noOfMovesToReachHere = 0;
		visited[0] = true;
		q.add(c);
		//Check all the six locations
		while(!q.isEmpty()){
			c = q.poll();
			//If this is the destination cell 
			if(c.cellId == n-1){
				System.out.println("Min no.of moves needed to reach here = "+c.noOfMovesToReachHere);
				break;
			}
			//Else traverse other cells
			int i = c.cellId+1;
			while(i<n && i<=(c.cellId+6)){
				if(!visited[i]){
					Cell newCell = new Cell();
					newCell.noOfMovesToReachHere = c.noOfMovesToReachHere+1;
					if(moves[i]!=-1){
						newCell.cellId = moves[i];
					}else{
						newCell.cellId = i;
					}
					q.add(newCell);
				}
				i++;
			}
		}
	}
	public static void main(String[] args) {
		 // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;
 
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
 
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
 
        SnakeAndLadder sl  = new SnakeAndLadder();
        sl.minSteps(moves, N);
	}

}
