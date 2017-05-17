/*
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. 
 * Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 * NO LIMITATION ON TXN
 */
package geekforgeeks;

import java.util.ArrayList;

class BuySell{
	int buy;
	int sell;
}
public class BuySellStock {

	public void buySellStock(int price[]){
		int i=0, n=price.length;
		ArrayList<BuySell> al = new ArrayList<BuySell>();
		if(n == 1){
			return;
		}
		while(i<n){
			BuySell bsObj = new BuySell();
			while((i<n-1) && (price[i]>=price[i+1])){//Local Minima
				i++;
			}
			if(i == n-1){
				break;
			}
			bsObj.buy = i;
			i++;
			while((i<n) && (price[i]>=price[i-1])){//Local Maxima
				i++;
			}
			bsObj.sell = i-1;
			al.add(bsObj);
		}
		if(al.size() == 0){
			System.out.println("No profitable solution available.");
		}else{
			for(BuySell bs:al){
				System.out.println("Buy on day = "+bs.buy);
				System.out.println("Sell on day = "+bs.sell);
			}
		}
	}
	public static void main(String[] args) {
		BuySellStock bs = new BuySellStock();
		//int price[] = {100, 180, 260, 310, 40, 535, 695};
		//int price[] = {100, 90, 80, 70, 60, 50, 40};
		int price[] = {1, 2, 3, 4, 5, 6, 7};
		bs.buySellStock(price);
	}

}
