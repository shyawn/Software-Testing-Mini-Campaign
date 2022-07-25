import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class EntryTest {
	Entry entry1 = new Entry("ID1,A,100");
	Entry entry2 = new Entry("ID1,100,A");
	Entry entry3 = new Entry("ID2,A,100");
	
	@Test
	public void getIDTest() {
		assertEquals("ID1", entry1.getID());
	}
	
	@Test
	public void getEntryTest() {
		assertEquals("ID1,A,100", entry1.getEntry());
	}
	
	@Test
	public void compareEntryTest() {
		assertEquals(false, entry1.compareEntry(entry2));
		assertEquals(false, entry1.compareEntry(entry3));
		assertEquals(false, entry2.compareEntry(entry3));
		assertEquals(true, entry1.compareEntry(entry1));
	}
}
