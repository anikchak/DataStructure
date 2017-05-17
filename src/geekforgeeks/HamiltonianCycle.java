/*
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. 
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to the first vertex 
 * of the Hamiltonian Path. 
 * Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then print the path
 */
package geekforgeeks;

public class HamiltonianCycle {

	public void findCycle(int g[][]){
		int v = g.length;
		int path[] = new int[v];
		boolean visited[] = new boolean[v];
		boolean result = findCycleUtil(g,path,visited,0,0);
		if(result){
			System.out.println("Hamiltonian cycle exists");
			for(int i:path){
				System.out.print(i+"-->");
			}
			System.out.println(path[0]);
		}else{
			System.out.println("No Hamiltonian cycle");
		}
	}
	public boolean findCycleUtil(int g[][],int path[],boolean visited[],int v,int count){
		if(count == path.length-1){
			if(!visited[v]){
				if(g[v][path[0]] == 1){
					path[count] = v;
					visited[v] = true;
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			if(!visited[v]){
				path[count] = v;
				visited[v] = true;
				count++;
				boolean res = false;
				for(int i=0;i<g[v].length;i++){
					if(g[v][i] == 1){
						res = findCycleUtil(g, path, visited, i, count);
					}
					if(res){
						return true;
					}
				}
				if(!res){
					return false;
				}
			}else{
				return false;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		HamiltonianCycle hc = new HamiltonianCycle();
		
		/* Let us create the following graph
        (0)--(1)--(2)
         |   / \   |
         |  /   \  |
         | /     \ |
        (3)-------(4)    */
     int graph1[][] = {
    	 {0, 1, 0, 1, 0},
         {1, 0, 1, 1, 1},
         {0, 1, 0, 0, 1},
         {1, 1, 0, 0, 1},
         {0, 1, 1, 1, 0}
     };

     // Print the solution
     hc.findCycle(graph1);

     /* Let us create the following graph
        (0)--(1)--(2)
         |   / \   |
         |  /   \  |
         | /     \ |
        (3)       (4)    */
     int graph2[][] = {
    	 {0, 1, 0, 1, 0},
         {1, 0, 1, 1, 1},
         {0, 1, 0, 0, 1},
         {1, 1, 0, 0, 0},
         {0, 1, 1, 0, 0}
     };
     hc.findCycle(graph2);
     /* Let us create the following graph
     (0)--(1)--(2)
          / \   |
         /   \  |
        /     \ |
     (3)-------(4)   
     
      */
     int graph3[][] = {
        	 {0, 1, 0, 0, 0},
             {1, 0, 1, 1, 1},
             {0, 1, 0, 0, 1},
             {0, 1, 0, 0, 1},
             {0, 1, 1, 1, 0}
         };
     hc.findCycle(graph3);
	}

}
