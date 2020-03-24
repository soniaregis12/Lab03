package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Model {
	
	private List<String> paroleInglese = new LinkedList<String>();
	private List<String> paroleItaliano = new LinkedList<String>();
	private List<RichWord> richWords = new LinkedList<RichWord>();

	
	public void loadDictionary(String language) {
		
		if(language.equals("English")) {
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					paroleInglese.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		
		if(language.equals("Italian")) {
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					paroleItaliano.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList, String lingua){
		
		this.richWords.clear();
		
		for(String s : inputTextList) {
			RichWord rw = new RichWord(s);
			if(lingua.equals("English")){
				if(this.paroleInglese.contains(s.toLowerCase()) || this.paroleInglese.contains(s.toUpperCase()) ) {
					rw.setCorretta(true);
				}else {
					this.richWords.add(rw);
					rw.setCorretta(false);
				}
			}else if (lingua.equals("Italian")){
				if(this.paroleItaliano.contains(s.toLowerCase()) || this.paroleItaliano.contains(s.toUpperCase())) {
					rw.setCorretta(true);
				}else {
					this.richWords.add(rw);
					rw.setCorretta(false);
				}
			}
		}
		return this.richWords;
	}
	
}
