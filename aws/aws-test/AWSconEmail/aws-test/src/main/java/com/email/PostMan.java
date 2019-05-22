package com.email;

public interface PostMan {

    /**

     * Interfaz creada para que los metodos que estan abajo sean implementados obligatoriamente en las clases que 
     * extienden de esta interfaz

     */
	
    void setFrom(String from);
    
    void setTo(String To);
    
    void setSubject(String subject);
    
    void setBody(String body);
    
    void send();
    
    PostMan withFrom(String from);
    
    PostMan withTo(String to);
    
    PostMan withSubject(String subject);
    
    PostMan withBody(String body);
	
	
}
