package com.AuthServer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
//@QueryEntity
@Document
public class User {

	@Id
	private String id;

	private String username;
	private String password;
	private String firstname;
	private String lastname;
}