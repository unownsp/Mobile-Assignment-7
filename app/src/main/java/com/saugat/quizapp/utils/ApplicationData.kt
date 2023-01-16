package com.saugat.quizapp.utils

import com.saugat.quizapp.pojo.Question

class ApplicationData {

    companion object {
        fun getQuizQuestions(): MutableList<Question> {
            return mutableListOf(
                Question(
                    1,
                    "Android is _____",
                    "Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.",
                    "a",
                    "an operating system",
                    "",
                    "",
                    mutableListOf(
                        "an operating system",
                        "a web browser",
                        "a web server",
                        "None of the above"
                    )
                ),
                Question(
                    2,
                    "Under which of the following Android is licensed?",
                    "The Android platform was released under the Apache 2.0 license, and it is responsible for the copyright of the Android Open Source project.",
                    "c",
                    "Apache/MIT",
                    "",
                    "",
                    mutableListOf("OSS", "Sourceforge", "Apache/MIT", "None of the above")
                ),
                Question(
                    3,
                    "For which of the following Android is mainly developed?",
                    "Android is a software package and a Linux-based operating system specially designed for touch-screen mobile devices like smartphones and tablets.",
                    "d",
                    "Mobile devices",
                    "",
                    "",
                    mutableListOf("Servers", "Desktops", "Laptops", "Mobile devices")
                ),
                Question(
                    4,
                    "Which of the following virtual machine is used by the Android operating system?",
                    "The Dalvik Virtual Machine (DVM) is an android virtual machine optimized for mobile devices. It optimizes the virtual machine for memory, battery life, and performance.",
                    "b",
                    "Dalvik virtual machine",
                    "",
                    "",
                    mutableListOf(
                        "JVM",
                        "Dalvik virtual machine",
                        "Simple virtual machine",
                        "None of the above"
                    )
                ),
                Question(
                    5,
                    "Android is based on which of the following language?",
                    "Java language is mainly used to write the android code even though other languages can be used.",
                    "a",
                    "Java",
                    "",
                    "",
                    mutableListOf("Java", "C++", "Python", "C")
                ),
                Question(
                    6,
                    "APK stands for _____",
                    "An APK is a short form of the Android Package Kit. An APK file is the file format used to install the applications on the android operating system.",
                    "c",
                    "Android Package Kit",
                    "",
                    "",
                    mutableListOf("Android Phone Kit", "Android Page Kit", "Android Package Kit")
                ),
                Question(
                    7,
                    "What does API stand for?",
                    "API stands for application program interface. It is a set of routines, protocols, and tools for building software and applications.",
                    "a",
                    "Application Programming Interface",
                    "",
                    "",
                    mutableListOf(
                        "Application Programming Interface",
                        "Android Programming Interface",
                        "Android Page Interface",
                        "Application Page Interface"
                    )
                ),
                Question(
                    8,
                    "How can we kill an activity in android?",
                    "The finish() method is used to close the activity. Whereas the finishActivity(int requestCode) also closes the activity with requestCode.",
                    "ab",
                    "Using finish() method\nUsing finishActivity(int requestCode)",
                    "",
                    "",
                    mutableListOf(
                        "Using finish() method",
                        "Using finishActivity(int requestCode)",
                        "Neither (a) nor (b)"
                    )
                ),
                Question(
                    9,
                    "On which of the following, developers can test the application, during developing the android applications?",
                    "We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.",
                    "abc",
                    "Third-party emulators\nEmulator included in Android SDK\nPhysical android phone",
                    "",
                    "",
                    mutableListOf(
                        "Third-party emulators",
                        "Emulator included in Android SDK",
                        "Physical android phone"
                    )
                ),
                Question(
                    10,
                    "Which of the following is not an activity lifecycle callback method?",
                    "onBackPressed() method is not an activity lifecycle callback method",
                    "d",
                    "onBackPressed() method",
                    "",
                    "",
                    mutableListOf(
                        "onClick() method",
                        "onCreate() method",
                        "onStart() method",
                        "onBackPressed() method"
                    )
                ),
                Question(
                    11,
                    "Which of the following is a dialog class in android?",
                    "All of the above are Dialog classes",
                    "abc",
                    "AlertDialog\nDatePicker Dialog\nProgressDialog",
                    "",
                    "",
                    mutableListOf("AlertDialog", "DatePicker Dialog", "ProgressDialog")
                ),
                Question(
                    12,
                    "Which of the following android component displays the part of an activity on screen?",
                    "Android Fragment is the part of activity; it is also known as sub-activity. There can be more than one fragment in an activity. Fragments represent multiple screens inside one activity.",
                    "d",
                    "Fragment",
                    "",
                    "",
                    mutableListOf("View", "Manifest", "Gradle", "Fragment")
                ),
                Question(
                    13,
                    "Which of the following is the parent class of Activity?",
                    "The android Activity is the subclass of ContextThemeWrapper class. Android Activity Lifecycle is controlled by 7 methods of android.app.Activity class. An activity is a single screen in android. It is like a window or frame of Java.",
                    "c",
                    "contextThemeWrapper",
                    "",
                    "",
                    mutableListOf("context", "object", "contextThemeWrapper", "None of the above")
                ),
                Question(
                    14,
                    "Which of the following features are updated in Android 4.1(Jelly Bean)?",
                    "Android 4.1(Jelly Bean) updates to following features: smoother user interface, enhance accessibility, expandable notification, fixed bug on Nexus 7, one-finger gestures to expand/collapse notifications, lock screen improvement, multiple user accounts (tablets only), new clock application, Bluetooth low energy support, volume for incoming call, 4K resolution support, native emoji support, bug fixes for the Nexus 7 LTE.",
                    "abc",
                    "User Interface\nLock screen improvement\nNew clock application",
                    "",
                    "",
                    mutableListOf(
                        "User Interface",
                        "Lock screen improvement",
                        "New clock application"
                    )
                ),
                Question(
                    15,
                    "Which of the following method is used by services to clean up any services?",
                    "The onDestroy() method can be used by services to clean up any resources like receivers, threads, registered listeners, etc.",
                    "c",
                    "onDestroy() method",
                    "",
                    "",
                    mutableListOf(
                        "onStop() method",
                        "stopService() method",
                        "onDestroy() method",
                        "stopSelf() method"
                    )
                )
            )
        }
    }
}