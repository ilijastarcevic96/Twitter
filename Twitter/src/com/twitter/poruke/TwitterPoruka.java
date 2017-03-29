package com.twitter.poruke;


/**
 * Ova klasa opisuje poruku na drustvenoj mrezi Twitter
 * @author Ilija Starcevic
 * @version 1.0
 *
 */
public class TwitterPoruka {
	
	/**
	 * Atribut koji predstavlja ime korisnika kao String.
	 */
	private String korisnik;
	
	/**
	 * Atribut koji predstavlja sadrzaj poruke na Twitteru kao String.
	 */
	private String poruka;
	
	/**
	 * Metoda koja vraca naziv korisnika.
	 * @return trenutni naziv korisnika.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda koja postavlja novu vrednost u atribut korisnik
	 * @param korisnik prestavlja String koji zelimo da bude naziv korisnika
	 * @throws java.lang.RuntimeException u slucaju kada je parametar:
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.isEmpty())
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca tekst poruke.
	 * @return tekst poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda koja postavlja novu vrednost u atribut poruka
	 * @param poruka predstavlja tekst poruke
	 * @throws java.lang.RuntimeException  ukoliko je poruka:
	 * <ul>
	 * 		<li>null</li>
	 * 		<li>prazan String</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.equals("") ||
				poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
