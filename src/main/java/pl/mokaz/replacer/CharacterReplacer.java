package pl.mokaz.replacer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a string write a program to generate all the possible
// strings by replacing ? with 0 or 1. Example: input: a?b?,
// output: a0b1, a1b0, a1b1, a0b0.

public class CharacterReplacer implements Replacer {

	private static final String ANY_STRINGS = ".*";
	
	private static String CHAR_TO_REPLACE = "\\?";
	private List<String> REPLACE_WITH = Arrays.asList("0", "1");
	
	//possible extension - replace ? with other char or Strings and "0" and "1" with
	//other chars or Strings with different size by setter or method arguments.
	
	
	@Override
	public List<String> createAndReplace(String input) {
		List<String> result = new ArrayList<>();
		
		if(input == null || input.isEmpty()) {
			//strict validation is not necessary so empty list can be returned
			return result;
		}
		
		if (input.matches(ANY_STRINGS + CHAR_TO_REPLACE + ANY_STRINGS)) {
			List<String> partiallyChangedElements = new ArrayList<>();
			for (String replaceWith : REPLACE_WITH) {
				partiallyChangedElements.add(input.replaceFirst(CHAR_TO_REPLACE, replaceWith));
			}
			for (String partialyChanged : partiallyChangedElements) {
				result.addAll(createAndReplace(partialyChanged));
			}
		} else {
			result.add(input);
		}
		
		return result;
	}

}
