package ex2;
public class ex2 {

	public static void main(String[] args) {
				
		ContactsStorageInterface file_txt = new Storage_txt("db.txt");
		ContactsInterface db_txt = new db();
		db_txt.openAndLoad(file_txt);
		Contact diogo = new Contact("Diogo", 965901234);
		db_txt.add(diogo);
		db_txt.saveAndClose();
		db_txt.openAndLoad(file_txt);
		diogo = db_txt.getByName("Diogo");
		System.out.println(diogo);
		db_txt.remove(diogo);
		db_txt.saveAndClose();

		
		ContactsStorageInterface file_binary = new Storage_binary("databasebin");
		ContactsInterface db_binary = new db();
		db_binary.openAndLoad(file_binary);
		Contact tiago = new Contact("Tiago", 966777333, "tiago@ua.pt");
		db_binary.add(tiago);
		db_binary.saveAndClose();
		db_binary.openAndLoad(file_binary);
		tiago = db_binary.getByName("Tiago");
		System.out.println(tiago);
		db_binary.remove(tiago);
		db_binary.saveAndClose();

	}

}