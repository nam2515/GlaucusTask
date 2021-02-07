package com.naman.tagcount.controller;

import com.naman.tagcount.bean.Tag;
import com.naman.tagcount.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    /*
     * This class calls the service method associated with URI and the service is
     * autowired using @Autowired keyword
     */
    @Autowired
    private TagService tagService;

    /*
     * @param args unsused
     * 
     * @return Tag This returns the incremented value of the tag
     */
    @GetMapping(path = "/incrementingTag")
    public Tag increaseTag() throws InterruptedException {
        return tagService.increaseTagCount();

    }

}
