package com.aurionpro.model;

public class Book {
	
	private int book_id;
	private String book_title;
	private String book_author;
	private String book_publication;
	private double book_price;
	private boolean isIssued;
	public Book(int book_id, String book_title, String book_author, String book_publication, double book_price,
			boolean isIssued) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_publication = book_publication;
		this.book_price = book_price;
		this.isIssued = isIssued;
	}
	public Book() {
		super();
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publication() {
		return book_publication;
	}
	public void setBook_publication(String book_publication) {
		this.book_publication = book_publication;
	}
	public double getBook_price() {
		return book_price;
	}
	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", book_publication=" + book_publication + ", book_price=" + book_price + ", isIssued=" + isIssued
				+ "]";
	}
	
	

}
