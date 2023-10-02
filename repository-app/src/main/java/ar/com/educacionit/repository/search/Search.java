package ar.com.educacionit.repository.search;

import java.util.List;

import ar.com.educacionit.entities.AddressBook;

public interface Search {
	public List<AddressBook> execute(List<AddressBook> sourceList);
}