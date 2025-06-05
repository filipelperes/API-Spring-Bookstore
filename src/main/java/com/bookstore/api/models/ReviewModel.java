package com.bookstore.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_REVIEW")
public class ReviewModel implements Serializable {
   public static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column(nullable = false)
   private String comment;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @OneToOne
   @JoinColumn(name = "book_id")
   private BookModel book;
}