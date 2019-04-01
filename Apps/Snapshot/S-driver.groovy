/**
 *  ****************  Snapshot Tile Driver  ****************
 *
 *  Design Usage:
 *  This driver formats the Snapshot data to be used with Hubitat's Dashboards.
 *
 *  Copyright 2019 Bryan Turcotte (@bptworld)
 *  
 *  This App is free.  If you like and use this app, please be sure to give a shout out on the Hubitat forums to let
 *  people know that it exists!  Thanks.
 *
 *  Remember...I am not a programmer, everything I do takes a lot of time and research (then MORE research)!
 *  Donations are never necessary but always appreciated.  Donations to support development efforts are accepted via: 
 *
 *  Paypal at: https://paypal.me/bptworld
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 *
 *  If modifying this project, please keep the above header intact and add your comments/credits below - Thank you! -  @BPTWorld
 *
 *  App and Driver updates can be found at https://github.com/bptworld/Hubitat
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 *
 *  Changes:
 *
 *  V1.0.5 - 04/01/19 - Adjust driver for lock support
 *  V1.0.4 - 04/01/19 - Adjust driver for priority type of tiles
 *  V1.0.3 - 03/30/19 - Adjust driver for on/off and open/close type of tiles
 *  V1.0.2 - 03/27/19 - Added support for counting how many devices are On/Off/Open/Closed
 *  V1.0.1 - 03/23/19 - Adjusted for new Dashboard requirements
 *  V1.0.0 - 03/06/19 - Initial release
 */

metadata {
	definition (name: "Snapshot Tile", namespace: "BPTWorld", author: "Bryan Turcotte") {
   		capability "Actuator"

		command "sendSnapshotSwitchMap1", ["string"]
		command "sendSnapshotSwitchMap2", ["string"]
		command "sendSnapshotSwitchMap3", ["string"]
		command "sendSnapshotSwitchMap4", ["string"]
		command "sendSnapshotSwitchMap5", ["string"]
		command "sendSnapshotSwitchMap6", ["string"]
		
		command "sendSnapshotContactMap1", ["string"]
		command "sendSnapshotContactMap2", ["string"]
		command "sendSnapshotContactMap3", ["string"]
		command "sendSnapshotContactMap4", ["string"]
		command "sendSnapshotContactMap5", ["string"]
		command "sendSnapshotContactMap6", ["string"]
		
		command "sendSnapshotLockMap1", ["string"]
		command "sendSnapshotLockMap2", ["string"]
		
		command "sendSnapshotSwitchCountOn", ["string"]
		command "sendSnapshotSwitchCountOff", ["string"]
		command "sendSnapshotContactCountOpen", ["string"]
		command "sendSnapshotContactCountClosed", ["string"]
		command "sendSnapshotLockCountUnlocked", ["string"]
		command "sendSnapshotLockCountLocked", ["string"]
		
		command "sendSnapshotPrioritySwitchMap1", ["string"]
		command "sendSnapshotPrioritySwitchMap2", ["string"]
		command "sendSnapshotPriorityContactMap1", ["string"]
		command "sendSnapshotPriorityContactMap2", ["string"]
		command "sendSnapshotPriorityLockMap1", ["string"]
		command "sendSnapshotPriorityLockMap2", ["string"]
		
    	attribute "snapshotSwitch1", "string"
		attribute "snapshotSwitch2", "string"
		attribute "snapshotSwitch3", "string"
		attribute "snapshotSwitch4", "string"
		attribute "snapshotSwitch5", "string"
		attribute "snapshotSwitch6", "string"
		attribute "snapshotSwitchCountOn", "string"
		attribute "snapshotSwitchCountOff", "string"
		
		attribute "snapshotContact1", "string"
		attribute "snapshotContact2", "string"
		attribute "snapshotContact3", "string"
		attribute "snapshotContact4", "string"
		attribute "snapshotContact5", "string"
		attribute "snapshotContact6", "string"
		attribute "snapshotContactCountOpen", "string"
		attribute "snapshotCountactCountClosed", "string"
		
		attribute "snapshotLock1", "string"
		attribute "snapshotLock2", "string"
		attribute "snapshotLockCountUnlocked", "string"
		attribute "snapshotLockCountLocked", "string"
		
		attribute "snapshotPrioritySwitch1", "string"
		attribute "snapshotPrioritySwitch2", "string"
		attribute "snapshotPriorityContact1", "string"
		attribute "snapshotPriorityContact2", "string"
		attribute "snapshotPriorityLock1", "string"
		attribute "snapshotPriorityLock2", "string"
	}
	preferences() {    	
        section(){
			input("fontSize", "text", title: "Data Font Size", required: true, defaultValue: "15")
			input("fontSizeS", "text", title: "Date Font Size", required: true, defaultValue: "12")
            input("debugMode", "bool", title: "Enable logging", required: true, defaultValue: true)
        }
    }
}

