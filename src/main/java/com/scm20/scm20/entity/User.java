package com.scm20.scm20.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;

@Entity(name = "user")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
	

	@Id
	private String userID;

	@Column(name = "name", nullable = false)
	private String userName;
	
	@Column(name = "email", nullable = false,unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "about")
	private String about;

	@Column(name = "phone")
	private String phoneNumber;

	@Column(name = "profile_pic")
	private String profilePic;

    @Column(nullable = false)
    private boolean enabled = false;
	
	private boolean emailVerified = false;

	private boolean phoneVerified = false;

	@Enumerated(value = EnumType.STRING)
	private Providers provider = Providers.SELF;
	private String providerUserId;

	@Builder.Default
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY ,orphanRemoval = true)
	private List<Contact> contacts = new ArrayList<>();

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

	public void setName(Object name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setName'");
	}



	public String getUserId() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserId'");
	}

	public void setUserId(String userId2) {
		this.userID = userId2;
	}
	public boolean isEnabled() {
        return this.enabled;
    }

	











	
}
