package learning.hibernate.alishev.one_to_one.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Passport")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private int passportNumber;

    @OneToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Passport(Person person, int passportNumber) {
        this.person = person;
        this.passportNumber = passportNumber;
    }

    public Passport() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
            "person=" + person +
            ", passportNumber='" + passportNumber + '\'' +
            '}';
    }
}
