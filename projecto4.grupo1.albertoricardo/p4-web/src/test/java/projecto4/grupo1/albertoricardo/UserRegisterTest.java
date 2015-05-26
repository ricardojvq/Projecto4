package projecto4.grupo1.albertoricardo;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.hamcrest.MatcherAssert;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRegisterTest extends TestCase {
	
	@Mock
	UserEJBLocal userejb;
	@InjectMocks
	UserRegister uRegister;

	@Test
	public void addNewUserSuccessTest() {
		uRegister.setEmail("username@mail.com");
		uRegister.setEmailConfirm("username@mail.com");
		uRegister.setPassword("123");
		uRegister.setPasswordConfirm("123");
		String d = uRegister.addNewUser();
		assertEquals("login.xhtml?faces-redirect=true", d);
		
	}
	
	@Test
	public void addNewUserFailTest() {
		uRegister.setEmail("username@mail.com");
		uRegister.setEmailConfirm("anotherUsername@mail.com");
		uRegister.setPassword("123");
		uRegister.setPasswordConfirm("123");
		uRegister.addNewUser();
		String d = uRegister.getResult();
		assertEquals("E-mails não correspondem.", d);
		
	}

}
