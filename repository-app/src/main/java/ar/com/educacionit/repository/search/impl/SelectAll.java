package ar.com.educacionit.repository.search.impl;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.entities.AddressBook;
import ar.com.educacionit.repository.search.Search;

public class SelectAll implements Search {

	@Override
	public List<AddressBook> execute(List<AddressBook> sourceList) {
		List<AddressBook> filteredList = new ArrayList<>();
		
		for (AddressBook addressBook : sourceList) {
			filteredList.add(addressBook);
		}
		
		return filteredList;
	}

}
