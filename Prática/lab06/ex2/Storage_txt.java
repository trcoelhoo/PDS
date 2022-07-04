package ex2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage_txt implements ContactsStorageInterface {
	File file;

	public Storage_txt(String filename) {
		this.file = new File(filename);
	}

	public List<Contact> loadContacts() {
		List<Contact> contactos = new ArrayList<Contact>();

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				// CONTACTOS SEPARADOS POR TAB
				String[] line = sc.nextLine().split("\t");
				for (String x : line) {
					String[] contact = x.split(",");
					if (contact.length == 3)
						contactos.add(new Contact(contact[0], Integer.parseInt(contact[1]), contact[2]));
					else if (contact.length == 2)
						contactos.add(new Contact(contact[0], Integer.parseInt(contact[1])));
				}

			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Problem accessing the db!");
		}
		return contactos;
	}

	public boolean saveContacts(List<Contact> list) {
		file.delete();
		try (FileWriter out = new FileWriter(file)) {
			for (Contact c : list) {
				// CONTACTOS SEPARADOS POR TAB
				if (c.hasEmail())
					out.write(c.getName() + "," + c.getNumber() + "," + c.getEmail() + "\t");
				else
					out.write(c.getName() + "," + c.getNumber() + "\t");
			}
			return true;

		} catch (IOException e) {
			System.err.println("Problem accessing the db!");
			return false;
		}

	}

}