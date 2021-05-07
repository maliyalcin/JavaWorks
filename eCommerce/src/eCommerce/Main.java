package eCommerce;

import eCommerce.business.concretes.UserManager;
import eCommerce.core.AmazonMailManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUserDao;

public class Main {

	public static void main(String[] args) {
		UserManager userManager = new UserManager(new InMemoryUserDao(), new AmazonMailManagerAdapter());

		userManager.getAll();
	}

}
