# Demo Room | Android

## Setup Projek
* Setting dependency
```groovy
def room_version = "2.3.0"
implementation "androidx.room:room-runtime:$room_version"
annotationProcessor "androidx.room:room-compiler:$room_version"

// optional - RxJava2 support for Room
implementation "androidx.room:room-rxjava2:$room_version"

// optional - RxJava3 support for Room
//implementation "androidx.room:room-rxjava3:$room_version"

// optional - Guava support for Room, including Optional and ListenableFuture
implementation "androidx.room:room-guava:$room_version"

// optional - Test helpers
testImplementation "androidx.room:room-testing:$room_version"

// To use Kotlin annotation processing tool (kapt)
kapt("androidx.room:room-compiler:$room_version")
```
 * Tambahkan plugin kapt untuk projek kotlin
```groovy
plugins {
    //...
    id 'kotlin-kapt'
}
```

* ViewBinding
```groovy
android {
    //...
    viewBinding {
        enabled = true
    }
}
```

## Projek
* [LiveData](projek-dasar.md)