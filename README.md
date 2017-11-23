# OO_Project
This is our Object Oriented project.
In this project we used scans that were captured from WigleWIFI app on Android, merge them to one CSV file.
There is also an option to filtter the WIFI networks by time, modle of the phon or location.

* In order to run our project, use in the main in class ParseFile. You will need to change the folder directory and insert some csv files in it. If you want to filter the list you created, you can change the filter's condition as you like. When you will run this class, the new merge csv file and the filtered one will be created.
* In order to create KML file, you will need to move to the main in class Csv2Kml.You need to change the folder directory. When tou will run this class, a KML file of your filtered file will be created. (if you like, you can create new file with another condition).

we created several classes during the process.
Folder:
This class allow you to read folder with several files and with CSV_Files function to add only the CSV files in this folder to Array of strings.

ReadFile: 
This class reads the CSV files to list of strings.

ParsingFile:
This class creates a new parse CSV file base on wifiNetworks that was captured on specific time.
In the main you can enter the condition for filtering the list as you like.
- parse_File function takes CSV file and arranged it to the wanted result.
- merge_Files function merge all the new files into one file.

WriteCsv :
This class writes the List of WifiNetworks to csv file.

FileFilter : 
This class uses a filter implement for filtering the list of Wifi objects as you like.

LineFile :
This class contains all the elements in the new Csv file line.
Time, Model,Location,numOfNetworks, List<Network>
*Network : contains 4 elements about the wifiNet - SSID,MAC,SIGNAL and FREQUENCY.

Csv2Kml : 
In this class we create a KML file of WifiNetworks. We used in apiForKml jar files of micromata.
for the code we helped in this example code and changed it to fit our project : https://github.com/micromata/javaapiforkml/blob/master/src/test/java/de/micromata/jak/examples/Example1.java

Hope you'll find our project successful.
Bar, Noy and Doriya.
