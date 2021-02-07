package com.naman.tagcount.service;

import com.naman.tagcount.bean.Tag;
import com.naman.tagcount.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    /*
     * This is a Service class and it is autowired with Repository it retrieves the
     * data from the repository and increment it and also save that the value back
     * in the database
     */

    @Autowired
    private TagRepository tagRepository;

    // lock variable for the synchronization of the api calls

    private static final Object lock = new Object();
    Tag tag = new Tag();

    // Method to increase the tag value

    public Tag increaseTagCount() {
        // getting the Id associated with the tag to check whether the initial count is zero or not
        String id = tag.getTagId();

        // critical section of the code. CRUD(Create, Repplace, Update, Delete)
        // operation being performed.
        // synchronized the critical section as parallel api calls are incrementing the
        // value

        try {
            synchronized (lock) {

                // Checking whether the intial value of the tag is 0 and tagId is null

                if (tag.getTagId() == null || tag.getTagId().isEmpty()) {
                    tag = tagRepository.insertFirstValue();
                    tagRepository.save(tag);

                } else {
                    tag = tagRepository.findOne(id);
                    tag.setNumber(tag.getNumber() + 1);
                    tagRepository.save(tag);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return tag;
    }

}
