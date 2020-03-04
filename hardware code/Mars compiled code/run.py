import time
import os 
import glob
import Adafruit_ADS1x15

os.system('modprobe w1-gpio')
os.system('modprobe w1-therm')

base_dir = '/sys/bus/w1/devices/'
device_folder = glob.glob(base_dir +'28*')[0]
device_file = device_folder + '/w1_slave'

def read_temp_raw():
    f = open(device_file,'r')
    lines = f.readlines()
    f.close()
    return lines

def read_temp():
    lines = read_temp_raw()
    while lines[0].strip()[-3:] != 'YES':
        time.sleep(0.2)
        lines = read_temp_raw()
    eqauls_pos = lines[1].find('t=')
    if eqauls_pos != -1:
        temp_string = lines[1][eqauls_pos+2:]
        temp_c = float(temp_string)/1000.0
        temp_f = temp_c * 9.0 /5.0 + 32.0
        return temp_c

adc = Adafruit_ADS1x15.ADS1115()
GAIN = 1


while True:
        v= adc.read_adc(1,gain=GAIN)
        MESSAGE = str(v)
        b= v
        print"   "
        print "Voltage snesor: ",b,"mV"
        a=adc.read_adc(0,gain=GAIN)
        MESSAGE = str(v)
        print "Current sensor: ",a,"mA"
        print"Temperature:    ",(read_temp()),"C"
        time.sleep(2);



