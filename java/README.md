Java Node Using Jinterface
==========================

So far we've got two solutions for pinging an erlang node.

1. Compiled Ping class
2. Groovy pinging script

Jinterface documentations: http://erlang.org/doc/apps/jinterface/

Building
--------

The Java JDK must be installed and on the class path.
http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html

Once the JDK is installed the project can be built by running 
    gradlew build 
If gradle is not installed, this will create a .gradle folder in your home directory and install gradle there. To see other build tasks run 
    gradle tasks

On windows, substitute gradlew.bat for gradle.

Running
-------

The compiled class can be run using the following command
    gradle run -Prnode=remote@host -Plnode=localNodeName -Ptrace=4
Enter the name of the remote erlang node in -Prnode. -Plnode and -Ptrace are optional are refer to the java node's name and the JInterface logging level respectively.

The script can be executed by launching the grovvy console with the following command
	gradle console
Once the console launches, edit the rnode variable and, from the menu, select Script > Run
This will log out the name of the java node and then attempt to ping the remote node.
