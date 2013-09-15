import tornado.ioloop
import tornado.web
from switch import *

#Main loop
#Generates all service endpoints
#Author: Bruno Hautzenberger
if __name__ == "__main__":
    application = tornado.web.Application([
        (r"/(.*)", Switch),
    ])
    application.listen(8888) #Todo load port from a config file or so
    tornado.ioloop.IOLoop.instance().start()



