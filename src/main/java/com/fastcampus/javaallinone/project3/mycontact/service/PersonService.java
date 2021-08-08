package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Block;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();
        System.out.println(people);
//        List<Block> blocks = blockRepository.findAll();
//        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());

        return people.stream().filter(person -> person.getBlock()==null).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
//        System.out.println(id);
//        System.out.println(personRepository.findAll());
        Person person = personRepository.findById(id).get();
//        System.out.println(personRepository.getOne(1L).getName()); // @Transactional 있어야 오류 안남,,


//        System.out.println(person); // 걍 다 찍힘
        log.info("person: {}", person); // 나중에 필요 없으면 로그 출력되지 않도록 설정할 수 있음

        return person;
    }
}
