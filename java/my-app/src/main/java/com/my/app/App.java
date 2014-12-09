package com.my.app;

import com.my.nio.*;
import com.my.akka.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello, Rayaru!" );
        Listing.List(args);
        Listing.RunChannelExample(args);
        AkkaWay.RunAkkaWay(args);
        JavaWay.RunJavaWay(args);
    }
}
