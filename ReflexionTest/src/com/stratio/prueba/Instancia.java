package com.stratio.prueba;

public class Instancia { 	
	 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	        Class _class = Class.forName("com.stratio.prueba.ClaseA");
	        ClaseA objA = (ClaseA)_class.newInstance();
	        System.out.println(objA.toString());
	    }
}
