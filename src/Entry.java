import java.util.ArrayList;

public class Entry {
    private int propertyLength;
    private String raw;
    private String[] entryList;

    public Entry(String raw){
        this.raw = raw;
        this.entryList = raw.split(",");
    }

    public String getID(){ 
        return entryList[0];
    }

    public String getEntry(){
        String output = entryList[0];
        for(int x = 1; x < entryList.length; x++) {
			output = output + "," + entryList[x];
		}
        return output;
    }
    
    public Boolean compareEntry(Entry entry){
        if(this.entryList.length != entry.entryList.length){
            return false;
        }
        
        for(int x = 0; x < entryList.length; x++){
            if(!this.entryList[x].equals(entry.entryList[x])){
                return false;
            }
        }
        return true;
    }
}