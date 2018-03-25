package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {
    
	@Autowired
	private DNAService dnaService;
	
    @RequestMapping(method=RequestMethod.POST, value="/mutant", consumes="application/json", produces="application/json")
    public ResponseEntity<Boolean> mutant(@RequestBody DNA input) {
    	if(dnaService.isMutant(input)) {
    		return ResponseEntity.ok(Boolean.TRUE);
    	}else {
    		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    	}	
    }
}
