package ar.com.educacionit.console;

import java.util.List;
import java.util.Scanner;

import ar.com.educacionit.entities.AddressBook;
import ar.com.educacionit.repository.parse.impl.AddressBookFileParser;
import ar.com.educacionit.repository.search.Search;
import ar.com.educacionit.repository.search.impl.EmailSearch;
import ar.com.educacionit.repository.search.impl.FirstAndLastNameSearch;
import ar.com.educacionit.repository.search.impl.IDSearch;
import ar.com.educacionit.repository.search.impl.SelectAll;

public class App {
	public static void main(String[] args) {
		// ctrl+alt+down > copy lines
		Scanner keyboard = new Scanner(System.in);
		// 1 cargar el archivo csv
		AddressBookFileParser parse = new AddressBookFileParser();
		List<AddressBook> listado = parse.parse();

		// 2 mostrar menu al usuario
		Integer op = null;
		do {
			Menu.showMenu();
			op = Menu.getOp(keyboard);
		} while (op < 1 || op > 4);

		Search search = null;
		// evaluo en base a la opcion que accion ejecuto
		switch (op) {
		case 1: {
			System.out.println("First Name: ");
			String firstName = keyboard.next();

			System.out.println("Last Name: ");
			String lastName = keyboard.next();
			search = new FirstAndLastNameSearch();
			((FirstAndLastNameSearch) search).setFirstName(firstName);
			((FirstAndLastNameSearch) search).setLastName(lastName);
			break;
		}
		case 2: {
			System.out.println("Email: ");
			String email = keyboard.next();
			search = new EmailSearch();
			((EmailSearch) search).setEmail(email);
			break;
		}
		case 3: {
			System.out.println("ID: ");
			String id = keyboard.next();
			search = new IDSearch();
			((IDSearch) search).setId(id);
			break;
		}
		case 4: {
			search = new SelectAll();
		}
		}

		// 3 buscar en base a la opcion
		var filteredList = search.execute(listado);

		// 4 mostrar recursivamente
		if (filteredList.size() == 0) {
			System.out.println("User not found");
		} else {
			for (AddressBook ab : filteredList) {
				System.out.println(ab.toString());
			}

		}
		// 5 preguntar si continua
//		String answer;
//		do {
//			System.out.println("Do you want to search again? (Y/N)");
//			answer = keyboard.next();			
//		}while(answer != "Y" && answer!="N");
//		
//		if(answer == "Y") {
//			
//		}
//		//6 fin
//		keyboard.close();
	}

}