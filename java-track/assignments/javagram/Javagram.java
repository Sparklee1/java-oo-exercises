package javagram;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import javagram.filters.*;

public class Javagram {



	private static int displayFilterMenu(Scanner in){
		System.out.println ("Please select a filter");
		System.out.println ("Enter 1 for Red filter");
		System.out.println ("Enter 2 for Grayscale filter");
		System.out.println ("Enter 3 for Blue filter");
		int filterID = in.nextInt();
		return filterID;
	}

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Filter filter = null;		
		Picture picture = null;
		int ID = 0;
		Scanner in = new Scanner(System.in);


		// prompt user for image to filter and validate input
		do {

			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				String[] relPathParts = relPath.split("////");
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while(picture == null);

		// TODO - prompt user for filter and validate input	
		do{
		try {
			ID = displayFilterMenu(in);

			// TODO - pass filter ID int to getFilter, and get an instance of Filter back 

			filter = getFilter(ID);	

		}catch (IllegalArgumentException e){
			System.out.println("Invalid selection, please try again: ");
		}
		}
		while(filter == null);

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");

		boolean save = false;
		String fileName;
		
		// save image, if desired
		do{
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			fileName = in.next();

			
			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original

			if (!(fileName.equals(relPath))){
				save = true;
			}
			else{
				System.out.println("Are you sure you want to replace the original picture with the filtered picture?");
				System.out.println("Please type yes to confirm");
				String response = in.next();


				if (response.equals ("yes")){
					save = true;
				}
			}
		}while (save == false);
			
			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
			} else {
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}	

			// close input scanner
			in.close();
		}


		// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
		// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
		private static Filter getFilter(int ID) {
			Filter filter = null;
			if (ID < 0 || ID > 3){
				throw new IllegalArgumentException();
			} 
			if (ID == 1){
				filter = new RedFilter();
			}
			if (ID == 2){
				filter = new GrayscaleFilter();
			}
			if (ID == 3){
				filter = new BlueFilter();
			}

			// TODO - create some more filters, and add logic to return the appropriate one
			return filter;

		}

	}
