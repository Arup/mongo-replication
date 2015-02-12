package com.replicaset.core;
import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class ReplicaSetStatus {

	public void getReplSetStatus() {
	    MongoClient mongo = null;
		com.mongodb.ReplicaSetStatus rss =null;
	    MongoClient freshClient = null;

	    try {
		     mongo = new MongoClient("localhost", 20000);
		     rss = mongo.getReplicaSetStatus();
	        com.mongodb.ReplicaSetStatus replicaSetStatus = mongo.getReplicaSetStatus();
			if ( replicaSetStatus != null ) {
			    if ( replicaSetStatus.getMaster() != null ) {
			        System.exit(9);
			    } else {
			        freshClient = new MongoClient( mongo.getAllAddress());
			        replicaSetStatus = freshClient.getReplicaSetStatus();
			        if ( replicaSetStatus != null ) {
			           // rss = replicaSetStatus.getMaster() != null ? com.mongodb.ReplicaSetStatus.this.getMaster(): ReplSetStatus.ReadOnly;
			        } else {
			            System.out.println( "freshClient.getReplicaSetStatus() is null" );
         
			        }
			    }
			} else {
				 System.out.println( "mongo.getReplicaSetStatus() returned null" );
			}
	    } catch ( Throwable t ) {
	    	System.out.println("Ingore unexpected error" );
	    } finally {
	        if ( freshClient != null ) {
	            freshClient.close();
	        }
	    }
}
}
