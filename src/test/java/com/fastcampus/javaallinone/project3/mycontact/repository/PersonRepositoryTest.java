package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        person.setBloodType("A");

        System.out.println(personRepository);
        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void constructorTest() {
        // Person person = new Person(1L, "martin", 10, "reading", "A", "분당", LocalDate.of(2021,8,7), "programmer", "010-7141-3096");
        Person person2 = new Person("martin", 1, "B");
        // System.out.println(person);
        person2.setAge(999999999);
        System.out.println(person2);
        // System.out.println(person2.isBlock());
    }


    @Test
    void hashcodeAndEquals() {
        Person person1 = new Person("martin", 10, "A");
        Person person2 = new Person("martin", 10, "A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        // 해시코드는 다름
        // 해시코드가 다르면 어떤 문제??

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }

    @Test
    void findByBloodType() {
        personRepository.save(new Person("martin", 10, "A"));
        personRepository.save(new Person("martin", 10, "B"));
        personRepository.save(new Person("martin", 10, "C"));
        // 같은 혈액형 2개 이상이면 오류 발생함,,
        personRepository.save(new Person("martin", 10, "A"));
        personRepository.save(new Person("martin", 10, "A"));

//        System.out.println(personRepository.findByBloodType("A")); // 혈액형으로 조회했을 때, 1명만 나오면 Person객체로 받아와도 괜춘
//        personRepository.findByBloodType("A").forEach(System.out::println);
        // 여러개일 경우 생각해서 리스트형태로 받아와야 함,,
        System.out.println(personRepository.findByBloodType("AB")); // 객체로 받아올 때,, 하나도 없으면 null 임 ,, 리스트로 받아올때는 빈 리스트.
//        personRepository.findByBloodType("AB").forEach(System.out::println);
        // 없을 경우 빈 리스트,,
    }

    @Test
    void findByBirthdayBetween() {
        givenPerson("martin", 10, "A", LocalDate.of(1988,8,1));
        givenPerson("martin", 10, "A", LocalDate.of(1988,9,1));
        givenPerson("martin", 10, "A", LocalDate.of(1988,10,1));
        givenPerson("martin", 10, "A", LocalDate.of(1988,11,1));
        givenPerson("martin", 10, "A", LocalDate.of(1989,8,10));

//        personRepository.findByBirthdayBetween(
//                LocalDate.of(1988,8,1),
//                LocalDate.of(1988, 8,31))
//                .forEach(System.out::println);
        // 년도 다를 경우 조회하기 어려움
        personRepository.findByMonthOfBirthday(8).forEach(System.out::println);
        personRepository.findByMonthOfBirthdayAndDayOfBirthday(8, 10).forEach(System.out::println);
        personRepository.anyName(8, 10).forEach(System.out::println);
        personRepository.nativeQueryTest(8, 10).forEach(System.out::println);
    }

    void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
//        person.setBirthday(birthday);
//        person.setBirthday(new Birthday(birthday.getYear(), 13, birthday.getDayOfMonth()));
//        person.setBirthday(new Birthday(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);
    }
}