def sendSnapshotSwitchMap1(switchMap1) {
	state.switchDevice1a = "${switchMap1}"
	state.switchDevice1 = "<table width='100%'><tr>"
	state.switchDevice1 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice1 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice1a}</div>"
	state.switchDevice1 += "</td></tr></table>"
	state.switchDevice1Count = state.switchDevice1.length()
	if(state.switchDevice1Count <= 1000) {
		LOGDEBUG("switchDevice1 - has ${state.switchDevice1Count} Characters<br>${state.switchDevice1}")
	} else {
		state.switchDevice1 = "Too many characters to display on Dashboard (${state.switchDevice1Count})"
	}
	sendEvent(name: "snapshotSwitch1", value: state.switchDevice1, displayed: true)
}

def sendSnapshotSwitchMap2(switchMap2) {
	state.switchDevice2a = "${switchMap2}"
	state.switchDevice2 = "<table width='100%'><tr>"
	state.switchDevice2 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice2 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice2a}</div>"
	state.switchDevice2 += "</td></tr></table>"
	state.switchDevice2Count = state.switchDevice2.length()
	if(state.switchtDevice2Count <= 1000) {
		LOGDEBUG("switchDevice2 - has ${state.switchDevice2Count} Characters<br>${state.switchDevice2}")
	} else {
		state.switchDevice2 = "Too many characters to display on Dashboard (${state.switchDevice2Count})"
	}
	sendEvent(name: "snapshotSwitch2", value: state.switchDevice2, displayed: true)
}

def sendSnapshotSwitchMap3(switchMap3) {
	state.switchDevice3a = "${switchMap3}"
	state.switchDevice3 = "<table width='100%'><tr>"
	state.switchDevice3 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice3 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice3a}</div>"
	state.switchDevice3 += "</td></tr></table>"
	state.switchDevice3Count = state.switchDevice3.length()
	if(state.switchDevice3Count <= 1000) {
		LOGDEBUG("switchDevice3 - has ${state.switchDevice3Count} Characters<br>${state.switchDevice3}")
	} else {
		state.switchDevice3 = "Too many characters to display on Dashboard (${state.switchDevice3Count})"
	}
	sendEvent(name: "snapshotSwitch3", value: state.switchDevice3, displayed: true)
}

def sendSnapshotSwitchMap4(switchMap4) {
	state.switchDevice4a = "${switchMap4}"
	state.switchDevice4 = "<table width='100%'><tr>"
	state.switchDevice4 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice4 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice4a}</div>"
	state.switchDevice4 += "</td></tr></table>"
	state.switchDevice4Count = state.switchDevice4.length()
	if(state.switchDevice4Count <= 1000) {
		LOGDEBUG("switchDevice4 - has ${state.switchDevice4Count} Characters<br>${state.switchDevice4}")
	} else {
		state.switchDevice4 = "Too many characters to display on Dashboard (${state.switchDevice4Count})"
	}
	sendEvent(name: "snapshotSwitch4", value: state.switchDevice4, displayed: true)
}

def sendSnapshotSwitchMap5(switchMap5) {
	state.switchDevice5a = "${switchMap5}"
	state.switchDevice5 = "<table width='100%'><tr>"
	state.switchDevice5 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice5 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice5a}</div>"
	state.switchDevice5 += "</td></tr></table>"
	state.switchDevice5Count = state.switchDevice5.length()
	if(state.switchDevice5Count <= 1000) {
		LOGDEBUG("switchDevice5 - has ${state.switchDevice5Count} Characters<br>${state.switchDevice5}")
	} else {
		state.switchDevice5 = "Too many characters to display on Dashboard (${state.switchDevice5Count})"
	}
	sendEvent(name: "snapshotSwitch5", value: state.switchDevice5, displayed: true)
}

def sendSnapshotSwitchMap6(switchMap6) {
	state.switchDevice6a = "${switchMap6}"
	state.switchDevice6 = "<table width='100%'><tr>"
	state.switchDevice6 += "<td style='text-align: left; width: 100%'>"
	state.switchDevice6 += "<div style='font-size: ${fontSize}px'> ${state.switchDevice6a}</div>"
	state.switchDevice6 += "</td></tr></table>"
	state.switchDevice6Count = state.switchDevice6.length()
	if(state.switchDevice6Count <= 1000) {
		LOGDEBUG("switchDevice6 - has ${state.switchDevice6Count} Characters<br>${state.switchDevice6}")
	} else {
		state.switchDevice6 = "Too many characters to display on Dashboard (${state.switchDevice6Count})"
	}
	sendEvent(name: "snapshotSwitch6", value: state.switchDevice6, displayed: true)
}

