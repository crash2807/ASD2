/*
author: Piotr Jarzynski
S17041
*/

package projekt2asd;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;



public class s17041 {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner skaner=new Scanner(new File(args[0]));
		String[] linia;
		String etykieta;
		String[] umiejscowienie;
		Wierzcholek root=new Wierzcholek();
		while(skaner.hasNextLine()) {
			linia=skaner.nextLine().split(" ");
			etykieta=linia[0];
			if(linia.length==1) {
				root.etykieta=etykieta;
			}else{
			etykieta=linia[0];
			umiejscowienie=linia[1].split("");
			Wierzcholek obecny=root;
			for(int i=0;i<umiejscowienie.length;i++) {
				if(umiejscowienie[i].equals("L")) {
					if(obecny.lewynastepnik==null)
						obecny.lewynastepnik=new Wierzcholek();
					obecny=obecny.lewynastepnik;
				}else {
					if(obecny.prawynastepnik==null)
						obecny.prawynastepnik=new Wierzcholek();
					obecny=obecny.prawynastepnik;
				}
			}
			obecny.etykieta=etykieta;
		}
		
		}
		skaner.close();
		
		System.out.println(porownaj(root));

	}
	
	static String porownaj(Wierzcholek wierzcholek) {
		
		if( wierzcholek.prawynastepnik==null && wierzcholek.lewynastepnik==null) {
			return wierzcholek.etykieta;
		}
		if( wierzcholek.prawynastepnik==null) {
			return porownaj(wierzcholek.lewynastepnik)+wierzcholek.etykieta;
		}
		if(wierzcholek.lewynastepnik==null) {
			return porownaj(wierzcholek.prawynastepnik)+wierzcholek.etykieta;
		}
		
		String lw=porownaj(wierzcholek.lewynastepnik);
		String pw=porownaj(wierzcholek.prawynastepnik);
	
		int i=0;
		while(i<pw.split("").length &&  i<lw.split("").length) {
			
			if(pw.charAt(i)>lw.charAt(i)) {
				return pw+wierzcholek.etykieta;
			}else {
				if(pw.charAt(i)<lw.charAt(i)) {
					
					return lw+wierzcholek.etykieta;
				}
				
			}
			i++;
			
		}
		
		if(lw.split("").length>pw.split("").length)
		return pw+wierzcholek.etykieta;
		if(lw.split("").length<pw.split("").length)
			return lw+wierzcholek.etykieta;
		
		return lw+wierzcholek.etykieta;
		
	}
	
	
	
	
	}	





