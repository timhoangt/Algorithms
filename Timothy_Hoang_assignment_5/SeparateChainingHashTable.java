/*Timothy Hoang
3/03/19
CMPT435-111*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SeparateChainingHashTable<AnyType>
{
	
    private static final int DEFAULT_TABLE_SIZE = 101;

    /** The array of Lists. */
    private List<Item> [ ] theLists; 
    private int currentSize;
	
    /**
     * Construct the hash table.
     */
    public SeparateChainingHashTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size approximate table size.
     */
    public SeparateChainingHashTable( int size )
    {
        theLists = new LinkedList[ size ];
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList<>( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then update the item.
     * @param x the item to insert.
     */
    public void insert( Object gkey, Object gvalue )
    {
        List<Item> whichList = theLists[ myhash( gkey ) ];
        
        
        int getindex = keyexist(whichList, gkey);
        Item newitem = new Item(gkey,gvalue);
    
        if( getindex == -1 )
        {
        	
        	whichList.add(newitem);
        }
        else
        {    
        	//System.out.println("new value "+ gvalue);
        	//System.out.println("current value in the list "+ whichList.get(getindex).value);
        	whichList.set(getindex, newitem);
        }

    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove( Object gkey )
    {
        List<Item> whichList = theLists[ myhash( gkey ) ];
        int getindex = keyexist(whichList, gkey);
        if( getindex != -1 )
        {
        	whichList.remove(getindex);
            currentSize--;
        }
    }
    
    public int keyexist(List<Item> glist, Object gkey)
    {
    	Iterator<Item> iterator = glist.iterator();
    	int index = 0;
        while (iterator.hasNext()) {
            Item current = iterator.next();
            if (current.key.equals(gkey)) {
                return index;
            }
            index++;
        }
        return -1;
    	
    }
    
    public Item get( Object gkey )
    {
        List<Item> whichList = theLists[ myhash( gkey ) ];
        int getindex = keyexist(whichList, gkey);
        if( getindex != -1 )
        {
        	return whichList.get(getindex);
        }
        
        return null;
    }
    
    /**
     * Find an item in the hash table.
     * @param string the item to search for.
     * @return true if x isnot found.
     */
    public boolean contains( Object gkey )
    {
        List<Item> whichList = theLists[ myhash( gkey ) ];
        Iterator<Item> iterator = whichList.iterator();
        while (iterator.hasNext()) {
            Item current = iterator.next();
            if (current.key.equals(gkey)) {
                return true;
            }

        }
        return false;
    }
    
    public boolean containsValue( Object gvalue )
    {
       for(int i = 0; i < theLists.length; i++)
       {
    	List<Item> whichList = theLists[ i ];
        Iterator<Item> iterator = whichList.iterator();
        while (iterator.hasNext()) {
            Item current = iterator.next();
            if (current.value.equals(gvalue)) {

                return true;
            }

        }
       }
        return false;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ].clear( );
        currentSize = 0;    
    }



    private int myhash( Object x )
    {
        int hashVal = x.hashCode( );

        hashVal %= theLists.length;
        if( hashVal < 0 )
            hashVal += theLists.length;

        return hashVal;
    }
    

 

        // Simple main
    public static void main( String [ ] args ) throws FileNotFoundException
    {
		File file = new File("/Users/timhoangt/desktop/Assignment5/AccessLog.txt"); // Replace path_to_AccessLog.txt by the path of AccessLog.txt on your computer, i.e., if you place the AccessLog.txt on the desktop of Windows, most likely, the path would be "C:/Users/Bowu/Desktop/AccessLog.txt"
		Scanner sc = new Scanner(file);
		String gIP = "66.249.65.12"; // You can test other IPV4 addresses as well
		SeparateChainingHashTable hm = new SeparateChainingHashTable(); // new hashtable
		
		 while (sc.hasNextLine()) //Read AccessLog line by line
		 {
			 String[] parts = sc.nextLine().split("\\s+"); // Split the line into 2 elements and save them in parts[]
			 String key = parts[0]; // Read the IPV4 address in the line
			 
			 //Complete the method from here
			 //Count the number of times the given IP gIP occurs in AccessLog.txt
			 //Your method must use the SeparateChainingHashTable class
			 

             Boolean flag1 = hm.contains(key); //flag checks to see if the key exists
             if(flag1 == false){ //if the key does not exist
                hm.insert(key, 1); //set the initial value to 1
                flag1 = true; //set the flag for this key to true, meaning it does exist
             }
             else if(flag1 == true){ //if the key does exist
                int number  = (int) hm.get(key).value; //retrieve the current value
                number ++; //increment it by one
                hm.insert(key, number); //set the new value for the key
             }

             

			 
			 
			 
			 
		 }
		 
		 System.out.println(gIP + " occurs " + hm.get(gIP).value);
		 //Output should be 32
        
       
        

    }

}
