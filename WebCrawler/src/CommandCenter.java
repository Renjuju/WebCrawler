import java.util.Vector;

public class CommandCenter {
	
	private Vector<Thread> threads = new Vector<>();
	
	public Thread createThread(final String url, final int levels, final Vector<String> keywords) {
    	Thread thread = new Thread() {
    		public void run() {
    			WebCrawler crawler = new WebCrawler();
    			crawler.crawl(levels, url, keywords);
    		}
    	};
    	return thread;
    }
    
    public void start() {
    	Input input = new Input();
    	int val = input.commandCenterOptions();
    	boolean keepGoing = true;
    	while(keepGoing) {
    		switch(val) {
	    		case 1: createThread();  val = input.commandCenterOptions(); break;
	    		case 2: pauseThread();   val = input.commandCenterOptions(); break;
	    		case 3: listAndResume(); val = input.commandCenterOptions(); break;
	    		case 4: System.exit(0);										 break;
    		}
    	}
    }
    
    public void createThread() {
    	UserData userData = new UserData();
    	userData.setUserData();
    	Thread thread = createThread(userData.getUrl(), userData.getLevels(), userData.getKeywords());
    	thread.setName(userData.getUrl());
    	threads.add(thread);
    	threads.get(threads.size()-1).start();
    }
    
    public void pauseThread() {
    	for(Thread t: threads) {
    		try {
				t.wait();
			} catch (Exception e) {
				System.out.println("Paused thread: " + e.getLocalizedMessage());
			}
    	}
    }
    
    public void listAndResume() {
    	System.out.println("List of threads");
    	System.out.println("---------------");
    	for(int i = 0; i < threads.size(); i++) {
    		System.out.println(i + ") " + threads.get(i).getName());
    	}
    	System.out.println("---------------");
    	
    	System.out.println("Resuming all threads");
    	for(Thread t: threads) {
    		t.interrupt();
    	}
    }
}
