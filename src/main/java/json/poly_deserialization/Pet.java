package main.java.json.json.poly_deserialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Pet
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Cat.class, name="cat"),
        @JsonSubTypes.Type(value=Dog.class, name="dog")
})
@JsonAutoDetect
public class Pet {

    @JsonProperty
    String name;

    @JsonProperty
    int age;
}

@JsonAutoDetect
class Dog extends Pet {

    @JsonProperty
    String owner;
}

@JsonAutoDetect
class Cat extends Pet {
}

@JsonAutoDetect
class House
{
    @JsonProperty
    public List<Pet> pets = new ArrayList<>();
}