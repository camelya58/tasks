package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Class Cat demonstrates jackson annotations.
 * @JsonAutoDetect - allows to convert java object to JSON;
 * @JsonPropertyOrder - allows to build the order of field;
 *  @JsonProperty - allows to change the filed name in JSON;
 *  @JsonIgnore - allows not to include such field in JSON.
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
@JsonAutoDetect
@JsonPropertyOrder({"alias", "age"})
public class Cat {

    @JsonProperty("alias")
    String name;

    @JsonProperty
    int age;

    @JsonIgnore
    int weight;

}
