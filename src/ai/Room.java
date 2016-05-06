package ai;

public class Room {

	Pair parent;
	final Pair current;
	boolean goal1,goal2,goal3,goal4,e,w,s,n,trap1,trap2,trap3,trap4,trap5,trap6,trap7;
	
	double cost, manhattonCost; //for uniform cost
	
	public Room(String alias, int x, int y){
		//N,E,S,W
		this.n = (alias.charAt(0)=='0')?true:false;
		this.e = (alias.charAt(1)=='0')?true:false;
		this.s = (alias.charAt(2)=='0')?true:false;
		this.w = (alias.charAt(3)=='0')?true:false;
		this.current = new Pair(x, y);
		cost = 0;
		manhattonCost = Math.sqrt((Math.pow((7-x), 2)+Math.pow((7-y), 2)));
	}
}
