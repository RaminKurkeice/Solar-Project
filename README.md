# Voltage sensor for solar panel  
-------------------------------------
A voltage sensor that reads from an electrical input and outputs a series of readings that measure voltage.   

![system diagram](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/system%20diagram%20voltage.PNG "System diagram")  

The system diagram above creates a visualization of the procces of the hardware component that the steps below will create.   

## Budget    
-----------------  
The budget (See Below) is of everything you will need to create this component.   
Please keep in mind that some items on the budget you may already have such as a toolbox or saftey glasses.  
(Reminder) The prices listed below are in Dollars CAD and are subject to change at any time.  

![Budget](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/Total%20budget.PNG)   
Below are the links where I baought my supplies  

[PCB SHEETS](https://www.amazon.com/Bakelite-Phenolic-Resin-Plate-Sheet/dp/B07MZNWVGX/ref=sr_1_6?keywords=pcb+sheets&qid=1576107449&sr=8-6 "PCB Sheets")   
[ZMPT101B](https://www.amazon.com/Output-Voltage-Transformer-Arduino-ZMPT101B/dp/B07P5CQ62N/ref=sr_1_3?keywords=ZMPT101B&qid=1576108083&sr=8-3 "ZMPT101B")  
[ADS1115](https://www.adafruit.com/product/1085 "ADS1115")  
[PI KIT](https://www.amazon.com/CanaKit-Raspberry-Starter-Premium-Black/dp/B07BCC8PK7/ref=sr_1_4?crid=1O1IY45JMC416&keywords=raspberry+pi+3+kit&qid=1576108276&sprefix=raspberry+pi+3+ki%2Caps%2C160&sr=8-4 "Raspberry PI Kit")  
[CLEAR ACRYLIC](https://www.amazon.com/PP-OPOUNT-Transparent-297420mm-Protective/dp/B0819ZJNLN/ref=sr_1_2_sspa?crid=1IQN0QCJDGGTF&keywords=clear+acrylic+sheet&qid=1576108349&sprefix=clear+ac%2Caps%2C185&sr=8-2-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzUjlSSEtUNDIzS1NaJmVuY3J5cHRlZElkPUEwOTYxMjk3MVAwMFE2S09aVkk1OCZlbmNyeXB0ZWRBZElkPUEwMDIyMTE5MU1UWU01SkJVR0JMMCZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU= "Clear Acrylic")  
[TOOL KIT](https://www.amazon.ca/582-piece-Electrical-Terminal-Connector-Stripper/dp/B077YZJGQ2/ref=sr_1_1_sspa?keywords=wiring+kit+electrician&qid=1576108952&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEyVFpENTk2MlZBSE4mZW5jcnlwdGVkSWQ9QTA4ODkyODNDWVBDNTNFMFpaN1kmZW5jcnlwdGVkQWRJZD1BMDU0NDA3NzNNQTFDMFBQRFBQQ0Emd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl "Tool Kit")  
[SAFETY GLASSES](https://www.amazon.ca/Jackson-Safety-25650-Glasses-Temples/dp/B00982Y1QA/ref=sr_1_1_sspa?crid=19M8N696QNW8T&keywords=saftey+glases&qid=1576109002&sprefix=safte%2Caps%2C170&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUFJVVAwME1KMTRKTjcmZW5jcnlwdGVkSWQ9QTAwMjc2NDFUS0JLMjU3SlRNSU4mZW5jcnlwdGVkQWRJZD1BMDEyNjgwODJCNjA1SVFIMEJSWVEmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl "Safety Glasses")  
[WIRES](https://www.amazon.ca/Elegoo-120pcs-Multicolored-Breadboard-arduino/dp/B01EV70C78/ref=sr_1_1_sspa?keywords=male+to+female+wires+kit&qid=1576109048&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEySVVCSUFOS0E2T05KJmVuY3J5cHRlZElkPUEwMzQzMzAxR1NKNThXUjZaVURNJmVuY3J5cHRlZEFkSWQ9QTAzODU4ODIxTDFFMkFETTNHV0hYJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ== "Male to Female Wires")  
[PCB SOCKETS](https://www.amazon.ca/Glarks-Connector-Assortment-Stackable-Breakaway/dp/B07CWSXY7P/ref=sr_1_6?keywords=pcb+sockets+kit&qid=1576109072&sr=8-6 "PCB sockets")  
Also if you do not have access to solder equipment i will also add it below (this is not included in the budget).  
[SOLDER KIT](https://www.amazon.ca/Holife-Adjustable-Temperature-Controlled-Interchangeable/dp/B06XCZC4PF/ref=sr_1_1_sspa?crid=PMQVRIW0ML9N&keywords=soldering+iron+kit&qid=1576109105&smid=A1AWXNIDJ2RJ0G&sprefix=solder%2Caps%2C171&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExRUxLQ09YNlgzMVVRJmVuY3J5cHRlZElkPUEwNjY4MDQ2NzBSNklGWVcwMkJXJmVuY3J5cHRlZEFkSWQ9QTA1NjkzODUxUzUyNzk5MjQ2OTUyJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ== "Solder kit")  

## Time Commitment  
------------------------

Buying and receiving supplies: may vary by shipping.  
Setup: 4hrs
Mechanical Assembly: 2hrs 45mins  
PCB soldering: 1hr 30mins  
Power Up and Unit Testing: 2hr 40mins    

Total time    
------------   
10hrs 55mins    

## Mechanical Assembly   
---------------------------
// how to build it step by step with pictures 

### Set Up  
---------------

First we must start up your Raspberry pi so it can boot up. The link below has a tutorial on how to boot your pi with raspberian.  
[SETUP ONE](https://www.raspberrypi.org/help/noobs-setup/2/ "NOOBS SET UP TUTORIAL")  
Once completed we will then start with breadboard wiring of the circuit for testing.  
It should look like this:  
![diagram](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/sensors_raspi_ads1015_i2c_bb.png)
Now lets boot the pi up and start setting up the converter below is a link with step by step tutorial on how to set up your pi sensor
[SETUP TWO](https://learn.adafruit.com/raspberry-pi-analog-to-digital-converters/ads1015-slash-ads1115?gclid=Cj0KCQiAoIPvBRDgARIsAHsCw0_tIp48W2VIJlxb1GdicDLEE7z6YJER2t0mT5Jb6SKeqTfT13KJHiAaAjbbEALw_wcB "I2C SET UP TUTORIAL")  
Once that is completed we should start testing the wiring with a power supply send power through the wires that are connnected to the front of the ZMPT101B voltage sensor and see if the readings start to change on the screen.  

### wiring diagram   
-------------------  
follow the wiring diagram below:  
![wiring diagram](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/wiring%20diagarm.PNG "Wiring diagram")   
It should look something like this:  
// picture of breadboard 
Once that is completed we should start testing the wiring with a power supply send power through the wires that are connnected to the front of the ZMPT101B voltage sensor and see if the readings start to change on the screen.  
 
### Enclosure  
--------------    
Now lets created an enclosure for our raspberry pi so it can be protected along with the sensor.  
Below is a link to download my pdf files so you can laser cut the project.    
[ENCLOSURE](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/Ramin_PI_Case_V4.pdf "Case")  
you will need to load as a pdf and go to cooreldraw to laser cut.  
Here is a tutorial.  
[laser VIDEO](https://www.youtube.com/watch?v=XnnYHtXXO30 "laser cutting VIDEO")   
Once you got the acrylic peices you will now see that they fit together like a puzzle and the final product should look like this.  
![Pi cut](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/picasepieces.png)   
and they fit like this.  
![Pi case](https://github.com/RaminKurkeice/Solar-Project/blob/master/images/picaseside.png)   

## PCB / Soldering  
-------------------
Now we will start to print our own PCB here below is the link to my github where you can get my Fritzing file of the PCB and get it printed.  
[FRITZING](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/RaminPcbV1.fzz "Fritzing file")   
Now lets start soldering if you have never soldered before please watch this video below before starting.  
[SOLDERING VIDEO](https://www.youtube.com/watch?v=AqvHogekDI4 "SOLDERING VIDEO")  
lets start soldering.  
First solder by adding a 10k pot and a 1k resistor into your pcb and Start placing wires into the holes in the picture below.  
![STEP 1](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/solder%20steps/step%200%20solder.PNG)  
Then solder the other side of the PCB highlighted below.  
![STEP 2](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/solder%20steps/step%201%20solder.PNG)  
Now add a 4 and 10 pin sockets into the highlighted areas and solder them just like the picture below.  
![STEP 3](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/solder%20steps/step%202%20solder.PNG)  
Finally aff a 6 pin socket and solder in place just like the picture below.  
![STEP 4](https://github.com/RaminKurkeice/Solar-Project/blob/master/documentation/solder%20steps/step%203%20solder.PNG)  

## Power Up  
---------------  
Now before powering it up we must check for shorts on the PCB linked below is a video explaining how to find a short into a PCB.  
[SHORT VIDEO](https://www.youtube.com/watch?time_continue=271&v=AmN5-ZSKgXY&feature=emb_logo)   
Now understanding that lets look for shorts by testing from the wirinf diagram above and see if there is going to be an overload on our test when we connect VCC to GROUND ports in our PCB.
If there are no shorts we will continue to the power up by now putting power from the power suppy onto the PCB of the pi and see if it reads on the display.  

## Unit Testing  
-------------------
A short little test to see if the software is working properly.    
First start the test from your readings display and have the power suppy a 2v output.    
Secondly we will decrease the voltage slightly and see if the readings start to change if the numbers start to decrease aswell then we are on the right track.  
Finally lets slowly increase the voltage to 3v and see if the readings start to increase.  
Now with that said and done we have a working voltage sensor.  
## Production Testing  
------------------------  
If you were to tests a thousand of these a great ways is have during factory soldering to also add short checks in the manufacturing process then every 5 PCBs created test the readings from the sensors to see if there is no damage to them.  
