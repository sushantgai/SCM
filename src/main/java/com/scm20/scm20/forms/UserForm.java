package com.scm20.scm20.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm{

    private String name;
    private String email;
    private String password;
    private String about;
    private String phone;
    public String getProfilePic() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProfilePic'");
    }
    
}
