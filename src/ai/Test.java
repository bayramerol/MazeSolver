package ai;

public class Test {

	public static void main(String[] args) {
		
		Pair startNode = new Pair(2, 1);
		
		
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(startNode);
		bfs.bfs();
		
		
		UniformCostSearch uniform = new UniformCostSearch(startNode);
		uniform.uniform();
		
		
		DepthFirstSearch dfs = new DepthFirstSearch(startNode);
		dfs.dfs();
		
		
		
		IterativeDeepeningSearch ids = new IterativeDeepeningSearch(startNode);
		ids.ids();
		
	
		AStarSearch aStar = new AStarSearch(startNode);
		aStar.astar();
		
	}
	
}
