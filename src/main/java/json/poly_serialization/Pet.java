package json.poly_serialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class Pet
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
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