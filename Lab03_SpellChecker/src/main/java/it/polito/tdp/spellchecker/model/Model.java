package it.polito.tdp.spellchecker.model;

import java.io.*;

public class Model {
	
	public void loadDictionary(String language) {
		
		
		
		
		try {
			FileReader fr = new FileReader("English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
		try {
			FileReader fr = new FileReader("Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
}