def sendSnapshotSwitchCountOn(switchCountOn) {
	sendEvent(name: "snapshotSwitchCountOn", value: switchCountOn, displayed: true)
}

def sendSnapshotSwitchCountOff(switchCountOff) {
	sendEvent(name: "snapshotSwitchCountOff", value: switchCountOff, displayed: true)
}

def sendSnapshotContactMap1(contactMap1) {
	state.contactDevice1a = "${contactMap1}"
	state.contactDevice1 = "<table width='100%'><tr>"
	state.contactDevice1 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice1 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice1a}</div>"
	state.contactDevice1 += "</td></tr></table>"
	state.contactDevice1Count = state.contactDevice1.length()
	if(state.contactDevice1Count <= 1000) {
		LOGDEBUG("contactDevice1 - has ${state.contactDevice1Count} Characters<br>${state.contactDevice1}")
	} else {
		state.contactDevice1 = "Too many characters to display on Dashboard (${state.contactDevice1Count})"
	}
	sendEvent(name: "snapshotContact1", value: state.contactDevice1, displayed: true)
}

def sendSnapshotContactMap2(contactMap2) {
	state.contactDevice2a = "${contactMap2}"
	state.contactDevice2 = "<table width='100%'><tr>"
	state.contactDevice2 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice2 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice2a}</div>"
	state.contactDevice2 += "</td></tr></table>"
	state.contactDevice2Count = state.contactDevice2.length()
	if(state.contactDevice2Count <= 1000) {
		LOGDEBUG("contactDevice2 - has ${state.contactDevice2Count} Characters<br>${state.contactDevice2}")
	} else {
		state.contactDevice2 = "Too many characters to display on Dashboard (${state.contactDevice2Count})"
	}
	sendEvent(name: "snapshotContact2", value: state.contactDevice2, displayed: true)
}

def sendSnapshotContactMap3(contactMap3) {
	state.contactDevice3a = "${contactMap3}"
	state.contactDevice3 = "<table width='100%'><tr>"
	state.contactDevice3 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice3 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice3a}</div>"
	state.contactDevice3 += "</td></tr></table>"
	state.contactDevice3Count = state.contactDevice3.length()
	if(state.contactDevice3Count <= 1000) {
		LOGDEBUG("contactDevice3 - has ${state.contactDevice3Count} Characters<br>${state.contactDevice3}")
	} else {
		state.contactDevice3 = "Too many characters to display on Dashboard (${state.contactDevice3Count})"
	}
	sendEvent(name: "snapshotContact3", value: state.contactDevice3, displayed: true)
}

def sendSnapshotContactMap4(contactMap4) {
	state.contactDevice4a = "${contactMap4}"
	state.contactDevice4 = "<table width='100%'><tr>"
	state.contactDevice4 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice4 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice4a}</div>"
	state.contactDevice4 += "</td></tr></table>"
	state.contactDevice4Count = state.contactDevice4.length()
	if(state.contactDevice4Count <= 1000) {
		LOGDEBUG("contactDevice4 - has ${state.contactDevice4Count} Characters<br>${state.contactDevice4}")
	} else {
		state.contactDevice4 = "Too many characters to display on Dashboard (${state.contactDevice4Count})"
	}
	sendEvent(name: "snapshotContact4", value: state.contactDevice4, displayed: true)
}

def sendSnapshotContactMap5(contactMap5) {
	state.contactDevice5a = "${contactMap5}"
	state.contactDevice5 = "<table width='100%'><tr>"
	state.contactDevice5 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice5 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice5a}</div>"
	state.contactDevice5 += "</td></tr></table>"
	state.contactDevice5Count = state.contactDevice5.length()
	if(state.contactDevice5Count <= 1000) {
		LOGDEBUG("contactDevice5 - has ${state.contactDevice5Count} Characters<br>${state.contactDevice5}")
	} else {
		state.contactDevice5 = "Too many characters to display on Dashboard (${state.contactDevice5Count})"
	}
	sendEvent(name: "snapshotContact5", value: state.contactDevice5, displayed: true)
}

