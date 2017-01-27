package practice.recursionanddynamicprogramming;

public class CountWays {

	//Recursive method
	public int countWaysToClimb(int steps){
		if(steps<0){
			return 0;
		}else if(steps == 0){
			return 1;
		}else{
			int oneStepCount = countWaysToClimb(steps-1);
			int twoStepCount = countWaysToClimb(steps-2);
			int threeStepCount = countWaysToClimb(steps-3);
			return oneStepCount+twoStepCount+threeStepCount;
			
		}
	}
	//Dynamic programming method
	int count[] = new int[100];
	public int countWaysToClimbDynamic(int steps){
		if(steps<0){
			return 0;
		}else if(steps == 0){
			return 1;
		}else if(count[steps] > -1){
			return count[steps];
		}
		else{
			int oneStepCount = countWaysToClimb(steps-1);
			int twoStepCount = countWaysToClimb(steps-2);
			int threeStepCount = countWaysToClimb(steps-3);
			count[steps] =  oneStepCount+twoStepCount+threeStepCount;
			return count[steps];
		}
	}
	
	public static void main(String[] args) {
		CountWays cw = new CountWays();
		int steps = 3;
		
		//Initializing count array
		for(int i=0;i<cw.count.length;i++){
			cw.count[i] = -1;
		}
		System.out.println("Dynamic: No. of ways to clib with steps "+ steps+ " = "+cw.countWaysToClimbDynamic(steps));

	}

}
