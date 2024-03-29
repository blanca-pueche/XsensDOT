
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

public final class XsBaudRate {
  public final static XsBaudRate XBR_Invalid = new XsBaudRate("XBR_Invalid", movelladot_pc_sdkJNI.XBR_Invalid_get());
  public final static XsBaudRate XBR_4800 = new XsBaudRate("XBR_4800", movelladot_pc_sdkJNI.XBR_4800_get());
  public final static XsBaudRate XBR_9600 = new XsBaudRate("XBR_9600", movelladot_pc_sdkJNI.XBR_9600_get());
  public final static XsBaudRate XBR_14k4 = new XsBaudRate("XBR_14k4", movelladot_pc_sdkJNI.XBR_14k4_get());
  public final static XsBaudRate XBR_19k2 = new XsBaudRate("XBR_19k2", movelladot_pc_sdkJNI.XBR_19k2_get());
  public final static XsBaudRate XBR_28k8 = new XsBaudRate("XBR_28k8", movelladot_pc_sdkJNI.XBR_28k8_get());
  public final static XsBaudRate XBR_38k4 = new XsBaudRate("XBR_38k4", movelladot_pc_sdkJNI.XBR_38k4_get());
  public final static XsBaudRate XBR_57k6 = new XsBaudRate("XBR_57k6", movelladot_pc_sdkJNI.XBR_57k6_get());
  public final static XsBaudRate XBR_76k8 = new XsBaudRate("XBR_76k8", movelladot_pc_sdkJNI.XBR_76k8_get());
  public final static XsBaudRate XBR_115k2 = new XsBaudRate("XBR_115k2", movelladot_pc_sdkJNI.XBR_115k2_get());
  public final static XsBaudRate XBR_230k4 = new XsBaudRate("XBR_230k4", movelladot_pc_sdkJNI.XBR_230k4_get());
  public final static XsBaudRate XBR_460k8 = new XsBaudRate("XBR_460k8", movelladot_pc_sdkJNI.XBR_460k8_get());
  public final static XsBaudRate XBR_921k6 = new XsBaudRate("XBR_921k6", movelladot_pc_sdkJNI.XBR_921k6_get());
  public final static XsBaudRate XBR_2000k = new XsBaudRate("XBR_2000k", movelladot_pc_sdkJNI.XBR_2000k_get());
  public final static XsBaudRate XBR_3500k = new XsBaudRate("XBR_3500k", movelladot_pc_sdkJNI.XBR_3500k_get());
  public final static XsBaudRate XBR_4000k = new XsBaudRate("XBR_4000k", movelladot_pc_sdkJNI.XBR_4000k_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static XsBaudRate swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + XsBaudRate.class + " with value " + swigValue);
  }

  private XsBaudRate(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private XsBaudRate(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private XsBaudRate(String swigName, XsBaudRate swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static XsBaudRate[] swigValues = { XBR_Invalid, XBR_4800, XBR_9600, XBR_14k4, XBR_19k2, XBR_28k8, XBR_38k4, XBR_57k6, XBR_76k8, XBR_115k2, XBR_230k4, XBR_460k8, XBR_921k6, XBR_2000k, XBR_3500k, XBR_4000k };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

