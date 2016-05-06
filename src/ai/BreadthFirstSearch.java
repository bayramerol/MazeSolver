package ai;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends AbstractSearch {

	public BreadthFirstSearch(Pair startNode) {
		this.startNode = startNode;
		createRooms();
	}
	
	public void bfs(){
		Queue<Room> queue = new LinkedList<Room>();
		queue.add(rooms[startNode.x][startNode.y]);
		
		while (!queue.isEmpty()) {
			Room r = queue.remove();
			visitedList.add(r);
			System.out.println("Room x:"+(r.current.x+1)+"  y:"+(r.current.y+1));
			if (r.goal1 || r.goal2 || r.goal3 || r.goal4) {
				printSolution("bfs", r);
				return;
			}
			if (r.n && !visitedList.contains(rooms[r.current.x-1][r.current.y]) && !queue.contains(rooms[r.current.x-1][r.current.y])) {
				rooms[r.current.x-1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				if (rooms[r.current.x-1][r.current.y].goal1 || rooms[r.current.x-1][r.current.y].goal2 || 
						rooms[r.current.x-1][r.current.y].goal3 || rooms[r.current.x-1][r.current.y].goal4) {
					printSolution("bfs", rooms[r.current.x-1][r.current.y]);
					return;
				}
				queue.add(rooms[r.current.x-1][r.current.y]);
				}
			if (r.e && !visitedList.contains(rooms[r.current.x][r.current.y+1]) && !queue.contains(rooms[r.current.x][r.current.y+1])) {
				rooms[r.current.x][r.current.y+1].parent = new Pair(r.current.x, r.current.y);
				if (rooms[r.current.x][r.current.y+1].goal1 || rooms[r.current.x][r.current.y+1].goal2
						|| rooms[r.current.x][r.current.y+1].goal3 || rooms[r.current.x][r.current.y+1].goal4) {
					printSolution("bfs",rooms[r.current.x][r.current.y+1]);
					return;
				}
				queue.add(rooms[r.current.x][r.current.y+1]);
				}
			if (r.s && !visitedList.contains(rooms[r.current.x+1][r.current.y]) && !queue.contains(rooms[r.current.x+1][r.current.y])) {
				rooms[r.current.x+1][r.current.y].parent = new Pair(r.current.x, r.current.y);
				if (rooms[r.current.x+1][r.current.y].goal1 || rooms[r.current.x+1][r.current.y].goal2 
						|| rooms[r.current.x+1][r.current.y].goal3 || rooms[r.current.x+1][r.current.y].goal4) {
					printSolution("bfs",rooms[r.current.x+1][r.current.y]);
					return;
				}
				queue.add(rooms[r.current.x+1][r.current.y]);
				}
			if (r.w && !visitedList.contains(rooms[r.current.x][r.current.y-1]) && !queue.contains(rooms[r.current.x][r.current.y-1])) {
				rooms[r.current.x][r.current.y-1].parent = new Pair(r.current.x, r.current.y);
				if (rooms[r.current.x][r.current.y-1].goal1 || rooms[r.current.x][r.current.y-1].goal2
						|| rooms[r.current.x][r.current.y-1].goal3 || rooms[r.current.x][r.current.y-1].goal4) {
					printSolution("bfs",rooms[r.current.x][r.current.y-1]);
					return;
				}
				queue.add(rooms[r.current.x][r.current.y-1]);
				}
		}
	}
	
}
