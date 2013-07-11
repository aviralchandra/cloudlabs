#!/usr/bin/python -tt

#import serial

#ser = serial.Serial('/dev/ttyUSB0', baudrate=9600, timeout=1)
#ser.open()

from sbhs import *
from bottle import *
from scan_machines import *


connect()
connect_device()

@route('/hello')
def hello():
    return "Hello World!"

run(host='localhost', port=8080, debug=True)






