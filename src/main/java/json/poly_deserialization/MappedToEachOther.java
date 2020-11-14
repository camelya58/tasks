package json.poly_deserialization;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class MappedToEachOther demonstrates converting from one object to another.
 * The objects don't have any binds, but have the same fields.
 *
 * That's why we can disable annotations "mapper.disable(MapperFeature.USE_ANNOTATIONS)"
 * and convert.
 *
 * @author Kamila Meshcheryakova
 * created by 11.09.2020
 */
public class MappedToEachOther {
    public static void main(String[] args) {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(s);
        System.out.println(f);
    }

    public static Object convertOneToAnother(Object one, Class<?> resultClassObject)  {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        return mapper.convertValue(one, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}
