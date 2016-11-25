package sumptus.oldView;

import sumptus.model.User;

/**
 *
 * @author jessicadagostini
 */
public class UserModel {
    
    private User user;
    
    public UserModel(User user){
        this.user = user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
}
