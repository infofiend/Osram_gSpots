/**
 *  Osram LIGHTIFY GardenSpot Mini rgb - AAP Version 
 *
 *  Version 1.1 - fixed on/off from tile
 *
 *  - For use with directly connecting the US (Z HA) versions to SmartThings
 *  
 *  - Without the Osram Gateway, the color loop functionality does not work for the US version of the GardenSpots (at 
 *    least until they update the firmware).  But using the "hueLoop" and "hueRandom" attributes
 *    of this DTH, one create a CoRE Piston to cause color loop (even random colors)
 *
 *  - Device Tile contains sliders for individual control of hue, saturation, and transition time.
 *
 *	- Device Tile also contains buttons for (1) "hueLoop" (boolean "on" / "off" values) and  
 *     (2) "Random Hue" (causes hue to change to a random color).  Use these in CoRE to create color loop.
 *
 *  Copyright 2016 Anthony Pastor
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

metadata {
	// Automatically generated. Make future change here.
	definition (name: "Osram GardenSpot Mini rgb - aap version", namespace: "info_fiend", author: "anthony pastor") {
		capability "Switch Level"
		capability "Actuator"
		capability "Color Control"
        capability "Color Temperature"
		capability "Switch"
		capability "Configuration"
		capability "Polling"
		capability "Refresh"
		capability "Sensor"
       
        command "setAdjustedColor"
        command "setLoopTime"
		command "setHueLoop"
        command "setRandomHue"
        command "setTransitionTime"
        command "toggle"
        
        // This is a new temporary counter to keep track of no responses
    
        attribute "colorMode", "string"
        attribute "colorName", "string"
        attribute "switchColor", "string"
        attribute "loopTime", "number"
        attribute "level", "number"
        attribute "hue", "number"
        attribute "hueLoop", "string"	
        attribute "saturation", "number"
        attribute "hueRandom", "number"	
        attribute "transitionTime", "number"
        attribute "sliderTT", "number"	

		fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "Gardenspot RGB"
	fingerprint profileId: "0104", inClusters: "0000,0003,0004,0005,0006,0008,0300,0B04,FC0F", outClusters: "0019", manufacturer: "OSRAM", model: "LIGHTIFY Gardenspot RGB"
	}

	// simulator metadata
	simulator {
		// status messages
		status "on": "on/off: 1"
		status "off": "on/off: 0"

		// reply messages
		reply "zcl on-off on": "on/off: 1"
		reply "zcl on-off off": "on/off: 0"
	}

	// UI tile definitions
	tiles (scale: 2){
		multiAttributeTile(name: "switch", type: "lighting", width: 6, height: 4, canChangeIcon: true) {
        	tileAttribute("device.switchColor", key: "PRIMARY_CONTROL") {
				attributeState "off", label: '${currentValue}', action: "on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
            	attributeState "Red", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff0000"
            	attributeState "Brick Red", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff3700"
    			attributeState "Safety Orange", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff6F00"
    			attributeState "Dark Orange", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff9900"
            	attributeState "Amber", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ffbf00"
            	attributeState "Gold", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ffe1000"
            	attributeState "Yellow", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ffff00"
    			attributeState "Electric Lime", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#bfff00"
            	attributeState "Lawn Green", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#88ff00"
            	attributeState "Bright Green", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#48ff00"
            	attributeState "Lime", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00ff11"
            	attributeState "Spring Green", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00ff6a"
            	attributeState "Turquoise", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00ffd0"
            	attributeState "Aqua", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00ffff"
            	attributeState "Sky Blue", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00bfff"
            	attributeState "Dodger Blue", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#007bff"
            	attributeState "Navy Blue", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#0050ff"
            	attributeState "Blue", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#0000ff"
            	attributeState "Han Purple", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#3b00ff"
            	attributeState "Electric Indigo", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#6600ff"
            	attributeState "Electric Purple", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#b200ff"
            	attributeState "Orchid Purple", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#e900ff"
            	attributeState "Magenta", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff00dc"
            	attributeState "Hot Pink", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff00aa"
            	attributeState "Deep Pink", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff007b"
            	attributeState "Raspberry", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff0061"
            	attributeState "Crimson", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#ff003b"
            	attributeState "White", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
                attributeState "Color Loop", label: '${currentValue}', action: "off", icon: "st.switches.switch.on", backgroundColor: "#79b821"
			}
            tileAttribute ("device.color", key: "COLOR_CONTROL") {
            	attributeState "color", action: "setAdjustedColor"
            }
            tileAttribute ("device.colorName", key: "SECONDARY_CONTROL") {
            	attributeState "colorName", label: 'Color is ${currentValue}'
            }
        }
        standardTile("refresh", "device.switch", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		controlTile("levelSliderControl", "device.level", "slider", height: 1, width: 4, inactiveLabel: false) {
			state "level", action:"switch level.setLevel"
		}
        valueTile("level", "device.level", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "level", label: 'Level: ${currentValue}'
        }  
        controlTile("hueSliderControl", "device.hue", "slider", height: 1, width: 4, inactiveLabel: false) {
			state "hue", action:"setHue"
		}
        valueTile("hue", "device.hue", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "hue", label: 'Hue: ${currentValue}'
        }    
        standardTile("hueLoop", "device.hueLoop", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
        	state "on", label: 'Hue Loop On', action: "setHueLoop", backgroundColor: "#ab1552", nextState: "off"
			state "off", label:'Hue Loop Off', action: "setHueLoop", backgroundColor: "#ffffff", nextState: "on"
        }
        standardTile("hueRandom", "device.hueRandom", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
        	state "hueRandom", label: 'Random Hue', action: "setRandomHue"
        }
		controlTile("satSliderControl", "device.saturation", "slider", height: 1, width: 4, inactiveLabel: false) {
			state "saturation", action:"setSaturation"
		}
        valueTile("saturation", "device.saturation", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "saturation", label: 'Sat: ${currentValue}'
        }
        controlTile("colorTempSliderControl", "device.colorTemperature", "slider", height: 1, width: 4, inactiveLabel: false, range:"(2000..6500)") {
            state "colorTemperature", action:"color temperature.setColorTemperature"
        }
        valueTile("colorTemp", "device.colorTemperature", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorTemperature", label: '${currentValue} K'
        }
        controlTile("transTimeSliderControl", "device.sliderTT", "slider", height: 1, width: 3, inactiveLabel: false, range: "1..100") {
			state "sliderTT", action:"setTransitionTime"
		}
		valueTile("transitionTime", "device.transitionTime", height: 1, width: 3, inactiveLabel: false, decoration: "flat") {
            state "transitionTime", label: 'Transitions: ${currentValue} secs'
        }
        valueTile("colorName", "device.colorName", height: 1, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorName", label: '${currentValue}'
        }
        valueTile("colorMode", "device.colorMode", height: 2, width: 2, inactiveLabel: false, decoration: "flat") {
            state "colorMode", label: '${currentValue}'
        }
         controlTile("loopTimeSlider", "device.sliderLT", "slider", height: 1, width: 3, inactiveLabel: false, range: "1..60") {
			state "sliderLT", action:"setLoopTime"
		}
		valueTile("loopTime", "device.loopTime", height: 1, width: 3, inactiveLabel: false, decoration: "flat") {
            state "loopTime", label: 'LoopTime: ${currentValue} Mins'
        }    
		main(["switch"])
		details(["switch", "levelSliderControl", "level", "hueSliderControl", "hue", "satSliderControl", "saturation", "transTimeSliderControl", "transitionTime", "hueLoop", "hueRandom","refresh"])	//"loopTimeSlider", "loopTime",
	}
}

// Parse incoming device messages to generate events
def parse(String description) {
   log.info "description is $description"
    

    if (device.currentValue("loopActive") == "Active") { 
    }
    else {
    if (description?.startsWith("catchall:")) {
        if(description?.endsWith("0100") ||description?.endsWith("1001") || description?.matches("on/off\\s*:\\s*1"))
        {
            def result = createEvent(name: "switch", value: "on")
            sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false)
            log.debug "Parse returned ${result?.descriptionText}"
            return result
        }
        else if(description?.endsWith("0000") || description?.endsWith("1000") || description?.matches("on/off\\s*:\\s*0"))
        {
            if(!(description?.startsWith("catchall: 0104 0300") || description?.startsWith("catchall: 0104 0008"))){
                def result = createEvent(name: "switch", value: "off")
                sendEvent(name: "switchColor", value: "off", displayed: false)
                log.debug "Parse returned ${result?.descriptionText}"
                return result
            }
        }
    }
    else if (description?.startsWith("read attr -")) {
        def descMap = parseDescriptionAsMap(description)


        if (descMap.cluster == "0300") {
            if(descMap.attrId == "0000"){  //Hue Attribute
                def hueValue = Math.round(convertHexToInt(descMap.value) / 255 * 100)
                log.debug "Hue value returned is $hueValue"
                def colorName = getColorName(hueValue)
    			sendEvent(name: "colorName", value: colorName, isStateChange: true)
                if (device.currentValue("switch") == "on") { sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false) }
                sendEvent(name: "hue", value: hueValue, displayed:false)
            }
            else if(descMap.attrId == "0001"){ //Saturation Attribute
                def saturationValue = Math.round(convertHexToInt(descMap.value) / 255 * 100)
                log.debug "Saturation from refresh is $saturationValue"
                sendEvent(name: "saturation", value: saturationValue, displayed:false)
            }
            else if( descMap.attrId == "0007") {
                def tempInMired = convertHexToInt(descMap.value)
            	def tempInKelvin = Math.round(1000000/tempInMired)
                log.debug "Color temperature returned is $tempInKelvin"
            	sendEvent(name: "colorTemperature", value: tempInKelvin, isStateChange: true)
            }
            else if( descMap.attrId == "0008") {
            	def colorModeValue = (descMap.value == "02" ? "White" : "Color")
                log.debug "Color mode returned $colorModeValue"
                sendEvent(name: "colorMode", value: colorModeValue, isStateChange: true)
                if (device.currentValue("switch") == "on") {
                	sendEvent(name: "switchColor", value: (descMap.value == "02" ? "White" : device.currentValue("colorName")), displayed: false, isStateChange: true)
                }
            }
        }
        else if(descMap.cluster == "0008"){
            def dimmerValue = Math.round(convertHexToInt(descMap.value) * 100 / 255)
            log.debug "dimmer value is $dimmerValue"
            sendEvent(name: "level", value: dimmerValue, isStateChange: true)
        }
    }
    else {
        def name = description?.startsWith("on/off: ") ? "switch" : null
        def value = null
        if (name == "switch") {
            value = (description?.endsWith(" 1") ? "on" : "off")
        	log.debug value
            sendEvent(name: "switchColor", value: (value == "off" ? "off" : device.currentValue("colorName")), displayed: false, isStateChange: true)
        }
        else { value = null }
        def result = createEvent(name: name, value: value)
        log.debug "Parse returned ${result?.descriptionText}"
        return result
    }
	}
}

def parseDescriptionAsMap(description) {
    (description - "read attr - ").split(",").inject([:]) { map, param ->
        def nameAndValue = param.split(":")
        map += [(nameAndValue[0].trim()):nameAndValue[1].trim()]
    }
}

def on() {
	log.debug "on()"   
	def level = state.level ?: 100
    setLevel(level)
}

def off() {

	log.debug "off()"
    state.level = this.device.currentValue("level") ?: 100
	zigbee.command(0x0006, 0x00)

}

def toggle() {
	if (device.currentValue("switch") == "on") {
		setLevel(0)
		sendEvent(name: "switch", value: "off")
		sendEvent(name: "switchColor", value: "off", displayed: false, isStateChange: true)
	}
	else {
		def level = this.device.currentValue("level") ?: 100    
		setLevel(level)
        sendEvent(name: "switch", value: "on")
		sendEvent(name: "switchColor", value: ( device.currentValue("colorMode") == "White" ? "White" : device.currentValue("colorName")), displayed: false, isStateChange: true)
	}

}


def setHueLoop() {
    log.trace "setHueLoop()"
	if (device.currentValue("hueLoop") == "off") {
//		def loopT = device.currentValue("loopTime") ?: 5
		sendEvent(name: "hueLoop", value: "on", displayed:true, isStateChange: true)
		log.trace "hueLoop is now ON."	// - randomize every ${loopT} minutes."
        
//        unschedule
//        runIn(loopT*60, setRandomHue)
        
	} else {
    	log.trace "hueLoop is now OFF."    
		sendEvent(name: "hueLoop", value: "off", displayed:true, isStateChange: true)	
//		unschedule
    }
}

def setLoopTime(loopT) {
	log.trace "loopTime(${loopT}) minutes."
    sendEvent(name: "loopTime", value: loopT, displayed:true, isStateChange: true)    
    sendEvent(name: "sliderLT", value: loopT, displayed:true, isStateChange: true)        
    if (device.currentValue("hueLoop") == "on") {
    	log.trace "Adjusting existing hueLoop."
        unschedule
        runIn(loopT*60, setRandomHue)
	}
}



def setTransitionTime(inTime) {
	def transitionTime = ( inTime / 10 )
	log.trace "transitionTime = ${transitionTime} seconds."
    sendEvent(name: "sliderTT", value: inTime, displayed:false)
    sendEvent(name: "transitionTime", value: transitionTime, displayed:true, inStateChange: true)
}

def setHue(hue) {
	log.trace "setHue($hue)"
	def sat = this.device.currentValue("saturation") ?: 100
    def level = this.device.currentValue("level") ?: 100
	setColor([level:level, saturation:sat, hue:hue, switch:"on"])
}

def setRandomHue() {
	def rHue = new Random().nextInt(100) + 1
	log.trace "Random hue is ${rHue}."
    
	def sat = this.device.currentValue("saturation") ?: 100
    def level = this.device.currentValue("level") ?: 100

	setColor([level:level, saturation:sat, hue:rHue, switch:"on"])

}

def setSaturation(sat) {
	log.trace "setSaturation($sat)"
    def hue = this.device.currentValue("hue") ?: 70
    def level = this.device.currentValue("level") ?: 100
	setColor([level:level, saturation:sat, hue:hue, switch:"on"])
}
def setLevel(value) {
	log.trace "setLevel($value)"
	def duration = (this.device.currentValue("transitionTime") * 10) ?: 32
    state.levelValue = (value==null) ? 100 : value
	def transitionTime = swapEndianHex(hexF(duration,4))    
    def cmds = []

    if (value == 0) {
        sendEvent(name: "switch", value: "off", isStateChange: true)
        cmds << "st cmd 0x${device.deviceNetworkId} ${endpointId} 6 0 {}"
        cmds << "delay 150"
    } else if (device.latestValue("switch") == "off") {
        sendEvent(name: "switch", value: "on", isStateChange: true)
		cmds << "st cmd 0x${device.deviceNetworkId} ${endpointId} 6 1 {}"
		cmds << "delay 150"
    }


    sendEvent(name: "level", value: state.level, isStateChange: true)
    def scaledLevel = hex(state.levelValue * 255 / 100)
    cmds <<  "st cmd 0x${device.deviceNetworkId} ${endpointId} 8 4 {${scaledLevel} ${transitionTime}}"

    //log.debug cmds
    cmds
}

def setAdjustedColor(value) {
   // log.debug "setAdjustedColor: ${value}"
	def adjusted = value + [:]
	adjusted.level = null // needed because color picker always sends 100
	setColor(adjusted)
}

def setColor(value){
    log.trace "setColor($value)"

	def duration = (this.device.currentValue("transitionTime") * 10) ?: 32
    log.trace "transition time = ${duration / 10} seconds."
    
    def transitionTime = swapEndianHex(hexF(duration,4))
   
    def max = 0xfe
	if (value.hue == 0 && value.saturation == 0) { setColorTemperature(3500) }
    else if (value.red == 255 && value.blue == 185 && value.green == 255) { setColorTemperature(2700) }
    else {
    if (value.hex) { sendEvent(name: "color", value: value.hex, displayed:false)}

    def colorName = getColorName(value.hue)
    sendEvent(name: "colorName", value: colorName)
    sendEvent(name: "colorMode", value: "Color")
    sendEvent(name: "switchColor", value: device.currentValue("colorName"), displayed: false, isStateChange: true)

    log.debug "color name is : $colorName"
    sendEvent(name: "hue", value: value.hue, displayed:true)
    sendEvent(name: "saturation", value: value.saturation, displayed:true, isStateChange: true)
    def scaledHueValue = evenHex(Math.round(value.hue * max / 100.0))
    def scaledSatValue = evenHex(Math.round(value.saturation * max / 100.0))

    def cmd = []
    if (value.switch != "off" && device.latestValue("switch") == "off") {
        cmd << "st cmd 0x${device.deviceNetworkId} ${endpointId} 6 1 {}"
        cmd << "delay 150"
    }

    cmd << "st cmd 0x${device.deviceNetworkId} ${endpointId} 0x300 0x06 {${scaledHueValue} ${scaledSatValue} ${transitionTime}}"
    
    
    if (value.level) {
	    cmd << "delay 150"
        state.levelValue = value.level
	    sendEvent(name: "level", value: state.levelValue, isStateChange: true)
    	def scaledLevel = hex(state.levelValue * 255 / 100)
//		sendEvent(name: "level", value: value.level, displayed: true, isStateChange: true)
 //       def level = hex(value.level * 254 / 100)
		cmd <<  "st cmd 0x${device.deviceNetworkId} ${endpointId} 8 4 {${scaledLevel} ${transitionTime}}" 	// "st cmd 0x${device.deviceNetworkId} ${endpointId} 8 4 {${level} 1500}"
    }
    
    if (value.switch == "off") {
        cmd << "delay 150"
        cmd << "st cmd 0x${device.deviceNetworkId} ${endpointId} 6 0 {}"
    }

    cmd
    }
}


def refresh() {

// Ping the device with color as to not get out of sync 
    [
	"st rattr 0x${device.deviceNetworkId} ${endpointId} 6 0", "delay 500",
    "st rattr 0x${device.deviceNetworkId} ${endpointId} 8 0", "delay 500",
    "st rattr 0x${device.deviceNetworkId} ${endpointId} 0x0300 1","delay 500",
    "st rattr 0x${device.deviceNetworkId} ${endpointId} 0x0300 0","delay 500",
    "st rattr 0x${device.deviceNetworkId} ${endpointId} 0x0300 7","delay 500",
    "st rattr 0x${device.deviceNetworkId} ${endpointId} 0x0300 8", "delay 500",
    "st wattr 0x${device.deviceNetworkId} ${endpointId} 8 0x10 0x21 {0015}"
    
    ]
}

def poll(){
	log.debug "Poll is calling refresh"
	refresh()
}

def configure(){
	log.debug "Initiating configuration reporting and binding"
    
    [  
    	zigbee.configSetup("6","0","0x10","0","60","{}"), "delay 1000",
        zigbee.configSetup("8","0","0x20","5","600","{10}"), "delay 1500",
        
        "zdo bind 0x${device.deviceNetworkId} ${endpointId} 1 6 {${device.zigbeeId}} {}", "delay 1000",
		"zdo bind 0x${device.deviceNetworkId} ${endpointId} 1 8 {${device.zigbeeId}} {}", "delay 1000",
        "zdo bind 0x${device.deviceNetworkId} ${endpointId} 1 0x0300 {${device.zigbeeId}} {}"
	]
    
}

//input Hue Integer values; returns color name for saturation 100%
def getColorName(hueValue){
    if(hueValue>360 || hueValue<0)
        return

    hueValue = Math.round(hueValue / 100 * 360)

    log.debug "hue value (in degrees) is $hueValue."

    def colorName = "Color Mode"
    if(hueValue>=0 && hueValue <= 4){
        colorName = "Red"
    }
    else if (hueValue>=5 && hueValue <=21 ){
        colorName = "Brick Red"
    }
    else if (hueValue>=22 && hueValue <=30 ){
        colorName = "Safety Orange"
    }
    else if (hueValue>=31 && hueValue <=40 ){
        colorName = "Dark Orange"
    }
    else if (hueValue>=41 && hueValue <=49 ){
        colorName = "Amber"
    }
    else if (hueValue>=50 && hueValue <=56 ){
        colorName = "Gold"
    }
    else if (hueValue>=57 && hueValue <=65 ){
        colorName = "Yellow"
    }
    else if (hueValue>=66 && hueValue <=83 ){
        colorName = "Electric Lime"
    }
    else if (hueValue>=84 && hueValue <=93 ){
        colorName = "Lawn Green"
    }
    else if (hueValue>=94 && hueValue <=112 ){
        colorName = "Bright Green"
    }
    else if (hueValue>=113 && hueValue <=135 ){
        colorName = "Lime"
    }
    else if (hueValue>=136 && hueValue <=166 ){
        colorName = "Spring Green"
    }
    else if (hueValue>=167 && hueValue <=171 ){
        colorName = "Turquoise"
    }
    else if (hueValue>=172 && hueValue <=187 ){
        colorName = "Aqua"
    }
    else if (hueValue>=188 && hueValue <=203 ){
        colorName = "Sky Blue"
    }
    else if (hueValue>=204 && hueValue <=217 ){
        colorName = "Dodger Blue"
    }
    else if (hueValue>=218 && hueValue <=223 ){
        colorName = "Navy Blue"
    }
    else if (hueValue>=224 && hueValue <=251 ){
        colorName = "Blue"
    }
    else if (hueValue>=252 && hueValue <=256 ){
        colorName = "Han Purple"
    }
    else if (hueValue>=257 && hueValue <=274 ){
        colorName = "Electric Indigo"
    }
    else if (hueValue>=275 && hueValue <=289 ){
        colorName = "Electric Purple"
    }
    else if (hueValue>=290 && hueValue <=300 ){
        colorName = "Orchid Purple"
    }
    else if (hueValue>=301 && hueValue <=315 ){
        colorName = "Magenta"
    }
    else if (hueValue>=316 && hueValue <=326 ){
        colorName = "Hot Pink"
    }
    else if (hueValue>=327 && hueValue <=335 ){
        colorName = "Deep Pink"
    }
    else if (hueValue>=336 && hueValue <=339 ){
        colorName = "Raspberry"
    }
    else if (hueValue>=340 && hueValue <=352 ){
        colorName = "Crimson"
    }
    else if (hueValue>=353 && hueValue <=360 ){
        colorName = "Red"
    }

    colorName
}


private getEndpointId() {
	new BigInteger(device.endpointId, 16).toString()
}

private hex(value, width=2) {
	def s = new BigInteger(Math.round(value).toString()).toString(16)
	while (s.size() < width) {
		s = "0" + s
	}
	s
}

private evenHex(value){
    def s = new BigInteger(Math.round(value).toString()).toString(16)
    while (s.size() % 2 != 0) {
        s = "0" + s
    }
    s
}

//Need to reverse array of size 2
private byte[] reverseArray(byte[] array) {
    byte tmp;
    tmp = array[1];
    array[1] = array[0];
    array[0] = tmp;
    return array
}

private hexF(value, width) {
	def s = new BigInteger(Math.round(value).toString()).toString(16)
	while (s.size() < width) {
		s = "0" + s
	}
	s
}

private String swapEndianHex(String hex) {
    reverseArray(hex.decodeHex()).encodeHex()
}

private Integer convertHexToInt(hex) {
	Integer.parseInt(hex,16)
}