
public class StudentManager extends UserManager{
	
	
	public void register(Student student) {
		System.out.println(student.firstName + " İsimli Kullanicinin Kayidi Basarili");
	}
	

	public void login(Student student) {
		System.out.println(student.firstName + " İsimli Kullanicinin Girisi Basarili");
	}
	
	public void logout(Student student) {
		System.out.println(student.firstName + " İsimli Kullanicinin Cikisi Yapildi");
	}
	
	public void getStudentDetails(Student student) {
		System.out.println("Ad : " + student.firstName);
		System.out.println("Soyad : " + student.lastName);
		System.out.println("Yuzde : " + student.percentage);
		
	}

}
