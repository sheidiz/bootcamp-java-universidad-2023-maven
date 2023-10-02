package ar.com.educacionit.repository.parse.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import ar.com.educacionit.entities.AddressBook;
import ar.com.educacionit.repository.parse.IParser;

public class AddressBookFileParser implements IParser<List<AddressBook>> {

	public static final String SEPARADOR = ";";
	@Override
	public List<AddressBook> parse() {
		
		List<AddressBook> list = new ArrayList<>();
		AddressBook ab;
		
		//deberia leer el archivo linea por linea e ir creando cada AddresBook 
		BufferedReader bufferedReader = null;
		try {
			//Abro el .csv con un buffer de lectura
			bufferedReader = new BufferedReader(new FileReader("../console-app/address-book.csv"));
			
			//Leo una linea del archivo
			String linea = bufferedReader.readLine();
			//Lo leo denuevo para no sumar la primera fila
			linea = bufferedReader.readLine();
			//recorro todas las lineas
			while(linea != null) {
				String[] datos = linea.split(SEPARADOR);
				ab = new AddressBook(datos[0],datos[1],datos[2]);
				//luego agregarlo a la lista
				list.add(ab);
				linea = bufferedReader.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

}