package pl.mokaz.replacer;

import java.util.List;

public interface Replacer {

	public abstract List<String> createAndReplace(String input);

}