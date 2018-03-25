package lennard.meli;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class TestDNAService {

	@Autowired
	private DNAService dnaService;
	
	@Test
	public void testMutantDNA() {
		String[] mutantDNA = {"XTGCXA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		assertTrue("Checking mutant DNA", dnaService.isMutant(mutantDNA));
	}
	
	@Test 
	public void testNonMutantDNA() {
		String[] nonMutantDNA = {"XTGCXA","CAGTGC","TTATGT","AGAAGG","CCGCTA","TCACTG"};
		assertFalse("Checking non mutant DNA", dnaService.isMutant(nonMutantDNA));
	}
	
	@Test(expected=MalFormedDNAException.class)
	public void testMalFormedDNA() {
		String[] invalidDNA = {"TGCXA","CAGTGC","TTATGT","AGAAGG","CCGCTA","TCACTG"};
		dnaService.isMutant(invalidDNA);
	}

}
