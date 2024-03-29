
//  Copyright (c) 2003-2023 Movella Technologies B.V. or subsidiaries worldwide.
//  All rights reserved.
//  
//  Redistribution and use in source and binary forms, with or without modification,
//  are permitted provided that the following conditions are met:
//  
//  1.	Redistributions of source code must retain the above copyright notice,
//  	this list of conditions and the following disclaimer.
//  
//  2.	Redistributions in binary form must reproduce the above copyright notice,
//  	this list of conditions and the following disclaimer in the documentation
//  	and/or other materials provided with the distribution.
//  
//  3.	Neither the names of the copyright holders nor the names of their contributors
//  	may be used to endorse or promote products derived from this software without
//  	specific prior written permission.
//  
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
//  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
//  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
//  THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
//  SPECIAL, EXEMPLARY OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
//  OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
//  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY OR
//  TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
//  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//  

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.movella.movelladot_pc_sdk;

public class XsDotDevice {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsDotDevice(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsDotDevice obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
  }

  public void readDeviceControl() {
    movelladot_pc_sdkJNI.XsDotDevice_readDeviceControl(swigCPtr, this);
  }

  public XsVersion firmwareVersion() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_firmwareVersion(swigCPtr, this), true);
  }

  public XsVersion hardwareVersion() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_hardwareVersion(swigCPtr, this), true);
  }

  public XsString buildInfo() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_buildInfo(swigCPtr, this), true);
  }

  public XsString bluetoothAddress() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_bluetoothAddress(swigCPtr, this), true);
  }

  public XsString productCode() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_productCode(swigCPtr, this), true);
  }

  public long softDeviceVersion() {
    return movelladot_pc_sdkJNI.XsDotDevice_softDeviceVersion(swigCPtr, this);
  }

  public XsString deviceTagName() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_deviceTagName(swigCPtr, this), true);
  }

  public boolean setDeviceTagName(XsString tagName) {
    return movelladot_pc_sdkJNI.XsDotDevice_setDeviceTagName(swigCPtr, this, XsString.getCPtr(tagName), tagName);
  }

  public int outputRate() {
    return movelladot_pc_sdkJNI.XsDotDevice_outputRate(swigCPtr, this);
  }

  public boolean setOutputRate(int outputRate) {
    return movelladot_pc_sdkJNI.XsDotDevice_setOutputRate(swigCPtr, this, outputRate);
  }

  public boolean identify() {
    return movelladot_pc_sdkJNI.XsDotDevice_identify(swigCPtr, this);
  }

  public boolean powerOff() {
    return movelladot_pc_sdkJNI.XsDotDevice_powerOff(swigCPtr, this);
  }

  public boolean setPowerOnByUsb(boolean enable) {
    return movelladot_pc_sdkJNI.XsDotDevice_setPowerOnByUsb(swigCPtr, this, enable);
  }

  public boolean setPowerSavingOptions(int advertisementTimeout, int connectedDeviceTimeout) {
    return movelladot_pc_sdkJNI.XsDotDevice_setPowerSavingOptions(swigCPtr, this, advertisementTimeout, connectedDeviceTimeout);
  }

  public int getAdvertisementPowerSavingTimeout() {
    return movelladot_pc_sdkJNI.XsDotDevice_getAdvertisementPowerSavingTimeout(swigCPtr, this);
  }

  public int getConnectedPowerSavingTimeout() {
    return movelladot_pc_sdkJNI.XsDotDevice_getConnectedPowerSavingTimeout(swigCPtr, this);
  }

  public boolean isCharging() {
    return movelladot_pc_sdkJNI.XsDotDevice_isCharging(swigCPtr, this);
  }

  public int batteryLevel() {
    return movelladot_pc_sdkJNI.XsDotDevice_batteryLevel(swigCPtr, this);
  }

  public XsFilterProfile onboardFilterProfile() {
    return new XsFilterProfile(movelladot_pc_sdkJNI.XsDotDevice_onboardFilterProfile(swigCPtr, this), true);
  }

  public boolean setOnboardFilterProfile(XsString profileType) {
    return movelladot_pc_sdkJNI.XsDotDevice_setOnboardFilterProfile(swigCPtr, this, XsString.getCPtr(profileType), profileType);
  }

  public XsFilterProfileArray getAvailableFilterProfiles() {
    return new XsFilterProfileArray(movelladot_pc_sdkJNI.XsDotDevice_getAvailableFilterProfiles(swigCPtr, this), true);
  }

  public XsStringArray getCharacteristicStrings() {
    return new XsStringArray(movelladot_pc_sdkJNI.XsDotDevice_getCharacteristicStrings(swigCPtr, this), true);
  }

  public boolean restoreFactoryDefaults() {
    return movelladot_pc_sdkJNI.XsDotDevice_restoreFactoryDefaults(swigCPtr, this);
  }

  public XsPayloadMode payloadMode() {
    return XsPayloadMode.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_payloadMode(swigCPtr, this));
  }

  public boolean startMeasurement(XsPayloadMode mode) {
    return movelladot_pc_sdkJNI.XsDotDevice_startMeasurement(swigCPtr, this, mode.swigValue());
  }

  public boolean stopMeasurement() {
    return movelladot_pc_sdkJNI.XsDotDevice_stopMeasurement(swigCPtr, this);
  }

  public XsRecordingAcknowledgeResult getRecordingAckResult() {
    return XsRecordingAcknowledgeResult.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_getRecordingAckResult(swigCPtr, this));
  }

  public boolean startRecording() {
    return movelladot_pc_sdkJNI.XsDotDevice_startRecording(swigCPtr, this);
  }

  public boolean startTimedRecording(int seconds) {
    return movelladot_pc_sdkJNI.XsDotDevice_startTimedRecording(swigCPtr, this, seconds);
  }

  public boolean stopRecording() {
    return movelladot_pc_sdkJNI.XsDotDevice_stopRecording(swigCPtr, this);
  }

  public boolean eraseFlash() {
    return movelladot_pc_sdkJNI.XsDotDevice_eraseFlash(swigCPtr, this);
  }

  public XsRecordingTimeInfo getRecordingTime() {
    return new XsRecordingTimeInfo(movelladot_pc_sdkJNI.XsDotDevice_getRecordingTime(swigCPtr, this), true);
  }

  public int recordingCount() {
    return movelladot_pc_sdkJNI.XsDotDevice_recordingCount(swigCPtr, this);
  }

  public int usedFlashSizeTotal() {
    return movelladot_pc_sdkJNI.XsDotDevice_usedFlashSizeTotal(swigCPtr, this);
  }

  public XsRecordingInfo getRecordingInfo(int recordingIndex) {
    return new XsRecordingInfo(movelladot_pc_sdkJNI.XsDotDevice_getRecordingInfo(swigCPtr, this, recordingIndex), true);
  }

  public boolean selectExportData(XsIntArray selectedDataFields) {
    return movelladot_pc_sdkJNI.XsDotDevice_selectExportData(swigCPtr, this, XsIntArray.getCPtr(selectedDataFields), selectedDataFields);
  }

  public boolean startExportRecording(int recordingIndex) {
    return movelladot_pc_sdkJNI.XsDotDevice_startExportRecording(swigCPtr, this, recordingIndex);
  }

  public boolean stopExportRecording() {
    return movelladot_pc_sdkJNI.XsDotDevice_stopExportRecording(swigCPtr, this);
  }

  public boolean startSync(XsString rootNodeMac) {
    return movelladot_pc_sdkJNI.XsDotDevice_startSync(swigCPtr, this, XsString.getCPtr(rootNodeMac), rootNodeMac);
  }

  public boolean stopSync() {
    return movelladot_pc_sdkJNI.XsDotDevice_stopSync(swigCPtr, this);
  }

  public XsSyncAcknowledgeResult getSyncStatus() {
    return XsSyncAcknowledgeResult.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_getSyncStatus(swigCPtr, this));
  }

  public XsSyncAcknowledgeResult getSyncResult() {
    return XsSyncAcknowledgeResult.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_getSyncResult(swigCPtr, this));
  }

  public boolean resetOrientation(XsResetMethod resetMethod) {
    return movelladot_pc_sdkJNI.XsDotDevice_resetOrientation(swigCPtr, this, resetMethod.swigValue());
  }

  public XsVersion checkForFirmwareUpdate() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_checkForFirmwareUpdate(swigCPtr, this), true);
  }

  public XsVersion checkForFirmwareRollback() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_checkForFirmwareRollback(swigCPtr, this), true);
  }

  public XsVersion startFirmwareUpdateFromServer() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_startFirmwareUpdateFromServer(swigCPtr, this), true);
  }

  public XsVersion startFirmwareRollbackFromServer() {
    return new XsVersion(movelladot_pc_sdkJNI.XsDotDevice_startFirmwareRollbackFromServer(swigCPtr, this), true);
  }

  public void startFirmwareUpdateFromFile(XsString firmwareFile) {
    movelladot_pc_sdkJNI.XsDotDevice_startFirmwareUpdateFromFile(swigCPtr, this, XsString.getCPtr(firmwareFile), firmwareFile);
  }

  public boolean startMagneticFieldMapping() {
    return movelladot_pc_sdkJNI.XsDotDevice_startMagneticFieldMapping(swigCPtr, this);
  }

  public boolean stopMagneticFieldMapping() {
    return movelladot_pc_sdkJNI.XsDotDevice_stopMagneticFieldMapping(swigCPtr, this);
  }

  public boolean processMagneticFieldMapping(XsString filename, XsByteArray mfmResult) {
    return movelladot_pc_sdkJNI.XsDotDevice_processMagneticFieldMapping(swigCPtr, this, XsString.getCPtr(filename), filename, XsByteArray.getCPtr(mfmResult), mfmResult);
  }

  public boolean storeMagneticFieldMapping(XsByteArray mfmResult) {
    return movelladot_pc_sdkJNI.XsDotDevice_storeMagneticFieldMapping(swigCPtr, this, XsByteArray.getCPtr(mfmResult), mfmResult);
  }

  public boolean gotoConfig() {
    return movelladot_pc_sdkJNI.XsDotDevice_gotoConfig(swigCPtr, this);
  }

  public boolean enableLogging(XsString filename) {
    return movelladot_pc_sdkJNI.XsDotDevice_enableLogging(swigCPtr, this, XsString.getCPtr(filename), filename);
  }

  public boolean disableLogging() {
    return movelladot_pc_sdkJNI.XsDotDevice_disableLogging(swigCPtr, this);
  }

  public void setLogOptions(XsLogOptions options) {
    movelladot_pc_sdkJNI.XsDotDevice_setLogOptions(swigCPtr, this, options.swigValue());
  }

  public void writeDeviceSettingsToFile(XsPayloadMode mode) {
    movelladot_pc_sdkJNI.XsDotDevice_writeDeviceSettingsToFile__SWIG_0(swigCPtr, this, mode.swigValue());
  }

  public void writeDeviceSettingsToFile() {
    movelladot_pc_sdkJNI.XsDotDevice_writeDeviceSettingsToFile__SWIG_1(swigCPtr, this);
  }

  public XsString portName() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_portName(swigCPtr, this), true);
  }

  public XsPortInfo portInfo() {
    return new XsPortInfo(movelladot_pc_sdkJNI.XsDotDevice_portInfo(swigCPtr, this), true);
  }

  public XsDeviceId deviceId() {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDotDevice_deviceId(swigCPtr, this), true);
  }

  public XsResultValue lastResult() {
    return XsResultValue.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_lastResult(swigCPtr, this));
  }

  public XsString lastResultText() {
    return new XsString(movelladot_pc_sdkJNI.XsDotDevice_lastResultText(swigCPtr, this), true);
  }

  public XsDeviceState deviceState() {
    return XsDeviceState.swigToEnum(movelladot_pc_sdkJNI.XsDotDevice_deviceState(swigCPtr, this));
  }

  public void addRef() {
    movelladot_pc_sdkJNI.XsDotDevice_addRef(swigCPtr, this);
  }

  public void removeRef() {
    movelladot_pc_sdkJNI.XsDotDevice_removeRef(swigCPtr, this);
  }

  public long refCounter() {
    return movelladot_pc_sdkJNI.XsDotDevice_refCounter(swigCPtr, this);
  }

  public void clearXsDotCallbackHandlers(boolean chain) {
    movelladot_pc_sdkJNI.XsDotDevice_clearXsDotCallbackHandlers__SWIG_0(swigCPtr, this, chain);
  }

  public void clearXsDotCallbackHandlers() {
    movelladot_pc_sdkJNI.XsDotDevice_clearXsDotCallbackHandlers__SWIG_1(swigCPtr, this);
  }

}
