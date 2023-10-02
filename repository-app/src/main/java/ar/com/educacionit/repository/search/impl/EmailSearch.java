package ar.com.educacionit.repository.search.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.entities.AddressBook;
import ar.com.educacionit.repository.search.Search;

public class EmailSearch implements Search {

	private String email;
	
	@Override
	public List<AddressBook> execute(List<AddressBook> sourceList) {
		List<AddressBook> filteredList = new ArrayList<>();
		
		for (AddressBook addressBook : sourceList) {
			if(addressBook.getEmail().toLowerCase().equals(this.email.toLowerCase())) {
				filteredList.add(addressBook);
			}
		}
		
		return filteredList;
	}

	public void setEmail(String email) {
		if(email == null) {
			throw new IllegalArgumentException("Email is null");
		}
		this.email = email;
	}
	
}
