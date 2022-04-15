package com.example.postcoreapi.repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "post_model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String postID;//
    @NotNull(message = "clientID can not be empty")
    private String clientID;//
    @NotNull(message = "postRecipientId can not be empty")
    private String postRecipientId;//
    private String postItem;//
    private String status;//

}

