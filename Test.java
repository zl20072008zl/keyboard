package main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sample Transformations");
		String transformationTest = scanner.nextLine().replaceAll(" ", "");
		String [] transformationValues = transformationTest.toUpperCase().split(",");
		
		System.out.println("Sample Input text:");
		String inputtedText = scanner.nextLine();
		
		
		String [] txt = inputtedText.toLowerCase().split("");
		List<String> outputTxt = Arrays.asList(txt);
		Keyboard keyboard = new Keyboard();
		
		for(int i = 0; i < transformationValues.length; i++) {
			if(transformationValues[i] == "H" || "H".equals(transformationValues[i])) {
				keyboard.horizontalFlip(outputTxt);
				outputTxt = keyboard.horizontalFlipValue;
			}else if(transformationValues[i] == "V" || "V".equals(transformationValues[i])) {
				keyboard.verticalFlip(outputTxt);
				outputTxt = keyboard.verticalFlipValue;
			}else  {
				int linearShiftValue = Integer.parseInt(transformationValues[i]);
				keyboard.linearShift(outputTxt, linearShiftValue);
				outputTxt = keyboard.linearShiftValue;
			}
		}
		for (String output : outputTxt) {
			System.out.print(output);
		}
		
	}
}
