import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TSP {
	public static void main(String[] args) {
		System.out.println("¡plɹoM ollǝH");

		JFileChooser chooser = new JFileChooser();

		int response = chooser.showOpenDialog(null);
		if(response != JFileChooser.APPROVE_OPTION)
			return;

		File file = chooser.getSelectedFile();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		}
		catch(IOException e) {
			alert("Error loading file");
			System.exit(1);
		}

		ArrayList<String> location_names = new ArrayList<String>();
		ArrayList<ArrayList<Double>> locations = new ArrayList<ArrayList<Double>>();

		try {
			String line;
			while((line = reader.readLine()) != null) {
					String[] distance = line.split("\t");

					if(!location_names.contains(distance[0]))
						location_names.add(distance[0]);
					if(!location_names.contains(distance[1]))
						location_names.add(distance[1]);

					locations.get(location_names.indexOf(distance[0])).set(location_names.indexOf(distance[1]), Double.parseDouble(distance[2]));
			}

			reader.close();
		}
		catch(Exception e) {
			alert("Error parsing data");
			System.exit(1);
		}
	}

	private static void alert(String message) {
		if(GraphicsEnvironment.isHeadless())
			System.out.println(message);
		else
			JOptionPane.showMessageDialog(null, message);
	}
}
