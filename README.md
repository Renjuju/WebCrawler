[![Code Climate](https://codeclimate.com/github/Renjuju/WebCrawler/badges/gpa.svg)](https://codeclimate.com/github/Renjuju/WebCrawler)

#Multithreaded WebCrawler
An application for web-crawling at multiple user specified depths.
This application scrapes all web content starting from the base URL.

## Install
Choose your favorite IDE(Eclipse)
* Import the project
* Run CrawlRunner.java

```java
import java.util.concurrent.ExecutionException;

/**
* Created by Renju R on 1/9/2016.
*/
public class CrawlRunner {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CommandCenter cm = new CommandCenter();
    cm.start();    	
  }
}
```

## Features
* Multithreaded
* PageRank
* Interactive menu: **Start, Pause, Resume, Quit**
* Robots.txt support
* User filter with user specified keywords support

![alt text](http://i.imgur.com/2VpuLV1.gif "This just looks really cool")
