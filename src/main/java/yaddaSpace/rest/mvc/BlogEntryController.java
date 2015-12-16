package yaddaSpace.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yaddaSpace.core.entities.BlogEntry;
import yaddaSpace.core.services.BlogEntryService;
import yaddaSpace.rest.resources.BlogEntryResource;
import yaddaSpace.rest.resources.asm.BlogEntryResourceAsm;


@Controller
@RequestMapping("/rest/blog-entries/")
public class BlogEntryController {

    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service)
    {
        this.service = service;
    }
    @RequestMapping(value="/{blogEntryId}",
        method = RequestMethod.GET )
    public ResponseEntity<BlogEntryResource> getBlogEntry(
            @PathVariable Long blogEntryId){
        BlogEntry entry = service.find(blogEntryId);
        if(entry!=null) {
            BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
            return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
        }else {
            return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);

        }
    }

}
