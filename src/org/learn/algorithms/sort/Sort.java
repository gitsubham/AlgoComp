package org.learn.algorithms.sort;

import java.io.FileInputStream;
import java.util.List;

// This interface will act as a contract for the implementation classes.
public interface Sort {

	//public abstract List<E setModel(E datatype, FileInputStream in );
	public abstract List<Integer> makeUnsortedModel(FileInputStream in);
	public abstract List<Integer> sort(List<Integer> unsortedModel);
	public abstract boolean validateOutput(List<Integer> unsortedModel,List<Integer> sortedModel);
	public abstract void printSortedModel(List<Integer> sortedmodel);
}
