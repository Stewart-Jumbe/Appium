# Appium


## Setup
- Install Android Studio
- Install Node JS

Add New Environment Variables:

- ANDROID_HOME with path(without quotes): C:\Users\"username"\AppData\Local\Android\Sdk

- NODE_HOME with path:
C:\Program Files\nodejs

Add to PATH:
The following have to be added to path

- %ANDROID_HOME%\tools
- %ANDROID_HOME%\tools\bin
- %ANDROID_HOME%\platform-tools
- %NODE_HOME%\npm\bin



## Installing Appium
1. Start up a CMD window
2.enter npm install -g appium or npm install --location=global appium@next
3.Check its installed by starting appium. in CMD type: appium

## Installing Appium drivers

4. You need to install a driver to perform automation in Android.Still in CMD type: appium driver install uiautomator2


## Installing Appium Inspector
5. Download and install appium instector
6. Open Appium inspector and enter the following setting:
 - Remote host : 127.0.0.1
 - Remote port : 4723
 - app : location in the resources folder of the apk e.g C:\Users\stewart.jumbe\Documents\Software Development\JAVA\Appium\src\test\java\resources\ApiDemos-debug.apk
 - platformName : android
 - deviceName : whatever you named the device when created in android studio e.g Pixel_4_XL_API_31
 - automationName : UIautomator2

7. Start appium in CMD and Start the session in Appium Inspector
