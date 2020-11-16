package json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Dog demonstrated deserialization.
 *
 *@JsonDeserialize(as = LinkedList.class) - allows to choose kind of List collection.
 *
 * @JsonDeserialize(contentAs=ValueTypeImpl.class) - for List collections;
 * 	@JsonDeserialize(keyAs=KeyTypeImpl.class) - for Map.
 *
 * @author Kamila Meshcheryakova
 * created by 10.09.2020
 */
@JsonAutoDetect
public class Dog {

    public String name;
    @JsonDeserialize(as = LinkedList.class)
    public List<Dog> dogs;
}
