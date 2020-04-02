[android_studio_setup_avd_1]: ./img/avd_1.png "AVD setup menu: device type"
[android_studio_setup_avd_2]: ./img/avd_2.png "AVD setup menu: API type"
[android_studio_setup_usb_1]: ./img/usb_1.png "USB connected device menu"
[android_studio_setup_usb_2]: ./img/usb_2.png "USB connected device button"
[android_studio_setup_usb_3]: ./img/usb_3.png "USB connected device button"
[android_studio_setup_device_selection_1]: ./img/device_selection_1.png "Device selection"
[android_studio_setup_sdk_tools]: ./img/sdk_tools.png "SDK Tools Menu"

# CISC 365 Project

This project aims to create a prototype for an android app that provides an easy interface for first-year university students to plan time with friends and find & join activities where they could potentially meet new friends.

## Getting Started

To get this project, download or the clone the repo to your machine.  Then open with [Android Studio](https://developer.android.com/studio) to explore, modify, and test the system.

### Prerequisites

The prerequisites for exploring the code within Android Studio consists of the system requirements of [Android Studio](https://developer.android.com/studio#system-requirements-a-namerequirementsa).

To test or run the code, a compatible android emulator or device that can run API level 19: Android 4.4 (KitKat), or higher is needed.  Android Studio provides an [emulator](https://developer.android.com/studio/run/emulator) as well as a way to run the app through a [USB connected device](https://developer.android.com/studio/run/device).

### Installing

Follow the steps to install and run [Android Studio](https://developer.android.com/studio):
- Download at least Android Studio 3.5.3
- During the installation process, make sure that the "Android Virtual Device" option is checked

Download or clone this repo and place it (or a copy) within the Android Studio projects directory.  In Windows this directory is `C:\Users\name\AndroidStudioProjects`
- `git clone https://github.com/kheaslip/cisc_325_project.git`

#### Emulator
If running the app from the built-in Android Studio [emulator](https://developer.android.com/studio/run/emulator):
- Make sure that your computer supports virtualization technology.  If it does not, the later menus in the emulator device selection will provide an indicator that this is the case.  How to handle this will depend on the type of the computer.
- In Android Studio menu: Tools > AVD Manager
- Click the "Create Virtual Device" button
- For the category, select "Phone"
- You can select any phone that can run API 19+ and has Google Play Store capabilities (denoted by the Play Store logo of the triangle with two lines in it). 
For instance, select "Nexus 5"

![AVD setup menu: device type][android_studio_setup_avd_1]

- Select the "x86 Images" tab
- Select the API level 19 with the Google APIs

![AVD setup menu: API type][android_studio_setup_avd_2]

- Click next on the next window

#### USB Connected Device
If running the app from a [USB connected device](https://developer.android.com/studio/run/device):
- Make sure that the [developer options](https://developer.android.com/studio/debug/dev-options) for your device are enabled
- Enable the "USB debugging" option withi nthe developer option settings
- With the Android Studio project open, connect your device to your computer via a USB
- Unlock your device.  A popup show appear asking to "Allow USB debugging".  It will display a RSA key.  Click "Ok"
- The method of successfully connecting the device to Android Studio depends on the OS hosting Android Studio.  Follow this [guide](https://developer.android.com/studio/run/device.html) for details for your system.
- If your device name/type do not appear on the top bar of Android Studio, click "Troubleshoot Device Connections"

![USB connected device menu][android_studio_setup_usb_1]

- Then click the "Rescan devices" button

![USB connected device menu][android_studio_setup_usb_2]

- If your device is not 'authorized', follow this [post](https://stackoverflow.com/questions/23081263/adb-android-device-unauthorized) for the directions to fix this problem.

![USB unauthorized device error][android_studio_setup_usb_3]

After this point, either the virtual device or USB connected device should be available for selection in the top bar of Android Studio.


![Device selection][android_studio_setup_device_selection_1]

#### SDK Tools

This app makes use of the Google Maps APIs, and thus we need to make sure that the proper APIs are available.  In Android Studio, click on the top menu `Tools > SDK Manager`.  Within the naviagation bar, click `Appearance & Behaviour > System Settings > Android SDK`.  Click on the tab `SDK Tools`

Make sure that the Google Play: APK Expansion library, Licensing library, and services tools are selected.

![SDK Tools Menu][android_studio_setup_sdk_tools]

Select the device you wish to use and run the app.  Gradle will take a moment setting things up before the app opens.

## Running the tests

No test as of yet.

## Deployment

No details as of yet.

## Built With

Android Studio integrated [Gradle](https://gradle.org/).

## Versioning

No details as of yet.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

