
public class InstructorManager extends UserManager {
	
	@Override
	public void add(User user) {
		System.out.println("Eklendi.");
	}

	public void login() {
		System.out.println("Egitmen girisi yapildi. Merhaba ! ");
	}
	
	public void logout() {
		System.out.println("Egitmen cikisi yapildi. Merhaba ! ");
	}
	
	

}