def sendSnapshotContactMap6(contactMap6) {
	state.contactDevice6a = "${contactMap6}"
	state.contactDevice6 = "<table width='100%'><tr>"
	state.contactDevice6 += "<td style='text-align: left; width: 100%'>"
	state.contactDevice6 += "<div style='font-size: ${fontSize}px'> ${state.contactDevice6a}</div>"
	state.contactDevice6 += "</td></tr></table>"
	state.contactDevice6Count = state.contactDevice6.length()
	if(state.contactDevice6Count <= 1000) {
		LOGDEBUG("contactDevice6 - has ${state.contactDevice6Count} Characters<br>${state.contactDevice6}")
	} else {
		state.contactDevice6 = "Too many characters to display on Dashboard (${state.contactDevice6Count})"
	}
	sendEvent(name: "snapshotContact6", value: state.contactDevice6, displayed: true)
}

def sendSnapshotContactCountOpen(contactCountOpen) {
	sendEvent(name: "snapshotContactCountOpen", value: contactCountOpen, displayed: true)
}

def sendSnapshotContactCountClosed(contactCountClosed) {
	sendEvent(name: "snapshotContactCountClosed", value: contactCountClosed, displayed: true)
}

def sendSnapshotLockMap1(lockMap1) {
	state.lockDevice1a = "${lockMap1}"
	state.lockDevice1 = "<table width='100%'><tr>"
	state.lockDevice1 += "<td style='text-align: left; width: 100%'>"
	state.lockDevice1 += "<div style='font-size: ${fontSize}px'> ${state.lockDevice1a}</div>"
	state.lockDevice1 += "</td></tr></table>"
	state.lockDevice1Count = state.lockDevice1.length()
	if(state.lockDevice1Count <= 1000) {
		LOGDEBUG("lockDevice1 - has ${state.lockDevice1Count} Characters<br>${state.lockDevice1}")
	} else {
		state.lockDevice1 = "Too many characters to display on Dashboard (${state.lockDevice1Count})"
	}
	sendEvent(name: "snapshotLock1", value: state.lockDevice1, displayed: true)
}

def sendSnapshotLockMap2(lockMap2) {
	state.lockDevice2a = "${lockMap2}"
	state.lockDevice2 = "<table width='100%'><tr>"
	state.lockDevice2 += "<td style='text-align: left; width: 100%'>"
	state.lockDevice2 += "<div style='font-size: ${fontSize}px'> ${state.lockDevice2a}</div>"
	state.lockDevice2 += "</td></tr></table>"
	state.lockDevice2Count = state.lockDevice2.length()
	if(state.lockDevice2Count <= 1000) {
		LOGDEBUG("lockDevice2 - has ${state.lockDevice2Count} Characters<br>${state.lockDevice2}")
	} else {
		state.lockDevice2 = "Too many characters to display on Dashboard (${state.lockDevice2Count})"
	}
	sendEvent(name: "snapshotLock2", value: state.lockDevice2, displayed: true)
}

def sendSnapshotLockCountUnlocked(lockCountUnlocked) {
	sendEvent(name: "snapshotLockCountUnlocked", value: lockCountUnlocked, displayed: true)
}

def sendSnapshotLockCountLocked(lockCountLocked) {
	sendEvent(name: "snapshotLockCountLocked", value: lockCountLocked, displayed: true)
}

def sendSnapshotPrioritySwitchMap1(pSwitchMap1S) {
	state.pSwitchDevice1a = "${pSwitchMap1S}"
	state.pSwitchDevice1 = "<table width='100%'><tr>"
	state.pSwitchDevice1 += "<td style='text-align: left; width: 100%'>"
	state.pSwitchDevice1 += "<div style='font-size: ${fontSize}px'> ${state.pSwitchDevice1a}</div>"
	state.pSwitchDevice1 += "</td></tr></table>"
	state.pSwitchDevice1Count = state.pSwitchDevice1.length()
	if(state.pSwitchDevice1Count <= 1000) {
		LOGDEBUG("pSwitchDevice1 - has ${state.pSwitchDevice1Count} Characters<br>${state.pSwitchDevice1}")
	} else {
		state.pSwitchDevice1 = "Too many characters to display on Dashboard (${state.pSwitchDevice1Count})"
	}
	sendEvent(name: "snapshotPrioritySwitch1", value: state.pSwitchDevice1, displayed: true)
}

def sendSnapshotPrioritySwitchMap2(pSwitchMap2S) {
	state.pSwitchDevice2a = "${pSwitchMap2S}"
	state.pSwitchDevice2 = "<table width='100%'><tr>"
	state.pSwitchDevice2 += "<td style='text-align: left; width: 100%'>"
	state.pSwitchDevice2 += "<div style='font-size: ${fontSize}px'> ${state.pSwitchDevice2a}</div>"
	state.pSwitchDevice2 += "</td></tr></table>"
	state.pSwitchDevice2Count = state.pSwitchDevice2.length()
	if(state.pSwitchDevice2Count <= 1000) {
		LOGDEBUG("pSwitchDevice2 - has ${state.pSwitchDevice2Count} Characters<br>${state.pSwitchDevice2}")
	} else {
		state.pSwitchDevice2 = "Too many characters to display on Dashboard (${state.pSwitchDevice2Count})"
	}
	sendEvent(name: "snapshotPrioritySwitch2", value: state.pSwitchDevice2, displayed: true)
}

