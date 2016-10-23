package com.mortgeasy.util;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StringUtils {

	public static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().length() == 0 || string.equalsIgnoreCase("null");
	}

	public static String join(String[] itens, String delimiter) {
		return join(Arrays.asList(itens), delimiter);	
	}
	
	public static String join(Collection<String> itens, String delimiter) {
		
		if (itens == null || itens.isEmpty()) return "";
		
		Iterator<String> iter = itens.iterator();
		
		StringBuilder builder = new StringBuilder(iter.next());

		while(iter.hasNext()) {
			builder.append(delimiter).append(iter.next());
		}
		
		return builder.toString();
	}
	
	public static String firstToLowerCase(String str) {
		return !isNullOrEmpty(str) ? str.substring(0,1).toLowerCase() + str.substring(1) : "";
	}

	public static String firstToUpperCase(String str) {
		return !isNullOrEmpty(str) ? str.substring(0,1).toUpperCase() + str.substring(1) : "";
	}
	
	public static String removeTudoQueNaoEhNumero(String string){
		if (!StringUtils.isNullOrEmpty(string)) {
			return string.replaceAll("[^0-9]",	"");
		}
		return string;
	}
	
	public static String substituiCaracteresAcentuados(String string) {
		  
		String[][] caracteresAcento = {  
			{"�?", "A"}, {"á", "a"},  
			{"É", "E"}, {"é", "e"},  
			{"�?", "I"}, {"í", "i"},  
			{"Ó", "O"}, {"ó", "o"},  
			{"Ú", "U"}, {"ú", "u"},  
			{"À", "A"}, {"à", "a"},  
			{"È", "E"}, {"è", "e"},  
			{"Ì", "I"}, {"ì", "i"},  
			{"Ò", "O"}, {"ò", "o"},  
			{"Ù", "U"}, {"ù", "u"},  
			{"Â", "A"}, {"â", "a"},  
			{"Ê", "E"}, {"ê", "e"},  
			{"Î", "I"}, {"î", "i"},  
			{"Ô", "O"}, {"ô", "o"},  
			{"Û", "U"}, {"û", "u"},  
			{"Ä", "A"}, {"ä", "a"},  
			{"Ë", "E"}, {"ë", "e"},  
			{"�?", "I"}, {"ï", "i"},  
			{"Ö", "O"}, {"ö", "o"},  
			{"Ü", "U"}, {"ü", "u"},  
			{"Ã", "A"}, {"ã", "a"},
			{"Õ", "O"}, {"õ", "o"},
			{"Ç", "C"}, {"ç", "c"},  
		};  

		for (int i = 0; i < caracteresAcento.length; i++) {
			string = string.replaceAll(caracteresAcento[i][0], caracteresAcento[i][1]);  
		}
		
		return string;
	}
	
	public static String removeTudoQueNaoEhNumeroEhCaractere(String string) {
		if (!StringUtils.isNullOrEmpty(string)) {
			return string.replaceAll("[^0-9a-zA-Z]","");
		}
		return string;
	}
	
	public static String substituiCaracteresAcentuadosPorNaoAcentuados(String string) {
		CharSequence cs = new StringBuilder(string);  
		return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	public static boolean isNullOrEmpty(char[] password) {
		return (password == null || password.length == 0);
	}
	
	public static String extract(String value, String left, String right, boolean addLimit) {
		
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}

		String valuelc = value.toLowerCase();
		left = left.toLowerCase();
		
		int ib = valuelc.indexOf(left);
				
		if (ib != -1) {
			
			right = right.toLowerCase();
			
			int ie = valuelc.indexOf(right);
			
			if (ie != -1) {				
				return addLimit ? value.substring(ib, ie + right.length()) : value.substring(ib + left.length(), ie);
			}
		}
		
		return null;
	}
	
	public static String obtemIniciais(String source) {
		String trimmed = fullTrim(source);
		String[] tokens = trimmed.split(" ");
		StringBuilder sb = new StringBuilder(tokens.length * 3);
		boolean first = true;
		for (String t : tokens) {
			if (!first) {
				sb.append(" ");
			}
			sb.append(t.toUpperCase().charAt(0));
			sb.append(".");
			first = false;
		}
		return sb.toString();
	}
	
	/**
	 * Suprime todos os caracteres vazios à esquerda do texto de origem.
	 * 
	 * @param source
	 *            o texto do qual serão suprimidos os caracteres vazios à
	 *            esquerda
	 * @return o texto txt, suprimidos os caracteres vazios à esquerda
	 */
	public static String trimLeft(String source) {
		return source.replaceAll("^\\s+", "");
	}

	/**
	 * Suprime todos os caracteres vazios à direita do texto de origem.
	 * 
	 * @param source
	 *            o texto do qual serão suprimidos os caracteres vazios à
	 *            direita
	 * @return o texto source, suprimidos os caracteres vazios à direita
	 */
	public static String trimRight(String source) {
		return source.replaceAll("\\s+$", "");
	}

	/**
	 * Substitui todos os espaços múltiplos existentes no interior de um texto
	 * por um único espaço.
	 * 
	 * @param source
	 *            o texto do qual serão suprimidos os caracteres vazios
	 *            duplicados
	 * @return o texto source, suprimidos os caracteres vazios duplicados
	 */
	public static String trimInside(String source) {
		return source.replaceAll("\\b\\s{2,}\\b", " ");
	}

	/**
	 * Substitui todos os espaços vazios à direita e à esquerda de um texto
	 * dado, assim como aqueles duplicados existentes em seu interior.
	 * 
	 * @param source
	 *            o texto do qual serão suprimidos os caracteres vazios
	 *            supérfluos.
	 * @return o texto source, suprimidos os caracteres vazios supérfluos
	 */
	public static String fullTrim(String source) {
		return trimInside(trimBorders(source));
	}
	
	/**
	 * Substitui todos os espaços vazios à direita e à esquerda de um texto
	 * dado.
	 * 
	 * @param source
	 *            o texto do qual serão suprimidos os caracteres vazios à
	 *            esquerda e à direita.
	 * @return o texto source, suprimidos os caracteres vazios à esquerda e à
	 *         direita.
	 */
	public static String trimBorders(String source) {
		return trimLeft(trimRight(source));
	}
	
	public static String lista(List<String> concreteData, String separador, boolean conectorFinal){
		
		StringBuilder retorno = new StringBuilder();
		
		if(concreteData != null && !concreteData.isEmpty()){
			for(int i = 0; i < concreteData.size(); i++){
				retorno.append(concreteData.get(i));
				if(i < (concreteData.size() - 2) || !conectorFinal){
					retorno.append(separador);
				} else if(i == (concreteData.size() - 2) && conectorFinal){
					retorno.append(" e ");
				} 
			}
				
		}
		
		return retorno.toString();
	}
}