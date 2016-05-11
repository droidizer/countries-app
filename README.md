# Countries Application

<img src="https://cloud.githubusercontent.com/assets/3032751/15190287/5f8064c6-17af-11e6-8f9c-39f6cb01e462.png" width="23%"></img>
<img src="https://cloud.githubusercontent.com/assets/3032751/15190286/5f7fc8ae-17af-11e6-894a-1e02bd05fccb.png" width="23%"></img>
<img src="https://cloud.githubusercontent.com/assets/3032751/15190285/5f7f8d58-17af-11e6-931b-1a94e7a7076e.png" width="23%"></img> 

## Introduction

## Table of contents

* [Introduction](#introduction)

* [How to install](#how-to-install)
	* [Gradle](#how-to-install#gradle)
	* [Adb](#how-to-install#adb)
* [How to run](#how-to-install)
	* [Gradle](#how-to-run#gradle)
	* [Adb](#how-to-run#adb)
* [How to build](#how-to-build)
	* [Gradle](#how-to-build#gradle)
	* [Adb](#how-to-build#adb)
* [Backend](#backend)
* [Contact](#contact)

# Features

1. Countries List with flags.

2. OnClick of item shows more details of the country.

Note: Checks Network connection.

## Known Issues

I recommend taking a look at missing features:

Non persistent of data.

Not tested.

Lagging coordinator scroll. Needs animation. 

Flags used are OS and not of high resolution.

## How to install

### HockeyApp

[Download build here:](https://rink.hockeyapp.net/apps/005c48f53a7b4e90912662646a9d8c68)

### Gradle

	gradle installDebug

## How to build
    
    gradle clean build 
	
## Backend

[Rest countries API](https://restcountries.eu/)

## Contributor

* [Sowmya Guru](mailto:sowmyasguru@gmail.com)

# Additional Installation Notes

1. Install Homebrew

        ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
     
2. Install Java with cask

        brew tap caskroom/versions
        brew cask install java7      
       
3. (Optional) use set jdk script in [˜/.bash_profile](https://gist.github.com/kibotu/bee00e5876a3bc134f43)                

4. Install android sdk
    
        brew install android-sdk

5. Set android home

        export ANDROID_HOME="/usr/local/opt/android-sdk"
         
6. Install android api level and extras

        android sdk 
    
7. (Bonus) updates in the future:
        
        brew update
        brew upgrade
        
8. Setup recommended [˜/gradle.properties](https://gist.github.com/kibotu/2e9601e92fac05cff72b)