import java.awt.geom.Point2D;

/**
 * City class that represents a city by a point and a name
 */
public class City extends Point2D.Double {
	private String name;

	/**
	 * Constructs a city by point data and name
	 *
	 * @param name The city name
	 * @param x The x-coordinate
	 * @param y The y-coordinate
	 */
	public City(String name, double x, double y) {
		super(x, y);
		this.name = name;
	}

	/**
	 * Gets the city's name
	 *
	 * @return The city's name
	 */
	public String getName() {
		return name;
	}
}
