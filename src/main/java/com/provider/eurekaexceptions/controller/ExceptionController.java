package com.provider.eurekaexceptions.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExceptionController {
	
	private static Map<String, HttpStatus> mapData = new HashMap<String, HttpStatus>();
	 
    static {
    	mapData.put("100", HttpStatus.CONTINUE);
    	mapData.put("101", HttpStatus.SWITCHING_PROTOCOLS);
    	mapData.put("102", HttpStatus.PROCESSING);
    	mapData.put("103", HttpStatus.CHECKPOINT);
    	mapData.put("201", HttpStatus.CREATED);
    	mapData.put("203", HttpStatus.CREATED);
    	mapData.put("404", HttpStatus.NOT_FOUND);
    }
	
	
    
   @GetMapping(value="/error/{errorMessage}")
   public @ResponseBody Map<Object, Object> getError(@PathVariable("errorMessage") String errorMessage)
   {
	   String[] error=errorMessage.split(" ");
	   /*if(mapData.containsKey(error[0].trim()))
	   {
		   mapData.entrySet().stream().map(new Function<Map.Entry<String, HttpStatus>, Map.Entry<String, HttpStatus>>() {

			@Override
			public Entry<String, HttpStatus> apply(Entry<String, HttpStatus> t) {
				// TODO Auto-generated method stub
				return t;
			}
		}).
		   
		   filter( new Predicate<Map.Entry<String, HttpStatus>>() {

			@Override
			public boolean test(Entry<String, HttpStatus> t) {
				return t.getKey().equals(error[0])?true:false;
			}
			   
		}).collect(Collectors.toMap(x->x, x->x));
		   
		   
		   mapData.entrySet().stream().map(new Function<Map.Entry<String, HttpStatus>, Map.Entry<String, HttpStatus>>() {

				@Override
				public Entry<String, HttpStatus> apply(Entry<String, HttpStatus> t) {
					// TODO Auto-generated method stub
					return t;
				}
			}).
			   
			   filter( new Predicate<Map.Entry<String, HttpStatus>>() {

				@Override
				public boolean test(Entry<String, HttpStatus> t) {
					return t.getKey().equals(error[0])?true:false;
				}
				   
			}).forEach(new Consumer<Map.Entry<String, HttpStatus>>() {

				@Override
				public void accept(Entry<String, HttpStatus> t) {
					System.err.println(t.getKey()+" "+t.getValue());
					
				}
			});
	   }*/
	   return mapData.entrySet().stream().map(t->t).filter(t->t.getKey().equals(error[0])?true:false).collect(Collectors.toMap(x->x, y->y));
   }
   
}