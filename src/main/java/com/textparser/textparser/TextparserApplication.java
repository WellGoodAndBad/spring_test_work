package com.textparser.textparser;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.ArrayList;


public class TextparserApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		HtmlParser htmlParser = (HtmlParser) context.getBean("htmlParser");
		try {
			ArrayList<String> list = htmlParser.getHtml();
			TextToDoc doc = (TextToDoc) context.getBean("textToDoc");;
			doc.makeDoc(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
