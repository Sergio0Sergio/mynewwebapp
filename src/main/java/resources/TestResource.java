package resources;

/**
 * Created by sg on 21.12.2016.
 */
@SuppressWarnings("UnusedDeclaration")
public class TestResource {

    private final String name;
    private final int age;

    public TestResource(){
        name = "";
        age = 0;
    }

    public TestResource(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
