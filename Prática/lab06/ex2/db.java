package ex2;

import java.util.ArrayList;
import java.util.List;

public class db implements ContactsInterface {
	private ContactsStorageInterface db = null;
	List<Contact> contactos = new ArrayList<Contact>();

	public void openAndLoad(ContactsStorageInterface store) {
		contactos = store.loadContacts();
		db = store;
	}

	public void saveAndClose() {
		if (db == null) {
			System.err.println("No db!");
			System.exit(0);
		} else {
			db.saveContacts(contactos);
			contactos.clear();
		}

	}

	public void saveAndClose(ContactsStorageInterface store) {
		for (Contact x : contactos) {
			System.out.println(x);
		}

		store.saveContacts(contactos);
		contactos.clear();

	}

	public boolean exist(Contact contact) {
		for (Contact x : contactos) {
			if (x.equals(contact))
				return true;
		}
		return false;
	}

	public Contact getByName(String name) {
		for (Contact x : contactos) {
			if (x.getName().equals(name))
				return x;
		}
		return null;

	}

	public boolean add(Contact contact) {
		if (contactos.add(contact))
			return true;
		return false;

	}

	public boolean remove(Contact contact) {
		if (contactos.remove(contact)) {
			return true;
		}

		return false;

	}

}