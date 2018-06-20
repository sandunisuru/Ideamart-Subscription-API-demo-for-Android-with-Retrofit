![ideamart](http://i67.tinypic.com/f9evr.png)

# Ideamart Subscription API demo for Android with Retrofit

This is a demonstration to show how to implement Ideamart Subscription API with Android with using Retrofit HTTP Library.

Only Tested with __Ideamart Emulator 2.0__.

### If you need to test it with working condition change the value 

````java
    public static final String BASE_URL = "http://10.0.2.2:7000/subscription/";
````
to this
````java
    public static final String BASE_URL = "https://api.dialog.lk/subscription/";
````
in API>>APIUrl.java file

### Used Libraries
Retrofit 2 > ````implementation 'com.squareup.retrofit2:retrofit:2.2.0'````

GSON Library > ````implementation 'com.squareup.retrofit2:converter-gson:2.2.0' ````


Not tested in Real Environment.
