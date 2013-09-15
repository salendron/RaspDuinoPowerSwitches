import tornado.web
import serial

arduino = serial.Serial('/dev/ttyACM0', 9600)
         
class Switch(tornado.web.RequestHandler):
    def get(self, command):

	ret = "OK"

	try:
		arduino.write(command)
        except Exception, err:
		ret = str(err)
            
        self.write(ret)
