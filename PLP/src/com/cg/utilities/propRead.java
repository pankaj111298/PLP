package com.cg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propRead {

	static FileInputStream f;
 	static Properties p;
 	public static String getprop(String propname) throws IOException
 	{
 		String val="";
 		f=new FileInputStream(new File(System.getProperty("user.dir")+"/src/com/cg/config/config.properties"));
 		p=new Properties();
 		p.load(f);
 		val=p.getProperty(propname);
 		return val;
 		
 	}

}
