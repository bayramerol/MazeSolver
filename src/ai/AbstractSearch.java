package ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class AbstractSearch {

	protected Pair startNode;
	protected Room[][] rooms = new Room[8][8];
	protected List<Room> visitedList = new ArrayList<Room>();
	
	public AbstractSearch() {
		this.startNode = new Pair(0, 0);
	}
	
	
	/*
	 * Creates maze from the file name. Default file name is maze.txt.
	 * sample row of maze is 1001-1100-1001-1010-1000-1010-1010-1100
	 * order of each column is N-E-S-W
	 * 1 means no move, 0 can move
	 */
	public void createRooms(){
		this.createRooms("input/maze.txt");
	}
	
	public void createRooms(String fileName){
		
		File file = new File(fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split("-");
				
				for (int i=0; i<columns.length; i++) {
					rooms[row][i] = new Room(columns[i], row, i);
				}
				row++;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		rooms[7][7].goal1 = true;
		rooms[6][4].goal2 = true;
		rooms[7][4].goal3 = true;
		rooms[5][6].goal4 = true;
		rooms[2][5].trap1=true;
		rooms[1][2].trap2=true;
		rooms[4][3].trap3=true;
		rooms[5][2].trap4=true;
		rooms[5][4].trap5=true;
		rooms[6][5].trap6=true;
		rooms[6][7].trap7=true;
		
	}
	
	
	/*
	 * Prints the output to file.
	 * Each algorithm's output place in distinct files.
	 * File will place under output/alg.txt file.
	 * 
	 */
	public void printSolution(String alg, Room r){
		File file = new File("output/"+alg+".txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
			pw.append("Solution Path:\n" );
			int totalCost = 1;
			totalCost = printSolutionPath(r, pw, totalCost);
			pw.append("Solution Cost: "+totalCost+"\n");
			
			pw.append("Expanded Path\n");
			printVisited(pw, visitedList);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void printVisited(PrintWriter pw, List<Room> visited) {
		for (Room room : visited) {
			pw.append("x: "+(room.current.x+1)+"\ty: "+(room.current.y+1)+"\n");
		}
	}


	public int printSolutionPath(Room r, PrintWriter pw, Integer totalCost){
		pw.append("x: "+(r.current.x+1)+"\ty: "+(r.current.y+1)+"\n");
		if(r.parent != null)
			
			if(r.trap1 || r.trap2 || r.trap3 || r.trap4 || r.trap5 || r.trap6 || r.trap7){
				
				totalCost = printSolutionPath(rooms[r.parent.x][r.parent.y], pw, totalCost=totalCost+4);
			}else{
			
			totalCost = printSolutionPath(rooms[r.parent.x][r.parent.y], pw, ++totalCost);
			}
			
		return totalCost;
	}
}
