package com.agibilibus.SIGET.model;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoBroker {

	private static MongoBroker yo;
	private MongoClientURI uri;
	private MongoClient mongoClient;
	private MongoDatabase db;
	
	private MongoBroker(){
 		this.uri = new MongoClientURI("mongodb://siget:siget@cluster0-shard-00-00.x8ylj.mongodb.net:27017,cluster0-shard-00-01.x8ylj.mongodb.net:27017,cluster0-shard-00-02.x8ylj.mongodb.net:27017/siget?ssl=true&replicaSet=atlas-njv3nf-shard-0&authSource=admin&retryWrites=true&w=majority");
 		this.mongoClient= new MongoClient(uri);
        this.db= mongoClient.getDatabase("siget");
	}
	
	public static MongoBroker get(){
		if(yo==null){
			yo=new MongoBroker();
		}
		return yo;
	}
	
	public MongoCollection<Document> getCollection(String collection){
		MongoCollection<Document> result=db.getCollection(collection, Document.class);
		if(result==null){
			db.createCollection(collection);
			result = db.getCollection(collection,Document.class);
		}
		return result;
	}
	public boolean createCollection(String name) {
		try {
			db.createCollection(name);
			return true;
		}catch(Exception e) {return false;}
	}
	public void close() {
		mongoClient.close();
		yo = null;
	}
}
