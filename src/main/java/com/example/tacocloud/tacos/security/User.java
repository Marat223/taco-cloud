package com.example.tacocloud.tacos.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author marat
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User implements UserDetails {

    private static long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String fullname;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String zip;
    @NonNull
    private String phoneNumber;
    @NonNull
    private List<? extends GrantedAuthority> authorityList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.copyOf(authorityList);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
