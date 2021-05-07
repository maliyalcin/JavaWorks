public class Main {

	public static void main(String[] args) {
		
		Urun urun1 = new Urun(2, "Java + REACT", 35, "Engin Demiroğ");
		
		Urun urun2 = new Urun();
		urun2.id = 1;
		urun2.name = "C# + Angular";
		urun2.percent = 83;
		urun2.educator = "Engin Demiroğ";
		
		Urun[] uruns = {urun1, urun2};
		
		System.out.println("KURSLAR");
		System.out.println("-----------------------------------");
		
		for (Urun urun:uruns) {
			System.out.println(urun.id);
			System.out.println("Kurs Adı : " + urun.name);
			System.out.println("Tamamlama Yüzdesi : %" + urun.percent);
			System.out.println("Eğitmen : " + urun.educator);
			System.out.println("-----------------------------------");
		}
		
		Category category1 = new Category(1 , "Tümü");
		
		Category category2 = new Category();
		category2.id = 1;
		category2.name = "Programlama";
		
		Category[] categories = {category1, category2};
		
		System.out.println("KATEGORİLER");
		System.out.println("-----------------------------------");
		
		
		for (Category category : categories) {
			System.out.println(category.id);
			System.out.println("Kategori Adı : " + category.name);
			System.out.println("-----------------------------------");
		}

	}

}