def sendSnapshotPriorityContactMap1(pContactMap1S) {
	state.pContactDevice1a = "${pContactMap1S}"
	state.pContactDevice1 = "<table width='100%'><tr>"
	state.pContactDevice1 += "<td style='text-align: left; width: 100%'>"
	state.pContactDevice1 += "<div style='font-size: ${fontSize}px'> ${state.pContactDevice1a}</div>"
	state.pContactDevice1 += "</td></tr></table>"
	state.pContactDevice1Count = state.pContactDevice1.length()
	if(state.pContactDevice1Count <= 1000) {
		LOGDEBUG("pContactDevice1 - has ${state.pContactDevice1Count} Characters<br>${state.pContactDevice1}")
	} else {
		state.pContactDevice1 = "Too many characters to display on Dashboard (${state.pContactDevice1Count})"
	}
	sendEvent(name: "snapshotPriorityContact1", value: state.pContactDevice1, displayed: true)
}

def sendSnapshotPriorityContactMap2(pContactMap2S) {
	state.pContactDevice2a = "${pContactMap2S}"
	state.pContactDevice2 = "<table width='100%'><tr>"
	state.pContactDevice2 += "<td style='text-align: left; width: 100%'>"
	state.pContactDevice2 += "<div style='font-size: ${fontSize}px'> ${state.pContactDevice2a}</div>"
	state.pContactDevice2 += "</td></tr></table>"
	state.pContactDevice2Count = state.pContactDevice2.length()
	if(state.pContactDevice2Count <= 1000) {
		LOGDEBUG("pContactDevice2 - has ${state.pContactDevice2ount} Characters<br>${state.pContactDevice2}")
	} else {
		state.pContactDevice2 = "Too many characters to display on Dashboard (${state.pContactDevice2Count})"
	}
	sendEvent(name: "snapshotPriorityContact2", value: state.pContactDevice2, displayed: true)
}

def sendSnapshotPriorityLockMap1(pLockMap1S) {
	state.pLockDevice1a = "${pLockMap1S}"
	state.pLockDevice1 = "<table width='100%'><tr>"
	state.pLockDevice1 += "<td style='text-align: left; width: 100%'>"
	state.pLockDevice1 += "<div style='font-size: ${fontSize}px'> ${state.pLockDevice1a}</div>"
	state.pLockDevice1 += "</td></tr></table>"
	state.pLockDevice1Count = state.pLockDevice1.length()
	if(state.pLockDevice1Count <= 1000) {
		LOGDEBUG("pLockDevice1 - has ${state.pLockDevice1Count} Characters<br>${state.pLockDevice1}")
	} else {
		state.pLockDevice1 = "Too many characters to display on Dashboard (${state.pLockDevice1Count})"
	}
	sendEvent(name: "snapshotPriorityLock1", value: state.pLockDevice1, displayed: true)
}

def sendSnapshotPriorityLockMap2(pLockMap2S) {
	state.pLockDevice2a = "${pLockMap2S}"
	state.pLockDevice2 = "<table width='100%'><tr>"
	state.pLockDevice2 += "<td style='text-align: left; width: 100%'>"
	state.pLockDevice2 += "<div style='font-size: ${fontSize}px'> ${state.pLockDevice2a}</div>"
	state.pLockDevice2 += "</td></tr></table>"
	state.pLockDevice2Count = state.pLockDevice2.length()
	if(state.pLockDevice2Count <= 1000) {
		LOGDEBUG("pLockDevice2 - has ${state.pLockDevice2Count} Characters<br>${state.pLockDevice2}")
	} else {
		state.pLockDevice2 = "Too many characters to display on Dashboard (${state.pLockDevice2Count})"
	}
	sendEvent(name: "snapshotPriorityLock2", value: state.pLockDevice2, displayed: true)
}

def installed(){
    log.info "Snapshot Tile has been Installed"
}

def updated() {
    log.info "Snap Tile has been Updated"
}

def LOGDEBUG(txt) {
    try {
    	if (settings.debugMode) { log.debug("${txt}") }
    } catch(ex) {
    	log.error("LOGDEBUG unable to output requested data!")
    }
}
	
