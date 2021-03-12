## Required softwares
1. JDK (8+)
2. Maven (https://maven.apache.org/install.html)
# x, y co-ordinates
Top left on the monitor is x=0, y = 0. To move the mouse to the right, increase x. To move the 
mouse pointer down, increase y.

It is trial and error to move the pointer to the right spot. 

In the `BookRobo.java`, method `bookCourt`, start by commenting out all the methods except
`openBrowser`. Once the browser is opened successfully, uncomment the next method and adjust as 
needed.


#To run / Trial and errors. 
* mvn package
* java -jar <directory>/target/sel-book-courts-1.0.jar


##On Mac to schedule the job

* Copy the file. From Terminal `cp resources/org.genil.book.court.plist  ~/Library/LaunchAgents/`
* `launchctl load -w ~/Library/LaunchAgents/org.genil.book.court.plist`
* To unload `launchctl unload -w ~/Library/LaunchAgents/org.genil.book.court.plist`

# Test & pilst lint
* To test immediately `launchctl start ~/Library/LaunchAgents/org.genil.book.court.plist`
* To make sure the plist file is free of errors, use `plutil -lint ~/Library/LaunchAgents/org.genil.book.court.plist`

# Keep the Mac awake

Mac needs to be unlocked and awake for the job to run. 
Web page https://www.igeeksblog.com/how-to-prevent-mac-from-sleeping/ has a good info. 

I have used these 2 from Terminal and left the mac un-locked. 

1. `caffeinate -d` To prevent the display from sleeping.
2. `caffeinate -t 10800` --Here 10800 is the time in seconds (3 hours).

