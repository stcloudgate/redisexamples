
package jedisclient;

import jedisclient.listexample.RedisListExample;

public class JedisMain {
	   
    public static void main(String[] args){
    	
        String redisSrcHost = "localhost";
        Integer redisSrcPort = 6379;
        
        // key name for the list
        String lstKey = "queue#numList";
        Integer numStart = 1;
        Integer numStop = 100;
        
        RedisListExample redisListExampleSrc = new RedisListExample(redisSrcHost, redisSrcPort);
        
        //Create the list and add numbers to it. 
        redisListExampleSrc.addNumbers(lstKey, numStart, numStop);
                
        //Display the numbers/result from destination Server
        String redisDestHost = "localhost";
        Integer redisDestPort = 6379;
        RedisListExample redisListExampleDest = new RedisListExample(redisDestHost, redisDestPort);
        redisListExampleDest.displayNumDesc(lstKey, numStart, numStop);
    }
}