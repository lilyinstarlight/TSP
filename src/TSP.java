import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TSP {
	public static void main(String[] args) {
		File file;
		if(args.length > 0) {
			file = new File(args[0]);
		}
		else {
			JFileChooser chooser = new JFileChooser();

			int response = chooser.showOpenDialog(null);
			if(response != JFileChooser.APPROVE_OPTION)
				return;

			file = chooser.getSelectedFile();
		}

		RandomAccessFile reader = null;
		try {
			reader = new RandomAccessFile(file, "r");
		}
		catch(IOException e) {
			alert("Error loading file " + e);
			System.exit(1);
		}


		int lines = 0;
		try {
			while(reader.readLine() != null)
				lines++;
			reader.seek(0);
		}
		catch(IOException e) {
			alert("Error reading file " + e);
			System.exit(1);
		}

		ArrayList<String> location_names = new ArrayList<String>(lines);
		double[][] locations = new double[lines][lines];

		try {
			String line;
			while((line = reader.readLine()) != null) {
					String[] distance = line.split("\t");

					if(!location_names.contains(distance[0]))
						location_names.add(distance[0]);
					if(!location_names.contains(distance[1]))
						location_names.add(distance[1]);

					locations[location_names.indexOf(distance[0])][location_names.indexOf(distance[1])] = Double.parseDouble(distance[2]);
					locations[location_names.indexOf(distance[1])][location_names.indexOf(distance[0])] = Double.parseDouble(distance[2]);
			}

			reader.close();
		}
		catch(Exception e) {
			alert("Error parsing data " + e);
			System.exit(1);
		}

		Solver solver = new Solver();
		int[] path = solver.calculate(locations);

		String message = location_names.get(path[0]);
		for(int i = 1; i < path.length; i++) {
			message += " to " + location_names.get(path[i]);
		}
		alert(message);
	}

	private static void alert(String message) {
		if(GraphicsEnvironment.isHeadless())
			System.out.println(message);
		else
			JOptionPane.showMessageDialog(null, message);
	}
}
