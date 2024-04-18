# Data Notification Blocker for Samsung

## Introduction
This application serves as a quick fix for Samsung devices to prevent annoying notifications every time you disable your data.(I faced this when I switched from my lovely google Pixel phone to Samsung)
It is completely safe, and the code is straightforward and easy to inspect in the `app/src` folders. The app automatically runs every time you boot the system.

## Features
- **Automatic Execution**: Automatically starts and monitors notifications upon system boot.
- **Safety**: The code is simple and transparent, making it easy to verify for safety and functionality.
- **Efficiency**: Efficiently cancels specific notifications without affecting others.

## How it Works
The app listens for notifications from a specific Samsung system app and cancels them if they match predefined criteria, such as the notification channel used for data alerts.

## Installation and Usage
There are two ways to install this app:
1. **Download the APK**: Download the repository and install the APK on your device. (Release section)
2. **Build the APK**: In case you are a developer and want to build the APK yourself, you can clone the repository and build the APK using Android Studio.

## Permissions
- **Notification Access**: Required to monitor and manage notifications from other apps.

## Contributions
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.
