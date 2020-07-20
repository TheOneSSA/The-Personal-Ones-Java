Worldwide Earthquakes and Airports Locator
=========================================

Hello everyone,

Here's a project made by me with the help of the resources provided by UC San Diego. The Processing and the UnfoldingMaps libraries have been implemented here. The program provides a GUI(map) with a bunch of interactive functions and tools that are informative as well as fun to explore.



The applet :

- Provides an interactive map( has features of zoom and pan)

- Displays the airports and the epicenter of earthquakes across the world.

- Offers 3 map choices, user can change the maps with keystroke.

- Displays the major cities across the world.

- The earthquakes can be distinguished based on it's magnitude.

- Displays different type of markers for the epicenter being in Land or Ocean.

- Have different marker for the earthquakes caused in the past hour.

- Displays the details of the major cities, marked airports and the earthquakes, when the pointer is hovered over respective markers.

- Hides all other markers across the map when one of them is selected.

- For a selected airport, displays the routes to the major cities(if any).

- For a selected earthquake marker, displays the nearby airports and major cities(if any). (The range has been decided by me, not according to any standards)

- Displays the latitude and longitude of the pointer on the map at the bottom right corner.

All the mentioned features have been implemented using the UnfoldingMaps and the Processing libraries.


INSTALLATION

Import this folder in Eclipse ('File' -> 'Import' -> 'Existing Projects into
Workspace', Select this folder, 'Finish')


MANUAL INSTALLATION

If the import does not work follow the steps below.

- Create new Java project
- Copy+Paste all files into project
- Add all lib/*.jars to build path
- Set native library location for jogl.jar. Choose appropriate folder for your OS.
- Add data/ as src


TROUBLE SHOOTING

Switch Java Compiler to 1.6 if you get VM problems. (Processing should work with Java 1.6, and 1.7)




