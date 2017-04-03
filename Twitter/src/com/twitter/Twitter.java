package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;


/**
 * Ova klasa predstavlja drustvenu mrezu Twitter
 * @author Ilija Starcevic
 * @version 1.0
 *
 */
public class Twitter {
	
	/**
	 * Atribut poruke predstavlja listu svih poruka na Twitter-u.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	
	/**
	 * Ova metoda vraca listu svih poruka na Twitter-u.
	 * @return lista koja sadrzi sve poruke.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda koja pravi novu poruku na Twitter-u i nju ubacuje u listu svih poruka.
	 * @param korisnik predstavlja ime korisnika koji pise poruku.
	 * @param poruka predstavlja sadrzaj poruke.
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja pretrazuje listu svih poruka na Twitteru, i vraca niz poruka koje sadrze odredjeni tag.
	 * @param maxBroj predstavlja maksimalan broj elemenata niza koji je povratna vrednost.
	 * @param tag predstavlja oznaku koja se pretrazuje u listi poruka.
	 * @return Ova metoda vraca niz poruka koji imaju zadati tag.
	 * @throws java.lang.RuntimeException kada  tag ima vrednosti:
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>Prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 