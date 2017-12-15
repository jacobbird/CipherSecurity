/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CipherSecurity.GUI;

/**
 *
 * @author Jacob
 */
public interface IUserNamePassword {
    public String getSiteName();
    public String getPassword();
    public String getUserName();
    public void setSiteName(String name);
    public void setPassword(String password);
    public void setUserName(String userName);
}
