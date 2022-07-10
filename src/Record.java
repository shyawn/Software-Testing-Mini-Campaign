import java.util.ArrayList;

public class Record {
    private int propertyLength;
    private String[] properties;
    private ArrayList<Entry> data;

    public Record(String properties){
        data = new ArrayList<Entry>();
        this.properties= properties.split(",");
        this.propertyLength= properties.length();
    }

    public void addEntry(String raw){
        Entry entry= new Entry(raw);
        data.add(entry);
    }

    public ArrayList<Entry> getData(){
        return data;
    }
    
    public String compareRecord(Record record){ 
        String mismatch = "";
        for (int x = 0; x < data.size(); x++){
            for (int y = 0; y < record.getData().size(); y++){
                if (data.get(x).getID().equalsIgnoreCase(record.getData().get(y).getID())){
                    Boolean sameValue = data.get(x).compareEntry(record.getData().get(y));
                    if (!sameValue){
                        String output = data.get(x).getEntry() + "\n" + record.getData().get(y).getEntry() + "\n";
                        mismatch += output;  
                    }
                }
            }
        }
        return mismatch;
    }
}
