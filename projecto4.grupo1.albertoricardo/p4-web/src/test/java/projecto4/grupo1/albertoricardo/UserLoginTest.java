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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginTest {
	
	@Mock
	LoginChoose lChoose;
	@Mock
	ExternalContext ext;
	@Mock
	HttpServletRequest req;
	@Mock
	HttpSession session;
	@Mock
	UserEJBLocal userEJB;
	@Spy
	UserLogged uLogged;
	@InjectMocks
	private UserLogin userLogin;
	
	@Before
	public void setUp() {
	}

	@Test
	public void doLoginFailTest() {
		userLogin.setUsername("ricardo");
		userLogin.setPassword("123");
		Mockito.when(userEJB.verifyLogin("ricardo", "123")).thenReturn(false);
		String d = userLogin.doLogin();
		assertEquals("", "", d);
	}
	
	@Test
	public void doLoginSuccessTest() {
		FacesContext context = ContextMocker.mockFacesContext();
		Mockito.when(context.getExternalContext()).thenReturn(ext);
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		Mockito.when(ext.getSessionMap()).thenReturn(sessionMap);
		Mockito.when(ext.getRequest()).thenReturn(req);
		Mockito.when(req.getSession()).thenReturn(session);
		userLogin.setUsername("ricardo");
		userLogin.setPassword("123");
		Mockito.when(userEJB.verifyLogin("ricardo", "123")).thenReturn(true);
		String d = userLogin.doLogin();
		assertEquals("", "/Authorized/entry.xhtml?faces-redirect=true", d);
	}

}
