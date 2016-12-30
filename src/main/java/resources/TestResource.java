package resources;

/**
 * Created by sg on 21.12.2016.
 */
@SuppressWarnings("UnusedDeclaration")
public class TestResource {

    private String name;
    private int age;

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

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
}
