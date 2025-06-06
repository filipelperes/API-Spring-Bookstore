package com.bookstore.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_AUTHOR")
public class AuthorModel implements Serializable {
   public static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column(nullable = false, unique = true)
   private String name;

   @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
   @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
   private Set<BookModel> books = new HashSet<>();
}