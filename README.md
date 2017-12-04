# OO_Project
This is our Object Oriented project.
In this project we used scans that were captured from WigleWIFI app on Android and merge them to one CSV file.
There is also an option to filter the file by time range, modle of the phone or location.

* In order to run our project, use in the main in class Filter_Your_File. You will need to change the folder directory and insert some csv files in it. 

classes in our project:

1)Filter_Your_File-
This class is the main class of our project. When you run this class you can create csv file and kml file after filtering.

2)Records-
This class contains an object of List<LineFile> and all the functions you can apply on it. (parse,writetocsv and to kml)

3)LineFile -
This class contains all the elements in the new Csv file line.
Time, Model,Location,numOfNetworks, List<Network>
*Network : contains 4 elements about the wifiNet - SSID,MAC,SIGNAL and FREQUENCY.
4)Point_2D-
 This class create Point of lat and lon.
5)Time -
  This class takes String input and convert it to object of Time.
  
**Csv2Kml function : 
In this class we create a KML file of WifiNetworks. We used in apiForKml jar files of micromata.
for the code we helped in this example code and changed it to fit our project : https://github.com/micromata/javaapiforkml/blob/master/src/test/java/de/micromata/jak/examples/Example1.java

Hope you'll find our project successful.
Bar, Noy and Doriya.
