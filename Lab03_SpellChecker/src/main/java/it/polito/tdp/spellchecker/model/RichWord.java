package it.polito.tdp.spellchecker.model;

public class RichWord {

	String parola;
	boolean corretta;
	
	
	public RichWord(String parola) {
		this.parola = parola;
	}
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorretta() {
		return corretta;
	}
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	
}
