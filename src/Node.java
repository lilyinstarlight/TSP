public class Node {
	public Node parent;
	private double parent_cost;
	private int index;
	private int[] constraints;

	public Node left;
	public Node right;

	public Node(Node parent, double parent_cost, int index, int[] constraints) {
		this.parent = parent;
		this.parent_cost = parent_cost;
		this.index = index;
		this.constraints = constraints;
		left = null;
		right = null;
	}

	public boolean isTerminal() {
		return left == null && right == null;
	}

	public double getLowerBound() {
	}

	public double getCost() {
		if(parent == null)
			return parent_cost;

		return parent_cost + parent.getCost();
	}
}
