package resources;

/**
 * Created by sgrimanov on 29.12.2016.
 */
public class ResourceServer {

    private TestResource resource;

    public ResourceServer(TestResource resource){
        this.resource = resource;
    }

    public ResourceServer(){

    }

    public int getAge(){
        return resource.getAge();
    }

    public String getName(){
        return resource.getName();
    }

    public void setResource(TestResource resource){
        this.resource = resource;
    }



}
