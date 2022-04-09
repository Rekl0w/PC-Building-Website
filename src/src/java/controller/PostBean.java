
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable {

    /**
     * Creates a new instance of PostBean
     */
    public PostBean() {
    }
    
}
