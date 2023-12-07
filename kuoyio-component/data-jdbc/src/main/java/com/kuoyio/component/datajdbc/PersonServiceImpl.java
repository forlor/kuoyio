package com.kuoyio.component.datajdbc;

import com.kuoyio.component.entity.Person;
import com.kuoyio.component.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author xyz
 * @since 1.0
 */
@Service
public class PersonServiceImpl {
    @Resource
    private PersonRepository personRepository;
    @PostConstruct
    public void init(){
        Optional<Person> personOpt = personRepository.findById(125L);
        Person person = personOpt.get();
        person.setName("xyz124");
        person.setCreateTime(LocalDateTime.now());
        person.setInstant(Instant.now());
       personRepository.save(person);
        System.out.println(1);
    }
}
