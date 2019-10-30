package com.netty.day7;

import com.netty.thrift.generated.DataException;
import com.netty.thrift.generated.Person;
import com.netty.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {

        System.out.println("Got Client Parma: " + username);

        Person person = new Person();
        person.setUsername("刘大");
        person.setAge(30);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client param: " );

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());

    }
}
