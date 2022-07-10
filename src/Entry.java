
import java.util.ArrayList;

public class Entry {
    private int propertyLength;
    private String raw;
    private String[] entryList;

    public Entry(String raw){
        this.raw = raw;
        parseRaw();
    }

    public void parseRaw(){ 
        this.entryList = raw.split(",");
    }

    public String getID(){ 
        return entryList[0];
    }

    public String[] getEntryList(){
        return entryList;
    }

    public Boolean compareEntry(Entry entry){
        if(entryList.length != entry.getEntryList().length){
            return false;
        }
        for(int x = 0; x < entryList.length; x++){
            if(!entryList[x].equals(entry.getEntryList()[x])){
                return false;
            }
        }
        return true;
    }

    public String getEntry(){
        String output = entryList[0];
        for(int x = 1; x < entryList.length; x++) {
			output = output + "," + entryList[x];
		}
        return output;
    }
}