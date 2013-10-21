import java.util.HashSet;

/**
 * Solves the traveling salesman problem using Branch and Bound by utilizing Node's
 */
public class Solver {
	double best_cost;
	int[] best_path;

	/**
	 * Calculates the shortest (non-repeating) path between a series of nodes
	 *
	 * @param locations The 2D array of distance between locations
	 * @return An integer array with the indices of the locations
	 */
	public int[] calculate(double[][] locations) {
		//HashSet<Integer> location_set = new HashSet<Integer>(locations.length);
		//for(int location : locations[0])
		//	location_set.add(location)

		best_cost = Double.MAX_VALUE; //findGreedyCost(0, location_set, locations);

		int[] active_set = new int[locations.length];
		for(int i = 0; i < active_set.length; i++)
			active_set[i] = i;

		Node[] root_nodes = new Node[locations.length];
		for(int i = 0; i < root_nodes.length; i++)
			root_nodes[i] = new Node(null, 0, locations, active_set, i);
		
		for(Node root : root_nodes)
			traverse(root);

		return best_path;
	}

	/**
	 * Find the greedy cost for a set of locations
	 *
	 * @param i The current location
	 * @param location_set Set of all remaining locations
	 * @param locations The 2D array containing point distances
	 * @return The greedy cost
	 */
	private double findGreedyCost(int i, HashSet<Integer> location_set, double[][] locations) {
		if(location_set.isEmpty())
			return 0;

		location_set.remove(i);

		double lowest = Double.MAX_VALUE;
		int closest = 0;
		for(int location : location_set) {
			double cost = locations[i][location];
			if(cost < lowest) {
				lowest = cost;
				closest = location;
			}
		}

		return lowest + findGreedyCost(closest, location_set, locations);
	}

	/**
	 * Recursive method to go through the tree finding and pruning paths
	 *
	 * @param parent The root/parent node
	 */
	private void traverse(Node parent) {
		Node[] children = parent.generateChildren();

		for(Node child : children) {
			if(child.isTerminal()) {
				double cost = child.getPathCost();
				if(cost < best_cost) {
					best_cost = cost;
					best_path = child.getPath();
				}
			}
			else if(child.getLowerBound() <= best_cost) {
				traverse(child);
			}
		}
	}
}
