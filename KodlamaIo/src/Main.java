
public class Main {

	public static void main(String[] args) {
		
		Instructor instructor = new Instructor();
		instructor.setFirstName("Kemal");
		instructor.setLastName("Yılmaz");
		instructor.setEmail("kemalkemal@kemal.com");
		instructor.setRole("Admin");
		
		UserManager userManager = new UserManager();
		userManager.add(instructor);
	}

}
