package org.managementsystem.controller.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.managementsystem.model.user.User;
import org.managementsystem.model.user.UserDAOImpl;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;


@ManagedBean
public class LoginBean {
	UserController controller = new UserController(new UserDAOImpl());
	List<User> userInfoList = controller.getUserDataList();
	private User user = new User();
	public User getUser() {
		return user;
	}
	
	public void loginControl() throws ServletException, IOException {
		String userName = getUser().getUserMail();
		String userPassword = getUser().getPassword();
		try{
            Subject currentUser= SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(userName,userPassword);
            currentUser.login(token);
		}catch (AuthenticationException e){
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Could not login",
									"Mail Adresi veya Şifre Hatalı"));
		}
	}
	public void authorizedUserControl(){
		if(SecurityUtils.getSubject().getPrincipal()!=null){
			NavigationHandler handler=FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			handler.handleNavigation(FacesContext.getCurrentInstance(), null, "/index.xhtml?faces-redirect=true");
		}
	}
}