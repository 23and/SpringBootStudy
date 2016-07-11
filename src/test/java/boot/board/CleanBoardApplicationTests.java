package boot.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import boot.board.CleanBoardApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CleanBoardApplication.class)
@WebAppConfiguration
public class CleanBoardApplicationTests {

	@Test
	public void contextLoads() {
	}

}
