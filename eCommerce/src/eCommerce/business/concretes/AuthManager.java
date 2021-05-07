package eCommerce.business.concretes;

import eCommerce.business.abstracts.AuthService;
import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailService;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;

	public AuthManager(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if( userValidate(user) 
				&& passwordValidate(user.getPassword()) 
				&& !userExists(user.geteMail()))
		{
			userService.add(user);
		}else {
			System.out.println("Kayıt Başarısız.");
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if(userService.get(email) != null) {
			return true;
		}
		System.out.println("Email kullanılmatadır.");
		return false;
	}
	
	public boolean userValidate(User user) {
		if ( user != null 
				&& !user.getName().isEmpty() 
				&& !user.getLastName().isEmpty() 
				&& !user.geteMail().isEmpty()
				&& !user.getPassword().isEmpty()) {
			return true;
		}
		System.out.println("Boş alan bırakmayınız.");
		return false;
	}
	
	public boolean passwordValidate(String password) {
		if ( password.length() >= 6 ) {
			return true;
		}
		System.out.println("Parola hatalı.");
		return false;
	}

	@Override
	public void login(LoginDto loginDto) {
		User user = userService.get(loginDto.getEmail());
		if ( user.getPassword().equals(loginDto.getPassword())) {
			System.out.println("Başarılı giriş.");
			
		}else {
			System.out.println("Kullanıcıadı veya Şifre hatalı.");
		}
	}

	@Override
	public void verify(User user, String token) {
		if ( user != null && token.length() > 15) {
			User existUser = userService.get(user.geteMail());
			existUser.setVerify(true);
			userService.update(existUser);
			System.out.println("Email doğrulandı.");
		}else {
			System.out.println("Email doğrulanamdı.");
		}
		
	}
	
	

}
