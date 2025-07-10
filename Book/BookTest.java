package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.Book;
import com.aurionpro.model.bookAscendingOrderOfAuthor;
import com.aurionpro.model.bookDescendingOrderOfTitle;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		List<Book> available_books = new ArrayList<>();
		List<Book> issued_books = new ArrayList<>();

		available_books.add(new Book(1, "ddddd", "ddd", "dd", 200, false));
		available_books.add(new Book(4, "bbbbb", "bbb", "bb", 300, false));
		available_books.add(new Book(3, "ccccc", "ccc", "cc", 400, false));
		available_books.add(new Book(5, "aaaaa", "aaa", "aa", 500, false));
		available_books.add(new Book(2, "eeeee", "eee", "ee", 600, false));

		int choice;
		do {
			System.out.println(
					" 1.Add a New Book\n 2.Issue a Book\n 3.Display all Available Books\n 4.Display all Issued Books\n 5.Return a Book\n 6.Sort Books\n 7.Exit");
			System.out.println("Enter your choice:");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				addBook(scanner, available_books);
				break;

			case 2:
				issueBook(scanner, available_books, issued_books);
				break;

			case 3:
				displayAvailableBooks(scanner, available_books);
				break;

			case 4:
				displayIssuedBooks(scanner, issued_books);
				break;

			case 5:
				returnBook(scanner, available_books, issued_books);
				break;

			case 6:
				sortBooks(scanner, available_books);
				break;

			case 7:
				System.out.println("Thankyou Visit Again");
				break;
			}

		} while (choice != 7);

	}

	private static void sortBooks(Scanner scanner, List<Book> available_books) {
		// TODO Auto-generated method stub
		int choice;
		System.out.println("Sort Books");
		System.out.println(" 1.Ascending Order of Author\n 2.Descending Order of Title");
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			sort_ascending_author(available_books);
			break;

		case 2:
			sort_descending_title(available_books);
			break;
		}

	}

	private static void sort_descending_title(List<Book> available_books) {
		// TODO Auto-generated method stub
		List<Book> books=new ArrayList<>();
		for(Book available_book:available_books) {
			books.add(available_book);
		}
		Collections.sort(books, new bookDescendingOrderOfTitle());
		for (Book book : books) {
			System.out.println(book);
		}

	}

	private static void sort_ascending_author(List<Book> available_books) {
		// TODO Auto-generated method stub
		List<Book> books=new ArrayList<>();
		for(Book available_book:available_books) {
			books.add(available_book);
		}
		Collections.sort(books, new bookAscendingOrderOfAuthor());

		for (Book book : books) {
			System.out.println(book);
		}

	}

	private static void returnBook(Scanner scanner, List<Book> available_books, List<Book> issued_books) {
		// TODO Auto-generated method stub
		if (issued_books.isEmpty()) {
			System.out.println("Nothing to return.No books are issued");
			return;
		}
		System.out.println("Enter Id of Book to be returned:");
		int book_id = scanner.nextInt();

		for (Book issued_book : issued_books) {
			if (issued_book.getBook_id() == book_id) {
				available_books.add(issued_book);
				System.out.println("Book added to available books");
				issued_books.remove(issued_book);
				System.out.println("Book removed from issued books");
				return;
			}

		}

	}

	private static void displayIssuedBooks(Scanner scanner, List<Book> issued_books) {
		// TODO Auto-generated method stub
		if (issued_books.isEmpty()) {
			System.out.println("No Books are Issued");
			return;
		}
		for (Book issued_book : issued_books) {
			System.out.println("-----------------------------------");
			System.out.println("Book Id: " + issued_book.getBook_id());
			System.out.println("Book Title: " + issued_book.getBook_title());
			System.out.println("Book Author: " + issued_book.getBook_author());
			System.out.println("Book Publication: " + issued_book.getBook_publication());
			System.out.println("Book Price: " + issued_book.getBook_price());
			System.out.println("Issue Status: " + issued_book.isIssued());
			System.out.println("-------------------------------------");
		}

	}

	private static void displayAvailableBooks(Scanner scanner, List<Book> available_books) {
		// TODO Auto-generated method stub
		if (available_books.isEmpty()) {
			System.out.println("No Books are Available");
			return;
		}
		for (Book available_book : available_books) {
			System.out.println("-----------------------------------");
			System.out.println("Book Id: " + available_book.getBook_id());
			System.out.println("Book Title: " + available_book.getBook_title());
			System.out.println("Book Author: " + available_book.getBook_author());
			System.out.println("Book Publication: " + available_book.getBook_publication());
			System.out.println("Book Price: " + available_book.getBook_price());
			System.out.println("Issue Status: " + available_book.isIssued());
			System.out.println("-------------------------------------");
		}

	}

	private static void issueBook(Scanner scanner, List<Book> available_books, List<Book> issued_books) {
		// TODO Auto-generated method stub
		System.out.println("Issuing Book");
		System.out.println("Enter Book Id:");
		int book_id = scanner.nextInt();
		// Adding book to issued_books arraylist
		for (Book available_book : available_books) {
			if (available_book.getBook_id() == book_id) {
				issued_books.add(available_book);
				System.out.println("Book Issued Successfully:Title: " + available_book.getBook_title() + " Book Id: "
						+ available_book.getBook_id());
				available_books.remove(available_book);
				System.out.println("Book Removed from available books Successfully: Title: "
						+ available_book.getBook_title() + " Book Id: " + available_book.getBook_id());
				return;
			}
		}

	}

	private static void addBook(Scanner scanner, List<Book> available_books) {
		// TODO Auto-generated method stub
		System.out.println("Enter Book Details");
		System.out.println("Enter Book Id:");
		int book_id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Book Title:");
		String book_title = scanner.nextLine();
		System.out.println("Enter Book Author:");
		String book_author = scanner.nextLine();
		System.out.println("Enter Book Publication:");
		String book_publication = scanner.nextLine();
		System.out.println("Enter Book Price:");
		int book_price = scanner.nextInt();

		available_books.add(new Book(book_id, book_title, book_author, book_publication, book_price, false));
		System.out.println("Book Details Entered Successfully");

	}

}
