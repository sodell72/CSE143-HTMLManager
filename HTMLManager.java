import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

public class HTMLManager {
   // the queue containing the HTMLTags
	private Queue<HTMLTag> page;
   // the number of HTMLTags in the working queue
   private int numberOfTags;
	
   // constructs HTMLManager, creates a copy of the input page to a working page and sets 
   // the initial number of tags
	public HTMLManager(Queue<HTMLTag> page) { 
		if (page == null) {
			throw new IllegalArgumentException();
		}
		this.page = new LinkedList<HTMLTag>();
		this.numberOfTags = page.size();
		for (int i = 0; i < numberOfTags; i++) {
			HTMLTag currentTag = page.remove();
			page.add(currentTag); 
			this.page.add(currentTag); // isn't this just referencing the same tag 
                                    // and not actually creating a copy??
		}
	}
	
   // returns a list of the tags currently in the working queue
	public List<HTMLTag> getTags() { // is there an easier way to convert to a list 
                                    // at this point in 143??
      List<HTMLTag> result = new ArrayList<HTMLTag>();
      for (int i = 0; i < this.numberOfTags; i++) {
         HTMLTag currentTag = this.page.remove();
         System.out.println(currentTag.toString()); // debugging purposes
         page.add(currentTag);
         result.add(currentTag);
      }
		return result;
	}
	
   // adds tag to working queue
	public void add(HTMLTag tag) {
		if(tag == null) {
         throw new IllegalArgumentException();
      } else {
         this.page.add(tag);
         this.numberOfTags++;
         System.out.println(tag + " " + this.numberOfTags); // debugging purposes
      }
	}
	
   // removes all occurences of the given tag from the working queue
	public void removeAll(HTMLTag tag) {
		if(tag == null) {
         throw new IllegalArgumentException();
      } else {
         for (int i = 0; i < this.numberOfTags; i++) {
            HTMLTag currentTag = this.page.remove();
            if (!tag.equals(currentTag)) {
               this.page.add(currentTag);
               System.out.println(currentTag.toString()); // debugging purposes
            }
         }
      }
	}
	
   // fixes HTML errors
	public void fixHTML() {
		Stack<HTMLTag> checker = new Stack<HTMLTag>();
      HTMLTag currentTag;
      int iter = this.numberOfTags;
      for (int i = 0; i < iter; i++) {
         currentTag = this.page.remove();
         if (currentTag.isOpening()) {
            checker.push(currentTag);
            this.page.add(currentTag);
            System.out.println(currentTag.toString()); // debugging purposes
         } else if (currentTag.isClosing()) {
            if (!checker.isEmpty()){
               if (currentTag.matches(checker.peek())) { // can't check peek if checker is empty
               // is empty, does putting it first in the if have the same result??  This is part of simplification problem.
             //if (!checker.isEmpty() && currentTag.matches(checker.peek())) {  
                  checker.pop();
                  this.page.add(currentTag);
                  System.out.println(currentTag.toString()); // debugging purposes
               } else {
                  this.numberOfTags--; // need to simplify?
               }
            } else {
               this.numberOfTags--; // need to simplify?
            }
         } else if (currentTag.isSelfClosing()) {
            this.page.add(currentTag);
            System.out.println(currentTag.toString()); // debugging purposes
         }
      }
      while(!checker.isEmpty()) {
         currentTag = checker.pop();
         this.page.add(currentTag.getMatching());
         System.out.println(currentTag.getMatching().toString()); // debugging purposes
         this.numberOfTags++;
      }
	}
}
