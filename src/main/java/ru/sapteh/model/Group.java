package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "groupa")
public class Group {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @NonNull
        @Column(name = "number", nullable = false)
        private String number;

        public Group(@NonNull String number) {
            this.number = number;
        }
}
