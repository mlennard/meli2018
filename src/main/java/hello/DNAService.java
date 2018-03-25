package hello;

import org.springframework.stereotype.Service;

@Service
public class DNAService {
	
	public Boolean isMutant(DNA dna) {
		//Trasnform DNA into char[][]
		char[][] seq = transformDNAIntoSequence(dna);
		
		return checkDNA(seq);
	}
	
	private char[][] transformDNAIntoSequence(DNA dna){
		int dimension = dna.getDna().length;
		char[][] sequence = new char[dimension][dimension];
		
		for(int i=0; i<dna.getDna().length; i++ ) {
			String row = dna.getDna()[i];
			char[] rowSequence = row.toCharArray();
			System.out.println(rowSequence);
			for (int j = 0; j < rowSequence.length; j++) {
				sequence[i][j] = rowSequence[j];
			}
		}
		
		return sequence;
	}
	
	
	private boolean checkDNA(char[][] sequence) {
	    final int height = sequence.length;
	    final int width = sequence[0].length;
	    for (int x = 0; x < height; x++) { // itero las filas 
	        for (int y = 0; y < width; y++) { // itero las columnas
	            char base = sequence[x][y];

	            // Verifico cadena horizontal	
	            if (y + 3 < width &&  
	                base == sequence[x][y+1] && 
	                base == sequence[x][y+2] &&
	                base == sequence[x][y+3])
	                return true;
	            //Verifico cadena vertical o diagonales
	            if (x + 3 < height) {
	            	//Verifico cadena vertical
	                if (base == sequence[x+1][y] && 
	                    base == sequence[x+2][y] &&
	                    base == sequence[x+3][y])
	                    return true;
	                //Verifico cadena diagonal hacia la derecha
	                if (y + 3 < width &&
	                    base == sequence[x+1][y+1] && 
	                    base == sequence[x+2][y+2] &&
	                    base == sequence[x+3][y+3])
	                    return true;
	                //Verifico cadena diagonal hacia la izquierda
	                if (y - 3 >= 0 &&
	                    base == sequence[x+1][y-1] && 
	                    base == sequence[x+2][y-2] &&
	                    base == sequence[x+3][y-3])
	                    return true;
	            }
	        }
	    }
	    return false; // no hay secuencia de 4 posiciones consecutivas
	}
	
}
