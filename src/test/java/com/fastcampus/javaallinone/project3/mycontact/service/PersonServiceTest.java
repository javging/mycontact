package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
//        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
//        result.forEach(person->{
//            System.out.println(person);
//        });
        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest() {
        givenPeople();
        List<Person> people = personRepository.findAll();
        people.forEach(System.out::println);

        Person person = people.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());
        System.out.println(person);

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        // Person객체에서 @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 에 CascadeType.MERGE 추가해줘야만
        // block 속성 변경된 것이 함께 저장됨.

//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println);
        // CascadeType.REMOVE 추가해야 block도 사라짐,,

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
        // person은 삭제되지만, person에 적용되어있던 block은 남아있음
        // @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)  orphanRemoval = true 해야지 block 도 같이 사라짐

    }

    @Test
//    @Transactional
    void getPerson() {
        givenPeople();
//        personRepository.findAll().forEach(System.out::println);
        // 역시 마찬가지로 Person객체에서 block 에 FetchType.LAZY 설정되어있어서 no session 에러남
        // @Transactional 해주면 에러 안남,,

        Person person = personService.getPerson(5L);
        System.out.println(person);
    }

//    private void givenBlocks() {
//        givenBlock("martin");
//    }

//    private Block givenBlock(String name) {
//        return blockRepository.save(new Block(name));
//    }

    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenBlockPerson("david",9,"B");
        givenPerson("dennis",7,"AB");
        givenBlockPerson("martin", 11, "O");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
//        blockPerson.setBlock(givenBlock(name));
        blockPerson.setBlock(new Block(name));

        personRepository.save(blockPerson);
    }

}