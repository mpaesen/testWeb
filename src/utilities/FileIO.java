/* Generated by Together */

package utilities;

import java.io.*;

/** @stereotype utility */

/** handles normal textfile IO */
public class FileIO {
	/**
	 * haalt een input file op mbv een opgegeven path
	 * 
	 * @param file
	 *            (+eventueel het absolute path)
	 * @return BufferedReader (text file)
	 */
	public static BufferedReader getInputFileByName(String file)
			throws FileNotFoundException {
		// if (inputFile == null)
		inputFile = new BufferedReader(new FileReader(file));
		return inputFile;
	}

	/**
	 * haalt een output file op mbv een opgegeven path
	 * 
	 * @param file
	 *            (+eventueel het absolute path)
	 * @return BufferedWriter (text file)
	 */
	public static BufferedWriter getOutputFileByName(String file)
			throws IOException, FileNotFoundException {
		// if (outputFile == null)
		outputFile = new BufferedWriter(new FileWriter(file));
		return outputFile;
	}

	public static ObjectOutputStream getObjectOutputStream(
			String outputStreamFile) throws IOException {
		// if(outputStream == null)
		outputStream = new ObjectOutputStream(new FileOutputStream(
				outputStreamFile));
		return outputStream;
	}

	public static ObjectInputStream getObjectInputStream(String inputStreamFile)
			throws IOException {
		// if(inputStream == null)
		inputStream = new ObjectInputStream(
				new FileInputStream(inputStreamFile));
		return inputStream;
	}

	private static BufferedReader inputFile;
	private static BufferedWriter outputFile;
	private static ObjectOutputStream outputStream;
	private static ObjectInputStream inputStream;
}
