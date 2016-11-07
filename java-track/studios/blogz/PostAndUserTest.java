package blogz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostAndUserTest {

	//	@Before
	//	public void setUp() throws Exception {
	//	}
	//
	//	@After
	//	public void tearDown() throws Exception {
	//	}
	//
	//	@Test
	//	public void testUser() {
	//				
	//		fail("Not yet implemented");
	//	}


	@Test
	public void testPost() {

		Post p = new Post("E Rocks!", "Lorem ipsum dolo", "AB", 1);
		assertEquals("E Rocks!", p.getTitle());
		assertEquals("Lorem ipsum dolo", p.getBody());
		assertEquals("AB", p.getAuthor());
	} 	
	@Test
	public void testAddToPostList(){
		Post q = new Post("I love Rocks!", "Lorem ipsum", "AMB", 1);
		Post.addToPostList(q);
		ArrayList<Post> a = Post.getPostList();
		assertEquals("I love Rocks!", a.get(0).getTitle());
		assertEquals("Lorem ipsum", a.get(0).getBody());
		assertEquals("AMB", a.get(0).getAuthor());
		
	}

	//		// now get the post list and make sure your post is there.
	//		
	//		
	//		// now test updating the title. call update title. Then re-get the post. Check to make sure the new title is what you just changed it to.
	//	@Test
	//	public void testUpdateTitle(){
	//		
	//	}
	//		// now test updating the body. call update body and maybe pass it real words :) . Re-get the post and check if you got the expected results.
	//		//assertSame()//, actual);
	//		//fail("Not yet implemented");
	//	}

}
