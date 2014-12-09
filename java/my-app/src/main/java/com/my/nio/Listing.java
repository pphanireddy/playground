package com.my.nio;

import java.util.*;
import java.net.*;
import java.nio.file.*;
import java.lang.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class Listing {
  public static void List(String[] args) {
    String path = "file:///usr/local/bin";
    Path listing = Paths.get(URI.create(path));
    
    System.out.println("File Name [" + listing.getFileName() + "]");
    System.out.println("Number of Name Elements in the Path [" + listing.getNameCount() + "]");
    System.out.println("Parent Path [" + listing.getParent() + "]");
    System.out.println("Root of Path [" + listing.getRoot() + "]");
    System.out.println("Subpath from Root, 2 elements deep [" + listing.subpath(0, 2) + "]");

    try(DirectoryStream<Path> stream = Files.newDirectoryStream(listing, "*")) {
      for (Path entry: stream)
      {
        System.out.println(entry.getFileName());
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void RunChannelExample(String[] args) {
    try
    {
      RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
      FileChannel inChannel = aFile.getChannel();

      ByteBuffer buf = ByteBuffer.allocate(48);

      int bytesRead = inChannel.read(buf);
    
      while (bytesRead != -1) {
        System.out.println("(Read " + bytesRead + ")");
        buf.flip();
        while(buf.hasRemaining()){
          System.out.print((char) buf.get());
        }
        buf.clear();
        bytesRead = inChannel.read(buf);
      }
    
      aFile.close();
    }
    catch (Exception ex)
    {
      System.out.println("An error occurred in RunChannelExample: " + ex);
    }
  }

  public static void RunSelectorExample(String[] args) {
    /*
    Selector selector = Selector.open();
    RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
    FileChannel inChannel = aFile.getChannel();
    inChannel.configureBlocking(false);
    inChannel.register(selector, SelectionKey.OP_READ);

    while(true) {
        int readyChannels = selector.select();
        if(readyChannels == 0) continue;

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

        while(keyIterator.hasNext()) {
          SelectionKey key = keyIterator.next();
          if(key.isAcceptable()) {
            System.out.println("a connection was accepted by a ServerSocketChannel");
          } else if (key.isConnectable()) {
            System.out.println("a connection was established with a remote server");
          } else if (key.isReadable()) {
            System.out.println("a channel is ready for reading");
          } else if (key.isWritable()) {
            System.out.println("a channel is ready for writing");
          }        
          keyIterator.remove();
        }
     }
     */
  }
}
