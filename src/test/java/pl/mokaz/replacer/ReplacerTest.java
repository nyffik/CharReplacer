package pl.mokaz.replacer;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ReplacerTest {
	
	private CharacterReplacer replacer;
	
	@Before
	public void setUp() {
		replacer = new CharacterReplacer();
	}

	@Test
	public void shouldReturnOneElementWhenQuestionMarkNotExist() {
		
		List<String> result = replacer.change("ab");
		
		assertThat(result).hasSize(1);
		assertThat(result).contains("ab");
	}
	
	@Test
	public void shouldReturn2ElementsFromOneQuestionMark() {
		
		List<String> result = replacer.change("ab?");
		
		assertThat(result).hasSize(2);
		assertThat(result).contains("ab0","ab1");
	}
	
	@Test
	public void shouldReturn4ElementsFrom2QuestionMark() {
		
		List<String> result = replacer.change("a?b?");
		
		assertThat(result).hasSize(4);
		assertThat(result).contains("a0b1", "a1b0", "a1b1", "a0b0");
	}
	
	@Test
	public void shouldReturn8ElementsFrom3QuestionMark() {
	
		List<String> result = replacer.change("a???");
		
		assertThat(result).hasSize(8);
		assertThat(result).contains("a000", "a001", "a010", "a011",
									"a100", "a101", "a110", "a111");
	}
	
	@Test
	public void shouldReturnEmptyListWhenInputIsNull() {
		
		List<String> result = replacer.change(null);
		
		assertThat(result).isEmpty();
	}

}
