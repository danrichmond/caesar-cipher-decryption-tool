import java.util.*;

/**
 * See if your message was encrypted using the Caesar cipher. This tool uses 
 * brute force to find new strings for all 26 possible shifts. Hopefully one
 * of those shifts will be the one you are looking for! 
 * 
 * @author Danny Richmond
 */
public class CaesarCipherDecryption {

	public static void main(String[] args) {
		
		// Created scanner
		Scanner in = new Scanner(System.in);
		
		// Array list of the alphabet's characters
		ArrayList<Character> alph = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
				't', 'u', 'v', 'w', 'x', 'y', 'z'));		
		
		// Read sentence in from user and split characters into an array
		System.out.print("Enter string: ");
		String str = in.nextLine();
		str = str.toLowerCase();
		System.out.println(str);
		char charArray[] = new char[1000]; // Make bigger if necessary
		str.getChars(0, str.length(), charArray, 0);
		in.close();

		// Find all possible shifts
		for(int shifts = 0; shifts < 26; shifts++) {
			int numberOfShifts = shifts;

			// Create new shifted string
			String afterShift = "";
			int index = 0;
			for(int i = 0; i < str.length(); i++) {
				char currChar = charArray[i];
				if(currChar != ' ') {
					index = alph.indexOf(currChar) + 1;
					int position = (numberOfShifts + index - 1) % 26;
					afterShift += alph.get(position);
				} else {
					afterShift += " ";
				}
			}
			System.out.println("String with " + shifts + " shifts: " + afterShift);
		}
	}
}
