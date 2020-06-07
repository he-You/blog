package cn.dblearn.blog.auth;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * OAuth2Token
 *
 * @author heyou
 * @date 2018/10/07 16:39
 * @email heyou_0423@163.com
 * @description Shiro 认证类
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
