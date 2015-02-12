package com.replicaset.core;
import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class RepSetStatus {

	public void getReplSetStatus() {
		//MongoClient mongo[]=null;
	    //MongoClient mongo1 = null;
	    //MongoClient mongo2 = null;
		MongoClient mongo=null;
	    //Boolean isMaster[]=null;
	    boolean isMaster;
		com.mongodb.ReplicaSetStatus rss =null;
	    MongoClient freshClient = null;

	    try {
	    	//mongo=new MongoClient[2];
	    	//isMaster=new Boolean[2];
	    	
	    	 mongo = new MongoClient();
		     //mongo2 = new MongoClient(HostNames.hostname2,HostNames.port2);
	    	
//		     mongo1 = new MongoClient(HostNames.hostname1,HostNames.port1);
//		     mongo2 = new MongoClient(HostNames.hostname2,HostNames.port2);
		     
		     //mongo[0]=mongo1;
		     //mongo[1]=mongo2;
		     //rss = mongo1.getReplicaSetStatus();
		   /*  
		    for(int count=0;count<mongo.length;count++){
	        com.mongodb.ReplicaSetStatus replicaSetStatus = mongo[count].getReplicaSetStatus();
	        
			if ( replicaSetStatus != null ) {
			    if ( replicaSetStatus.getMaster() != null ) {
			        System.out.println("It is master, we are good");
			        isMaster[count]=true;			        
			    }else{
			    	isMaster[count]=false;
			    }
			} else {
				isMaster[count]=false;
			}
		    }
		    
		    
		    if(isMaster[0]==false && isMaster[1]==false){
		    	System.out.print("No Masters found");
		    	System.exit(9);
		    }else if(isMaster[0]==true){
		    	System.out.println("One is master, we are good");
		    }else if(isMaster[1]==true){
		    	System.out.println("One is master, we are good");
		    }else{
		    	throw new Exception("Unknown state");
		    }
		   */ 
	    	 
	    	 com.mongodb.ReplicaSetStatus replicaSetStatus = mongo.getReplicaSetStatus();
	    	 
				if ( replicaSetStatus != null ) {
				    if ( replicaSetStatus.getMaster() != null ) {
				        System.out.println("It is master, we are good");
				        isMaster=true;			        
				    }else{
				    	isMaster=false;
				    }
				} else {
					isMaster=false;
				}
			    
				
			    if(isMaster==false){
			    	System.out.print("No Masters found");
			    	System.exit(9);
			    }
		    
	    } catch ( Exception e ) {
	    	System.out.println("Ingore unexpected error" );
	    	e.printStackTrace();
	    } finally {
	        if ( freshClient != null ) {
	            freshClient.close();
	        }
	    }
}
}
