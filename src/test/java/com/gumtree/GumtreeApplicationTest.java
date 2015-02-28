package com.gumtree;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gumtree.GumtreeApplication;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GumtreeApplication.class)
@WebAppConfiguration
public class GumtreeApplicationTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
