
#include <RCSwitch.h>

RCSwitch mySwitch = RCSwitch();

char incomingByte; 

void setup() {

  Serial.begin(9600);
  
  mySwitch.enableTransmit(10);
  
}

void loop() {

  /* Numbers 1-0 Send different codes for turning switches on and off. You have to replace them with the codes of your power outlets. */
  
  if (Serial.available() > 0) {
    incomingByte = Serial.read();
    
    if(incomingByte == '1'){
      mySwitch.send(4539729, 24);
    } else if(incomingByte == '2'){
      mySwitch.send(4539732, 24);
    } else if(incomingByte == '3'){
      mySwitch.send(4542801, 24);
    } else if(incomingByte == '4'){
      mySwitch.send(4542804, 24);
    } else if(incomingByte == '5'){
      mySwitch.send(4543569, 24);
    } else if(incomingByte == '6'){
      mySwitch.send(4543572, 24);
    } else if(incomingByte == '7'){
      mySwitch.send(4543761, 24);
    } else if(incomingByte == '8'){
      mySwitch.send(4543764, 24);
    } else if(incomingByte == '9'){
      mySwitch.send(5592339, 24);
    } else if(incomingByte == '0'){
      mySwitch.send(5592348, 24);
    }
  }
}
