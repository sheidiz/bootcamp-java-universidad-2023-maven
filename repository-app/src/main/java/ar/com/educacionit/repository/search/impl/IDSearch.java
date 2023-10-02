package ar.com.educacionit.repository.search.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.entities.AddressBook;
import ar.com.educacionit.repository.search.Search;

public class IDSearch implements Search {

	private String id;
	
	@Override
	public List<AddressBook> execute(List<AddressBook> sourceList) {
		List<AddressBook> filteredList = new ArrayList<>();
		
		for (AddressBook addressBook : sourceList) {
			if(addressBook.getId().toLowerCase().equals(this.id.toLowerCase())) {
				filteredList.add(addressBook);
			}
		}
		
		return filteredList;
	}

	public void setId(String id) {
		if(id == null) {
			throw new IllegalArgumentException("ID is null");
		}
		this.id = id;
	}

}
