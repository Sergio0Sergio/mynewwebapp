package resources;

/**
 * Created by sg on 21.12.2016.
 */
public class TestResources {

    private String name;
    private int age;

    public TestResources(String name,int age){
        this.name = name;
        this.age = age;
    }

    public TestResources(){
        this.name = "";
        this.age = 0;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
