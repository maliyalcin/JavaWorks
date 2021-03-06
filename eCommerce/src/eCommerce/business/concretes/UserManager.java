package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void add(User user) {
		
			userDao.add(user);
			System.out.println("Eposta Log : " + user.geteMail());
			emailService.send(user.geteMail(), "Kayıt başarılı..");
	}
	
	@Override
	public void add(String email) {
		
			User user = new User();
			user.seteMail(email);
			userDao.add(user);
			System.out.println("Eposta Log : " + user.geteMail());
			emailService.send(email, "Kayıt başarılı.");
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public List<User> getAll() {
		for(User user : userDao.getAll()) {
			System.out.println(user.getId() + " " + user.geteMail() +" " + user.getFullName() );
		}
		return userDao.getAll();
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}
	
	public boolean userValidate(User user) {
		if(user.getName().length()>=2 && user.getLastName().length() >=2) {
			return true;
		}
		System.out.println("Adınız ve Soyadınız minimum 2 karakter olmalı.");
		return false;
	}
}
