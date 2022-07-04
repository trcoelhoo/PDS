package ex2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage_binary implements ContactsStorageInterface{
	File file;

	public Storage_binary(String name) {
		this.file = new File(name);
	}

	public List<Contact> loadContacts() {
		String line;
		List<Contact> contactos = new ArrayList<Contact>();
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				
				String[] line_array = line.split("\t");
				for (String x : line_array) {
					String[] contact = x.split(",");
					if (contact.length == 3)
						contactos.add(new Contact(contact[0], Integer.parseInt(contact[1]), contact[2]));
					else if (contact.length == 2)
						contactos.add(new Contact(contact[0], Integer.parseInt(contact[1])));
				}
			}
		} catch (Exception e) {
			
			System.err.println("Problem accessing the db!");
		}
		return contactos;
	}

	public boolean saveContacts(List<Contact> list) {
		file.delete();
		try (PrintWriter out = new PrintWriter(file)) {
			for (Contact c : list) {
				
				if (c.hasEmail())
					out.print(c.getName() + "," + c.getNumber() + "," + c.getEmail() + "\t");
				else
					out.print(c.getName() + "," + c.getNumber() + "\t");
			}
			return true;

		} catch (IOException e) {
			System.err.println("Problem accessing the db!");
			return false;
		}

	}
}