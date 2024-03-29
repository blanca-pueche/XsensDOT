
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

public class XsTriggerIndicationData {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsTriggerIndicationData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsTriggerIndicationData obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        movelladot_pc_sdkJNI.delete_XsTriggerIndicationData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setM_line(short value) {
    movelladot_pc_sdkJNI.XsTriggerIndicationData_m_line_set(swigCPtr, this, value);
  }

  public short getM_line() {
    return movelladot_pc_sdkJNI.XsTriggerIndicationData_m_line_get(swigCPtr, this);
  }

  public void setM_polarity(short value) {
    movelladot_pc_sdkJNI.XsTriggerIndicationData_m_polarity_set(swigCPtr, this, value);
  }

  public short getM_polarity() {
    return movelladot_pc_sdkJNI.XsTriggerIndicationData_m_polarity_get(swigCPtr, this);
  }

  public void setM_timestamp(long value) {
    movelladot_pc_sdkJNI.XsTriggerIndicationData_m_timestamp_set(swigCPtr, this, value);
  }

  public long getM_timestamp() {
    return movelladot_pc_sdkJNI.XsTriggerIndicationData_m_timestamp_get(swigCPtr, this);
  }

  public void setM_frameNumber(int value) {
    movelladot_pc_sdkJNI.XsTriggerIndicationData_m_frameNumber_set(swigCPtr, this, value);
  }

  public int getM_frameNumber() {
    return movelladot_pc_sdkJNI.XsTriggerIndicationData_m_frameNumber_get(swigCPtr, this);
  }

  public XsTriggerIndicationData(short line, short polarity, long timestamp, int frameNumber) {
    this(movelladot_pc_sdkJNI.new_XsTriggerIndicationData__SWIG_0(line, polarity, timestamp, frameNumber), true);
  }

  public XsTriggerIndicationData(short line, short polarity, long timestamp) {
    this(movelladot_pc_sdkJNI.new_XsTriggerIndicationData__SWIG_1(line, polarity, timestamp), true);
  }

  public XsTriggerIndicationData(short line, short polarity) {
    this(movelladot_pc_sdkJNI.new_XsTriggerIndicationData__SWIG_2(line, polarity), true);
  }

  public XsTriggerIndicationData(short line) {
    this(movelladot_pc_sdkJNI.new_XsTriggerIndicationData__SWIG_3(line), true);
  }

  public XsTriggerIndicationData() {
    this(movelladot_pc_sdkJNI.new_XsTriggerIndicationData__SWIG_4(), true);
  }

  public void clear() {
    movelladot_pc_sdkJNI.XsTriggerIndicationData_clear(swigCPtr, this);
  }

  public boolean valid() {
    return movelladot_pc_sdkJNI.XsTriggerIndicationData_valid(swigCPtr, this);
  }

}
