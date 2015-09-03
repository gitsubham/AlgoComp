package org.learn.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.learn.algorithms.core.Constants;
import org.learn.algorithms.sort.BubbleSort;
import org.learn.algorithms.sort.Sort;

public class DriverClass {

	 /*Actions -
	 1. This method will set a data structure from the input file.
	 2. Call the function to implement algorithm.
	 3. Call another method to validate the output
	 4. Log the observations in a file.*/
	
	public static void main(String[] args) {
		FileInputStream fin = null;
		Boolean sortValidated=false;
		String workingdir = System.getProperty("user.dir");
		String resourcesDirAbsPath = workingdir + "\\" + Constants.RESOURCE_DIR;
		//System.out.println(resourcesDirAbsPath);
		String unsortedDatasetPath = resourcesDirAbsPath + "\\" + Constants.UNSORTED_DATASET_BUBBLE_SORT;
		try {
			fin = new FileInputStream(unsortedDatasetPath);
			System.out.println("Reading file of size" + fin.available());
			Sort sort = new BubbleSort();
			List<Integer> unsortedModel = sort.makeUnsortedModel(fin);
			List<Integer> sortedModel=sort.sort(unsortedModel);
			sortValidated=sort.validateOutput(unsortedModel, sortedModel);
			if (sortValidated) {
				System.out.println("[INFO]: Sort method implemented worked correctly");
			} else {
				System.out.println("[ERROR]: Sort method implemented worked incorrectly");
			}
			sort.printSortedModel(sortedModel);
		} catch (FileNotFoundException e) {
			System.out.println("File " + unsortedDatasetPath + " not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null)
					fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
