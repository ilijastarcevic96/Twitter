package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t= new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		
		t.unesi("Ilija", "Program");
		t.unesi("Ilija", "je");
		t.unesi("Ilija", "je kul");
		
		LinkedList<TwitterPoruka> tp = new LinkedList<TwitterPoruka>();
		
		TwitterPoruka t1 = new TwitterPoruka();
		t1.setKorisnik("Ilija");
		t1.setPoruka("Program");
		tp.addLast(t1);
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setKorisnik("Ilija");
		t2.setPoruka("je");
		tp.addLast(t2);
		TwitterPoruka t3 = new TwitterPoruka();
		t3.setKorisnik("Ilija");
		t3.setPoruka("je kul");
		tp.addLast(t3);
		
		if(t.vratiSvePoruke().size() != tp.size()){
			fail("Liste nemaju isti broj elemenata");
		}
		
		for (int i = 0; i < t.vratiSvePoruke().size(); i++) {
			if(!t.vratiSvePoruke().get(i).equals(tp.get(i))){
				fail("Liste nisu iste");
			}
		}
		
		
	}

	@Test
	public void testUnesi() {
		t.unesi("Ilija", "Programiranje je kul.");
		
		if(!t.vratiSvePoruke().getLast().getKorisnik().equals("Ilija") ||
				!t.vratiSvePoruke().getLast().getPoruka().equals("Programiranje je kul.")){
			fail("Metoda nije unela dobrog korisnika ili dobru poruku.");
		}
	}
	
	@Test
	public void testVratiPoruke() {
		t.unesi("Ilija", "Program");
		t.unesi("Ilija", "je");
		t.unesi("Ilija", "je kul");
		
		TwitterPoruka[] tp = new TwitterPoruka[10];
		
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setKorisnik("Ilija");
		t2.setPoruka("je");
		ubaciUNiz(tp, t2);
		TwitterPoruka t3 = new TwitterPoruka();
		t3.setKorisnik("Ilija");
		t3.setPoruka("je kul");
		ubaciUNiz(tp, t3);
		
		assertArrayEquals(tp, t.vratiPoruke(10, "je"));
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(100, "");
	}
	
	private void ubaciUNiz(TwitterPoruka[] tp,TwitterPoruka t){
		for(int i =0; i < tp.length ;i++){
			if(tp[i] == null){
				tp[i] = t;
				return;
			}
		}
	}

}
