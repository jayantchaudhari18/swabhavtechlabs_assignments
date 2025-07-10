package com.aurionpro.model;

import java.util.Comparator;

public class bookDescendingOrderOfTitle implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		if(o1.getBook_title().compareTo(o2.getBook_title())<0) {
			return 1;
		}
		if(o1.getBook_title().compareTo(o2.getBook_title())>0) {
			return -1;
		}
		return 0;
	}



}
