
package jedisclient;

import jedisclient.listexample.RedisListExample;

public class JedisMain {
	   
    public static void main(String[] args){
    	
        String redisHost = "localhost";
        Integer redisPort = 6379;
        
        // key name for the list
        String lstKey = "queue#numList";
        Integer numStart = 1;
        Integer numStop = 10;
        
        RedisListExample redisListExample = new RedisListExample(redisHost, redisPort);
        
        //Create the list and add numbers to it. 
        redisListExample.addNumbers(lstKey, numStart, numStop);
                
        //Display the numbers/result
        redisListExample.displayNumDesc(lstKey, numStart, numStop);
    }
}