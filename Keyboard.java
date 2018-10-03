package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Keyboard {

	static List<String> row1 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
	static List<String> row2 = Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p");
	static List<String> row3 = Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l", ";");
	static List<String> row4 = Arrays.asList("z", "x", "c", "v", "b", "n", "m", ",", ".", "/");
	List<String> allRows = new ArrayList<String>();
	
	List<String> horizontalFlipValue;
	List<String> verticalFlipValue;
	List<String> linearShiftValue;
	
	//final text output array
	List<String> outputTxt;
	//place in array variable
	int charactersPlaceInArray;
	
//	public Keyboard() {
//		this.horizontalFlipValue = new String[10];
//		this.verticalFlipValue = new String[10];
//		this.linearShiftValue = new String[10];
//	}
	
	
	
	public static <T> T[] concatAll(T[] first, T[]... rest) {  
		int totalLength = first.length;  
		for (T[] array : rest) {    
			totalLength += array.length;  
		}  
		T[] result = Arrays.copyOf(first, totalLength);  
		int offset = first.length;  
		for (T[] array : rest) {    
			System.arraycopy(array, 0, result, offset, array.length);    
			offset += array.length;  
		}  
		return result;
	}

	public void horizontalFlip(List<String> outputTxt) {
		this.horizontalFlipValue = new ArrayList<String>();
		for(int i = 0; i < outputTxt.size(); i++) {
			if(row1.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row1.indexOf(outputTxt.get(i));
				this.horizontalFlipValue.add(row1.get((row1.size() - 1) - this.charactersPlaceInArray));
			}else if(row2.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row2.indexOf(outputTxt.get(i));
				this.horizontalFlipValue.add(row2.get((row2.size() - 1) - this.charactersPlaceInArray));
			}else if(row3.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row3.indexOf(outputTxt.get(i));
				this.horizontalFlipValue.add(row3.get((row3.size() - 1) - this.charactersPlaceInArray));
			}else if(row4.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row4.indexOf(outputTxt.get(i));
				this.horizontalFlipValue.add(row4.get((row4.size() - 1) - this.charactersPlaceInArray));
			}

		}
		outputTxt = this.horizontalFlipValue;
	}

	public void verticalFlip(List<String> outputTxt) {
		this.verticalFlipValue = new ArrayList<String>();
		for(int i = 0; i < outputTxt.size(); i++) {
			if(row1.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row1.indexOf(outputTxt.get(i));
				this.verticalFlipValue.add(row1.get((row1.size() - 1) - this.charactersPlaceInArray));
			}else if(row2.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row2.indexOf(outputTxt.get(i));
				this.verticalFlipValue.add(row2.get((row2.size() - 1) - this.charactersPlaceInArray));
			}else if(row3.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row3.indexOf(outputTxt.get(i));
				this.verticalFlipValue.add(row3.get((row3.size() - 1) - this.charactersPlaceInArray));
			}else if(row4.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = row4.indexOf(outputTxt.get(i));
				this.verticalFlipValue.add(row4.get((row4.size() - 1) - this.charactersPlaceInArray));
			}

		}
		outputTxt = this.verticalFlipValue;
	}
	
	public void linearShift(List<String> outputTxt, int linearShiftValue) {
		this.linearShiftValue = new ArrayList<String>();
		allRows.addAll(row1);
		allRows.addAll(row2);
		allRows.addAll(row3);
		allRows.addAll(row4);
		for(int i = 0; i < outputTxt.size(); i++) {
			if(allRows.contains(outputTxt.get(i))) {
				this.charactersPlaceInArray = allRows.indexOf(outputTxt.get(i));
				if(linearShiftValue < 0 || linearShiftValue == 0) {
					if((linearShiftValue % 40) == 0) {
						this.linearShiftValue.add(allRows.get(this.charactersPlaceInArray));
					}else {
						if((this.charactersPlaceInArray + (linearShiftValue)% 40) < 0) {
							this.linearShiftValue.add(allRows.get(allRows.size() + ( this.charactersPlaceInArray + (linearShiftValue % 40))));
						}else {
							this.linearShiftValue.add(allRows.get(this.charactersPlaceInArray + ( linearShiftValue % 40)));
						}
					}
				}else if(linearShiftValue > 0) {
					this.linearShiftValue.add(allRows.get((this.charactersPlaceInArray + ( linearShiftValue % 40)) % 40));
				}
			}else {
				this.linearShiftValue.add(outputTxt.get(i));
			}

		}
		outputTxt = this.linearShiftValue;
	}
	
}
