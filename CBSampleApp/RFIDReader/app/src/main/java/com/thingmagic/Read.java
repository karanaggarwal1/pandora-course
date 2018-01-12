/**
 * Sample program that reads tags for a fixed period of time (500ms)
 * and prints the tags found.
 */

// Import the API
package com.thingmagic;



public class Read 
{
	public static String retval;
	public static TagReadData[] readTag( Reader reader) throws Exception
	{
		TagReadData[] tagReads;
		try 
		{
			// Read tags
			tagReads = reader.read(1000);
			// Print tag reads
			for(TagReadData tagReadData:tagReads){
				retval+=tagReadData.epcString()+"\n";
			}
			
		} 
		catch (Exception re)
		{
			throw re;
		}// TODO Auto-generated method stub
				
		return tagReads;
	}
	public static String getReadString(){
		return retval;
	}
}
