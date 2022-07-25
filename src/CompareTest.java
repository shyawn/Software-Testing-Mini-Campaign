import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CompareTest {
	Record file1 = Compare.makeRecord("src\\test.csv");
	Record file2 = Compare.makeRecord("src\\test2.csv");
	
	@Test
	public void makeRecordTest() {		
		assertEquals("ID1", file1.getData().get(0).getID());
		assertEquals("ID2", file1.getData().get(1).getID());
		assertEquals("ID3,C,300", file1.getData().get(2).getEntry());
	}
	
	@Test
	public void writeMismatchTest() throws IOException {
		Path txt1 = Files.createTempFile("file1", ".txt");
		Path txt2 = Files.createTempFile("file2", ".txt");
		
		File file1 = new File("src\\test.csv");
		File file2 = new File("src\\test2.csv");
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);
        while (sc1.hasNextLine() || sc2.hasNextLine()) {
        	Files.writeString(txt1, sc1.nextLine());
        	Files.writeString(txt2, sc2.nextLine());
        }
		long mismatch = Files.mismatch(txt1, txt2);
		assertNotEquals(0, mismatch);
	}
}

