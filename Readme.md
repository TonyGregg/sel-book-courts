To run
mvn package
java -jar <directory>/target/sel-book-courts-1.0.jar


On Mac to schedule the job

Copy the resources/org.genil.book.court.plist to ~/Library/LaunchAgents
From terminal type
launchctl load -w ~/Library/LaunchAgents/org.genil.book.court.plist

