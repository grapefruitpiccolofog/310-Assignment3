package main.java.wikipedia;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import info.bliki.api.Page;
import info.bliki.api.User;
import info.bliki.wiki.model.WikiModel;

public class wikiData {
	public static String getWiki(String s){
		String[] listOfTitleStrings = { s };
		User user = new User("", "", "http://en.wikipedia.org/w/api.php");
		user.login();
		List<Page> listOfPages = user.queryContent(listOfTitleStrings);
		String html = "";
		for (Page page : listOfPages) {
		  WikiModel wikiModel = new WikiModel("${image}", "${title}");
		  html = wikiModel.render(page.toString());
		}
		
		
		String[] sp = html.split("( )|(</div>)|(<div>)|(<a)|(</a>)|(</p>)|(<p>)|(<b>)"
				+ "|(</b>)|(href=)|(>)|(title=)|(<sup)|(</sup)|(\n)|(Image)|(,)");
		String sent = "";
		boolean print = true;
		for (int i = 1; i < 200; i++){//there is some sort of never ending loop here that gets it to 200 too quickly
			if (sp[i].length() == 0 || sp[i].charAt(sp[i].length()-1) == ';' || sp[i].charAt(sp[i].length()-1) == ':'
					){
				print = false;
			}
			if (sp[i].length() > 0){
				if (sp[i].charAt(0) == '"'){
					while (sp[i].charAt(sp[i].length()-1) != '"'){
						i++;
						while (sp[i].length() == 0){
							i++;
						}
					}
					print = false;
				}
			}else {
				print = false;
			}
			
				
			
			if (print == true){
				
				if (sp[i].charAt(0) != '{' || sp[i].charAt(0) != '(')
				sent = sent + " " + sp[i];
			}
			
			print = true;
				
		}
		String[] sp2 = sent.split("( )");
		String sent2 = "";
		print = true;
		
		for (int j = 0 ; j < sp2.length; j++){
			
			if (sp2[j].length() > 0){
				
				if (sp2[j].charAt(0) == '{' || sp2[j].charAt(0) == '('){
					char m = sp2[j].charAt(0);
					char n;
					if (m == '{'){
						n =  '}';
					}else{
						n = ')';
					}
					while (j < sp2.length && sp2[j].charAt(sp2[j].length()-1) != n){
						j++;
						while (j < sp2.length && sp2[j].length() == 0){
							j++;
						}
					}
					print = false;
				}
			}else {
				print = false;
			}
			
			if (print == true){
				
				if (sp2[j].length() > 0){
					sent2 = sent2 + " " + sp2[j];
				}
				
					
			}
			
			print = true;
			
		}
		//System.out.println(sent);
		//System.out.println(sent2);
		String returnsent = "";
		String[] sp3 = sent2.split("( )");
		int k = 0;
		while (!sp3[k].equals(".")){
			returnsent = returnsent + " " + sp3[k];
			k++;
		}
		return returnsent;

	}
}
