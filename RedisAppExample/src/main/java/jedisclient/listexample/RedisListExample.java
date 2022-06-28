package jedisclient.listexample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class RedisListExample {
		
	    private Jedis jedis = null;
	    
	    public RedisListExample(String redisHost, Integer redisPort) {
	    	jedis = new Jedis(redisHost, redisPort);
	        System.out.println("\n\nConnected to Redis host: " + redisHost + ":" + redisPort + 
	        				   "\n--------------------------------------------------------------------");
	    }
	 
	    /* Add to a redis list type */
	    public void addNumbers(String lstKey, Integer iStart, Integer iStop) {

	        try {
	        	// clear the key to remove any previous values.
	        	jedis.del(lstKey);
	        	
	        	for(int i=iStart; i<=iStop; i++) {
	        		jedis.lpush(lstKey, Integer.toString(i));
	        	}
	       
	        } catch (JedisException e) {
	        	System.out.println("Exception occurred..."+ e.getMessage());
	        }
	    }
	    
	    /* Display the numbers reverse order */    
	    public void displayNumDesc(String lstKey, Integer iStartPos, Integer iStopPos) {
	    	
	    	System.out.println("\n\nThe input series is ..." + displayNumAsc(lstKey));
	    	System.out.println("--------------------------------------------------------------------");
	    	
	    	// print the command string
	    	String cmdString = 
	    			"[jedis.lrange(" + 
	    			lstKey + "," + 
	    			Integer.toString(iStartPos-iStartPos) + "," + 
	    			Integer.toString(iStopPos-(iStopPos+1)).toString() + ")]";
	    	System.out.println("\n\nThe reversed series is ..." + cmdString);
	    	System.out.println("--------------------------------------------------------------------");
	    	try {
	    		System.out.println(jedis.lrange(lstKey, (iStartPos-iStartPos),(iStopPos-(iStopPos+1))));
	    	}
	        catch (JedisException e) {
	        	System.out.println("Exception occurred..."+ e.getMessage());
		    }
	    }
	    
	    /* Display the numbers ascending order */
	    private String displayNumAsc(String lstKey) {
	    
	    	// print the command string
	    	// System.out.println("jedis.sort(" + lstKey + ")");

	    	return("[jedis.sort(" + lstKey + ")]\n" + jedis.sort(lstKey).toString());
	    }
}


