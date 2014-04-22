package test.slowvic;

import static org.junit.Assert.assertEquals;
import net.slowvic.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration("classpath:spring3-test.xml")
public class TestExam01 {

    @Autowired
    private User user;

    @Test
    public void isSherlock() {
        assertEquals("Homes", user.getUserName());
    }
}
