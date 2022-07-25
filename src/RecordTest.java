import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class RecordTest {
	Record record = new Record("");
	Record record2 = new Record("ID,Account,Balance");
	Record record3 = new Record("ID,Account,Balance");
	
	@Test
	public void addEntryTest() {
		record.addEntry("ID1,A,100");
		assertEquals("ID1,A,100", record.getData().get(0).getEntry());
	}
	
	@Test
	public void compareRecordTest() {
		record2.addEntry("ID2,B,200");
		record3.addEntry("ID3,C,300");
		String mismatch = "ID2,B,200\nID3,C,300\n";
		assertEquals(mismatch, record2.compareRecord(record3));
	}
	
}
