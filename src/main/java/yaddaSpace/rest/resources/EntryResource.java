package yaddaSpace.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Mihai7 on 12/16/2015.
 */
public class EntryResource extends ResourceSupport{
    private String title;
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

}
