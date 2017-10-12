cordova-plugin-statusbar
============================
 
Enable or disable Android 4.4's translucent statusbar.

Plugin for Cordova >= 3.0

#### Installation

For Cordova:

	git clone https://github.com/ran-j/cordova-plugin-statusbar

#### Then

 Edit config.xml with: <plugin name="cordova-plugin-statusbar-master" spec="^2.2.3" />


#### Using the plugin
To enable translucent statusbar:

	statusbarTransparent.enable();
	
To disable translucent statusbar:

	statusbarTransparent.disable();
	
To toggle current state:

	statusbarTransparent.toggle(); 
