package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void invalidBirthday() {
        Birthday birthday = new Birthday();
        birthday.setYearOfBirthday(2011);
        birthday.setMonthOfBirthday(2);
        birthday.setDayOfBirthday(31);

        Person person = new Person("test", 10, "O");
        person.setBirthday(birthday);

        personRepository.save(person);

        personRepository.findByMonthOfBirthday(2).forEach(System.out::println);
    }

    @Test
    void crud() {
        Person person = new Person();
        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");
        personRepository.save(person);

        List<Person> result = personRepository.findByName("john");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("john");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.get(0).getBloodType()).isEqualTo("A");
    }


    @Test
    void findByBloodType() {
        List<Person> result = personRepository.findByBloodType("A");

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("sophia");
    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("sophia");
    }

}