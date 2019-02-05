// CSE 143
// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for testing
// your removeAll method.
import java.util.*;

public class HTMLManagerTest {
	public static void main(String[] args) {
		// <b>Hi</b><br/>
		Queue<HTMLTag> tags = new LinkedList<HTMLTag>();
		tags.add(new HTMLTag("b", HTMLTagType.OPENING));        // <b>
		tags.add(new HTMLTag("b", HTMLTagType.CLOSING));        // </b>
		tags.add(new HTMLTag("kr", HTMLTagType.SELF_CLOSING));  // <br/>
		
		// HTMLManager manager = new HTMLManager(tags);

		// YOUR TESTS GO HERE
      
//       manager.getTags()
//       manager.add(new HTMLTag("lkdfjlkfdsljk", HTMLTagType.OPENING));
//       manager.removeAll(new HTMLTag("br", HTMLTagType.SELF_CLOSING));
      
      
      tags.add(new HTMLTag("z", HTMLTagType.CLOSING));
//       tags.add(new HTMLTag("a", HTMLTagType.OPENING));
//       tags.add(new HTMLTag("c", HTMLTagType.OPENING));
//       tags.add(new HTMLTag("c", HTMLTagType.CLOSING));
//       tags.add(new HTMLTag("e", HTMLTagType.CLOSING));
//       tags.add(new HTMLTag("d", HTMLTagType.OPENING));
      
      HTMLManager manager = new HTMLManager(tags);
      
      manager.getTags();
      System.out.println();

      manager.fixHTML();
      System.out.println();
      
      manager.getTags();
      
      
      
      
	}
}
