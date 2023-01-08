package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Component
public class PersonDAO {
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;



    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

        public Person show(int id) {
            return jdbcTemplate.query("select * from person where id =?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                    .stream().findAny().orElse(null);
        }

    public void save(Person person)  {
        jdbcTemplate.update("insert into person values (DEFAULT, ?)", person.getName());
    }
    public void update(int id, Person updatedPerson) {
    jdbcTemplate.update("update person set name=? where id = ?", updatedPerson.getName(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
