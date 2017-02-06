package com.ironyard.repo;

import com.ironyard.data.MovieUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 2/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Transactional
    public void testUserOperations(){
        MovieUser usr = new MovieUser();
        usr.setPassword("pass");
        usr.setDisplayName("Jason Skipper");
        usr.setUsername("skipper.jason@gmail.com");
        userRepo.save(usr);

        long savedUserId = usr.getId();

        MovieUser found = userRepo.findOne(savedUserId);

        assertNotNull("Can't find user after saving!", found);
        assertEquals("Displayname miss-match after save", usr.getDisplayName(), found.getDisplayName());
        // test update
        found.setPassword("pass2");
        userRepo.save(found);
        MovieUser found2 = userRepo.findOne(savedUserId);
        assertEquals("Update pass failed", "pass2", found2.getPassword());
        // test delete
        //userRepo.delete(found2);
        //assertNull("Delete failed", userRepo.findOne(found2.getId()));
    }
}