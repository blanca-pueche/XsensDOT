
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

public final class XsPortLinesOptions {
  public final static XsPortLinesOptions XPLO_Invalid = new XsPortLinesOptions("XPLO_Invalid", movelladot_pc_sdkJNI.XPLO_Invalid_get());
  public final static XsPortLinesOptions XPLO_RTS_Set = new XsPortLinesOptions("XPLO_RTS_Set", movelladot_pc_sdkJNI.XPLO_RTS_Set_get());
  public final static XsPortLinesOptions XPLO_RTS_Clear = new XsPortLinesOptions("XPLO_RTS_Clear", movelladot_pc_sdkJNI.XPLO_RTS_Clear_get());
  public final static XsPortLinesOptions XPLO_RTS_Ignore = new XsPortLinesOptions("XPLO_RTS_Ignore", movelladot_pc_sdkJNI.XPLO_RTS_Ignore_get());
  public final static XsPortLinesOptions XPLO_DTR_Set = new XsPortLinesOptions("XPLO_DTR_Set", movelladot_pc_sdkJNI.XPLO_DTR_Set_get());
  public final static XsPortLinesOptions XPLO_DTR_Clear = new XsPortLinesOptions("XPLO_DTR_Clear", movelladot_pc_sdkJNI.XPLO_DTR_Clear_get());
  public final static XsPortLinesOptions XPLO_DTR_Ignore = new XsPortLinesOptions("XPLO_DTR_Ignore", movelladot_pc_sdkJNI.XPLO_DTR_Ignore_get());
  public final static XsPortLinesOptions XPLO_All_Set = new XsPortLinesOptions("XPLO_All_Set", movelladot_pc_sdkJNI.XPLO_All_Set_get());
  public final static XsPortLinesOptions XPLO_All_Clear = new XsPortLinesOptions("XPLO_All_Clear", movelladot_pc_sdkJNI.XPLO_All_Clear_get());
  public final static XsPortLinesOptions XPLO_All_Ignore = new XsPortLinesOptions("XPLO_All_Ignore", movelladot_pc_sdkJNI.XPLO_All_Ignore_get());
  public final static XsPortLinesOptions XPLO_RtsCtsFlowControl = new XsPortLinesOptions("XPLO_RtsCtsFlowControl", movelladot_pc_sdkJNI.XPLO_RtsCtsFlowControl_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static XsPortLinesOptions swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + XsPortLinesOptions.class + " with value " + swigValue);
  }

  private XsPortLinesOptions(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private XsPortLinesOptions(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private XsPortLinesOptions(String swigName, XsPortLinesOptions swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static XsPortLinesOptions[] swigValues = { XPLO_Invalid, XPLO_RTS_Set, XPLO_RTS_Clear, XPLO_RTS_Ignore, XPLO_DTR_Set, XPLO_DTR_Clear, XPLO_DTR_Ignore, XPLO_All_Set, XPLO_All_Clear, XPLO_All_Ignore, XPLO_RtsCtsFlowControl };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

