
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

public final class XsDotFirmwareUpdateResult {
  public final static XsDotFirmwareUpdateResult Success = new XsDotFirmwareUpdateResult("Success", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_Success_get());
  public final static XsDotFirmwareUpdateResult NoUsb = new XsDotFirmwareUpdateResult("NoUsb", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_NoUsb_get());
  public final static XsDotFirmwareUpdateResult NoFwFile = new XsDotFirmwareUpdateResult("NoFwFile", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_NoFwFile_get());
  public final static XsDotFirmwareUpdateResult IncorrectFwFile = new XsDotFirmwareUpdateResult("IncorrectFwFile", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_IncorrectFwFile_get());
  public final static XsDotFirmwareUpdateResult CommunicationFailure = new XsDotFirmwareUpdateResult("CommunicationFailure", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_CommunicationFailure_get());
  public final static XsDotFirmwareUpdateResult FailedToStart = new XsDotFirmwareUpdateResult("FailedToStart", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_FailedToStart_get());
  public final static XsDotFirmwareUpdateResult FailedToEnd = new XsDotFirmwareUpdateResult("FailedToEnd", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_FailedToEnd_get());
  public final static XsDotFirmwareUpdateResult BootloaderFail = new XsDotFirmwareUpdateResult("BootloaderFail", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_BootloaderFail_get());
  public final static XsDotFirmwareUpdateResult ErrorPreamble = new XsDotFirmwareUpdateResult("ErrorPreamble", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorPreamble_get());
  public final static XsDotFirmwareUpdateResult ErrorCmd = new XsDotFirmwareUpdateResult("ErrorCmd", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorCmd_get());
  public final static XsDotFirmwareUpdateResult ErrorOperating = new XsDotFirmwareUpdateResult("ErrorOperating", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorOperating_get());
  public final static XsDotFirmwareUpdateResult ErrorPacketCrc = new XsDotFirmwareUpdateResult("ErrorPacketCrc", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorPacketCrc_get());
  public final static XsDotFirmwareUpdateResult ErrorImageCrc = new XsDotFirmwareUpdateResult("ErrorImageCrc", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorImageCrc_get());
  public final static XsDotFirmwareUpdateResult ErrorIndex = new XsDotFirmwareUpdateResult("ErrorIndex", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorIndex_get());
  public final static XsDotFirmwareUpdateResult ErrorFlash = new XsDotFirmwareUpdateResult("ErrorFlash", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorFlash_get());
  public final static XsDotFirmwareUpdateResult ErrorDischarging = new XsDotFirmwareUpdateResult("ErrorDischarging", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorDischarging_get());
  public final static XsDotFirmwareUpdateResult ErrorRecording = new XsDotFirmwareUpdateResult("ErrorRecording", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorRecording_get());
  public final static XsDotFirmwareUpdateResult ErrorDownloadNoCurl = new XsDotFirmwareUpdateResult("ErrorDownloadNoCurl", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorDownloadNoCurl_get());
  public final static XsDotFirmwareUpdateResult ErrorDownloadNoCurlPerform = new XsDotFirmwareUpdateResult("ErrorDownloadNoCurlPerform", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorDownloadNoCurlPerform_get());
  public final static XsDotFirmwareUpdateResult ErrorDownloadNoCurlGetInfo = new XsDotFirmwareUpdateResult("ErrorDownloadNoCurlGetInfo", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorDownloadNoCurlGetInfo_get());
  public final static XsDotFirmwareUpdateResult ErrorDownloadCurlEmptyContent = new XsDotFirmwareUpdateResult("ErrorDownloadCurlEmptyContent", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorDownloadCurlEmptyContent_get());
  public final static XsDotFirmwareUpdateResult ErrorUnknown = new XsDotFirmwareUpdateResult("ErrorUnknown", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_ErrorUnknown_get());
  public final static XsDotFirmwareUpdateResult NoNewFWAvailable = new XsDotFirmwareUpdateResult("NoNewFWAvailable", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_NoNewFWAvailable_get());
  public final static XsDotFirmwareUpdateResult InitialValue = new XsDotFirmwareUpdateResult("InitialValue", movelladot_pc_sdkJNI.XsDotFirmwareUpdateResult_InitialValue_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static XsDotFirmwareUpdateResult swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + XsDotFirmwareUpdateResult.class + " with value " + swigValue);
  }

  private XsDotFirmwareUpdateResult(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private XsDotFirmwareUpdateResult(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private XsDotFirmwareUpdateResult(String swigName, XsDotFirmwareUpdateResult swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static XsDotFirmwareUpdateResult[] swigValues = { Success, NoUsb, NoFwFile, IncorrectFwFile, CommunicationFailure, FailedToStart, FailedToEnd, BootloaderFail, ErrorPreamble, ErrorCmd, ErrorOperating, ErrorPacketCrc, ErrorImageCrc, ErrorIndex, ErrorFlash, ErrorDischarging, ErrorRecording, ErrorDownloadNoCurl, ErrorDownloadNoCurlPerform, ErrorDownloadNoCurlGetInfo, ErrorDownloadCurlEmptyContent, ErrorUnknown, NoNewFWAvailable, InitialValue };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

