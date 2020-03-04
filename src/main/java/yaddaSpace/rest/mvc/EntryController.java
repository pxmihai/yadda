package yaddaSpace.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yaddaSpace.core.entities.Entry;
import yaddaSpace.core.services.EntryService;
import yaddaSpace.rest.resources.EntryResource;
import yaddaSpace.rest.resources.asm.EntryResourceAsm;


@Controller
@RequestMapping("/rest/blog-entries/")
public class EntryController {

    private EntryService service;

    public EntryController(){};

    public EntryController(EntryService service)
    {
        this.service = service;
    }
    @RequestMapping(value="/{blogEntryId}",
        method = RequestMethod.GET )
    public ResponseEntity<EntryResource> getBlogEntry(
            @PathVariable Long blogEntryId){
        Entry entry = service.find(blogEntryId);
        if(entry!=null) {
            EntryResource res = new EntryResourceAsm().toResource(entry);
            return new ResponseEntity<EntryResource>(res, HttpStatus.OK);
        }else {
            return new ResponseEntity<EntryResource>(HttpStatus.NOT_FOUND);

        }
    }

}
