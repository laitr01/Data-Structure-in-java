/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> list2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i <1000; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		list2 = new MyLinkedList<>();
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		//emptyList.get(9);
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.print(e.getMessage());
		}
		try {
			shortList.get(4);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			longerList.get(1000);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		//list1.print();
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			longerList.remove(1001);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		boolean a = list1.add((Integer)10);
		assertEquals("Add: check a is correct ", true, a);
		assertEquals("Add: check element last is correct ", (Integer)10, list1.get(3));
		assertEquals("Add: check size is correct ", 4, list1.size());
		try {
			shortList.add(null);
			fail("MyLinkedList: Null elements not permitted in List.");
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size of shortList", 2, shortList.size());
		assertEquals("Size: check size of longerList", 1000, longerList.size());
		assertEquals("Size: check size of list1", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(2,(Integer)10);
		//list1.print();
		//assertEquals("AddAtIndex: check element 2 is correct ", 2, list1.add(3));
		assertEquals("AddAtIndex: check size is correct ", 4, list1.size());
		try {
			longerList.add(-1, (Integer)10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			longerList.add(1000+1, (Integer) 20);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			shortList.add(1, null);
			fail("MyLinkedList: Null elements not permitted in List.");
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		int a = longerList.set(1, (Integer) 7 );
		//longerList.print();
		int c = longerList.set(5, (Integer) 2000 );
		assertEquals("Set: check element is correct ", 1, a);
		assertEquals("Set: check element change is correct ",5, c);
		assertEquals("Set: check size is correct ", 1000, longerList.size());
		try {
			list2.set(0, (Integer) 10 );
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		//longerList.print();
		try {
			longerList.set(-1, (Integer) 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
