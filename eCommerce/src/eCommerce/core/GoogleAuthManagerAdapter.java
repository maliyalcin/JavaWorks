package eCommerce.core;

import eCommerce.business.abstracts.UserService;
import eCommerce.entities.concretes.LoginDto;
import eCommerce.entities.concretes.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService{

	private UserService userService;
	
	public GoogleAuthManagerAdapter(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void register(String email) {
		if(userExists(email) == false) {
			userService.add(email);
		}
		else {
			User user = userService.get(email);
			LoginDto dto = new LoginDto();
			dto.setEmail(user.geteMail());
			dto.setPassword(user.getPassword());
			login(dto);
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if(userService.get(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void login(LoginDto loginDto) {
		if (loginDto != null && loginDto.getPassword().equals(loginDto.getPassword())) {
			System.out.println("Başarılı giriş.");
			
		}else {
			System.out.println("Kullanıcıadı veya Şifre hatalı.");
		}
		
	}

}
