package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @NonNull
        @Column(name = "first_name",nullable = false)
        private String first_name;

        @NonNull
        @Column(name = "last_name",nullable = false)
        private String last_name;

        @NonNull
        @Column(name = "age",nullable = false)
        private int age;


}
