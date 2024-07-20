package com.example.tacocloud.tacos.security;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private static final long serialVersionUID = 1L;

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
    private List<? extends GrantedAuthority> authorityList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.copyOf(authorityList);
    }
}
