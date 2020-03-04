package yaddaSpace.rest.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import yaddaSpace.core.entities.Entry;
import yaddaSpace.rest.mvc.EntryController;
import yaddaSpace.rest.resources.EntryResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class EntryResourceAsm extends ResourceAssemblerSupport<Entry, EntryResource>{ // assemble blogentrysresources

public EntryResourceAsm()
    {
    super (EntryController.class, EntryResource.class);
    }

    @Override
    public EntryResource toResource (Entry blogEntry){
        EntryResource res = new EntryResource();
        res.setTitle(blogEntry.getTitle());
        Link link = linkTo(EntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }



}
