
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

public final class XsResetMethod {
  public final static XsResetMethod XRM_StoreAlignmentMatrix = new XsResetMethod("XRM_StoreAlignmentMatrix", movelladot_pc_sdkJNI.XRM_StoreAlignmentMatrix_get());
  public final static XsResetMethod XRM_Heading = new XsResetMethod("XRM_Heading", movelladot_pc_sdkJNI.XRM_Heading_get());
  public final static XsResetMethod XRM_Object = new XsResetMethod("XRM_Object", movelladot_pc_sdkJNI.XRM_Object_get());
  public final static XsResetMethod XRM_Inclination = new XsResetMethod("XRM_Inclination", movelladot_pc_sdkJNI.XRM_Inclination_get());
  public final static XsResetMethod XRM_Alignment = new XsResetMethod("XRM_Alignment", movelladot_pc_sdkJNI.XRM_Alignment_get());
  public final static XsResetMethod XRM_Global = new XsResetMethod("XRM_Global", movelladot_pc_sdkJNI.XRM_Global_get());
  public final static XsResetMethod XRM_DefaultHeading = new XsResetMethod("XRM_DefaultHeading", movelladot_pc_sdkJNI.XRM_DefaultHeading_get());
  public final static XsResetMethod XRM_DefaultInclination = new XsResetMethod("XRM_DefaultInclination", movelladot_pc_sdkJNI.XRM_DefaultInclination_get());
  public final static XsResetMethod XRM_DefaultAlignment = new XsResetMethod("XRM_DefaultAlignment", movelladot_pc_sdkJNI.XRM_DefaultAlignment_get());
  public final static XsResetMethod XRM_None = new XsResetMethod("XRM_None");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static XsResetMethod swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + XsResetMethod.class + " with value " + swigValue);
  }

  private XsResetMethod(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private XsResetMethod(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private XsResetMethod(String swigName, XsResetMethod swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static XsResetMethod[] swigValues = { XRM_StoreAlignmentMatrix, XRM_Heading, XRM_Object, XRM_Inclination, XRM_Alignment, XRM_Global, XRM_DefaultHeading, XRM_DefaultInclination, XRM_DefaultAlignment, XRM_None };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

