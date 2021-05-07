
public class UserManager {
		
	public void add(User user) {
		System.out.println("kullanıcı başarıyla eklendi.");
	}
	
	public void login() {
		System.out.println("Giris yapildi.");
	}
	
	public void logout() {
		System.out.println("Cikis yapildi.");
	}
	
	public void delete() {
		System.out.println("Kullanıcı Silind");
	}
	
	public void addMultiple(User[] users) {
		for (User user:users) {
			add(user);
		}
	}
}
