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
public class UserNamePassword implements IUserNamePassword {
    
    private String userName = "";
    private String password = "";
    private String siteName = "";
    
    public UserNamePassword(){
        
    }
    
    public UserNamePassword(String siteName, String userName, String password){
        this.siteName=siteName;
        this.userName=userName;
        this.password=password;
    }
    
    public final String getSiteName(){
        
        return this.siteName;
    }
    
    public final String getUserName(){
        
        return this.userName;
    }
    
    public final String getPassword(){
        
        return this.password;
    }
    
    public void setSiteName(String name){
        
        this.siteName = name;
    }
    
    public void setUserName(String userName){
        
        this.userName = userName;
    }
    
    public void setPassword(String password){
        
        this.password = password;
    }
    
}
