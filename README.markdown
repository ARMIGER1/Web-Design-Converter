
#README

## Table of Contents

1. Installation  
2. Usage  
3. Uninstallation

##1. Installation

To install, simply:

1. Unzip the folder  
2. Go into the **/dist/** folder
3. Run **Web_Design_Converter.jar**

##2. Usage

When you open the program, you'll notice that there are three (3) text entry fields and a drop-down menu.  The fields are marked:

* Base Font Size (px)  
* Desired Font Size (px)  
* Result

###2a. The "Base Font Size" Field

The "Base Font Size" field takes a numeric value, in pixels, with or without **exactly *one*** decimal place.  This value is your base font size.  In the following example, your base font size is 12px, so you would put "**12**" in this field:

```body{
font-size: 12px;
}  
body h1 {
font-size: 36px;
}
```

###2b. The "Desired Font Size" Field

The "Desired Font Size" field also takes a numeric value, in pixels with or without **exactly *one*** decimal place.  This value is the size of the font (or any dimension) that you need to convert to a more fluid unit of measure.  Building on the example from Section 2a, if you wanted to create an h2 with a font size of 24px, you would put "**24**" in this field.

##3. Uninstallation

To uninstall, simply delete the entire installation folder.
