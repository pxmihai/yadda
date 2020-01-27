package yaddaSpace.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import yaddaSpace.core.entities.BlogEntry;
import yaddaSpace.rest.mvc.BlogEntryController;
import yaddaSpace.rest.resources.BlogEntryResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry,BlogEntryResource>{ // assemble blogentrysresources

public BlogEntryResourceAsm()
    {
    super (BlogEntryController.class,BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource (BlogEntry blogEntry){
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }



}
