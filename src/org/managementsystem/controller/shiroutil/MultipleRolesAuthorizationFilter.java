package org.managementsystem.controller.shiroutil;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by heval on 28.01.2015.
 */
public class MultipleRolesAuthorizationFilter extends RolesAuthorizationFilter {
    public boolean isAccessAllowed(ServletRequest request,ServletResponse response,Object mappedValue) throws IOException{
        Subject subject = getSubject(request,response);
        String[] rolesArray=(String[]) mappedValue;
        if(rolesArray == null || rolesArray.length == 0){
            return true;
        }
        for(String roleName : rolesArray){
            if(subject.hasRole(roleName)){
                return true;
            }
        }
        return false;
    }
}
