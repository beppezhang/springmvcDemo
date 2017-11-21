package bz.beppe.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import bz.beppe.entity.TUser;
import bz.beppe.iservice.TUserService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private TUserService tUserService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = tUserService.findRoles(username) ;
        Set<String> permissions = tUserService.findPermissions(username) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户账号
        String username = token.getPrincipal().toString();
        TUser user = tUserService.findUserByUsername(username) ;
        if (user != null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),
                    "a") ;
            return authenticationInfo ;
        }else{
            return  null ;
        }



	}

}
