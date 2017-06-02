package com.zhangmiao;
import javax.lang.model.element.Modifier;

import com.squareup.javapoet.*;

import java.io.File;
import java.io.IOException;
import java.lang.System;

public class MainClass {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass mainClass = new MainClass();
		mainClass.generateHelloWord();
		
	}
	
	private void generateHelloWord(){
		MethodSpec main = MethodSpec.methodBuilder("show")
	      .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
	      .addStatement("$T.out.println($S)",System.class,"Hello World!")
	      .build();
		TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
		.addModifiers(Modifier.PUBLIC)
		.addMethod(main)
		.build();
		
		JavaFile javaFile = JavaFile.builder("com.zhangmiao", helloWorld).build();
		File outputFile = new File("src/"); //Êä³öÎÄ¼þ 
		
		try {
			javaFile.writeTo(outputFile);
			javaFile.writeTo(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
