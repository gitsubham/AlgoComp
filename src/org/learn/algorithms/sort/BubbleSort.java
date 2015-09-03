package org.learn.algorithms.sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort implements Sort {

	@Override
	public List<Integer> makeUnsortedModel(FileInputStream in) {
		List<Integer> unsortedModel= new ArrayList<>();
		int num;
		
		try {
			while ((num = in.read()) != -1) {
			    unsortedModel.add(num);
			 }
			
		} catch (IOException e) {
			System.out.println("Caught an IOException !");
		}
		return unsortedModel;
	}

	@Override
	public List<Integer> sort(List<Integer> unsortedModel) {
		List<Integer> temp = unsortedModel;
		Integer tempVal=0;
		for (int i=0;i<temp.size();i++){
			for (int j=0;j<temp.size()-1;j++){
				if (temp.get(j).compareTo(temp.get(j+1)) > 0){
					tempVal=temp.get(j);
					temp.set(j,temp.get(j+1));
                    temp.set(j+1,tempVal);
				}
			}
		}
		return temp;
	}

	
	@Override
	public boolean validateOutput(List<Integer> unsortedModel,List<Integer> sortedModel) {
		Collections.sort(unsortedModel);
		if (unsortedModel.equals(sortedModel))
			return true;
		else
			return false;
	}

	@Override
	public void printSortedModel(List<Integer> sortedModel) {
		for(Integer i: sortedModel){
			System.out.println(i);
		} 
	}

}
