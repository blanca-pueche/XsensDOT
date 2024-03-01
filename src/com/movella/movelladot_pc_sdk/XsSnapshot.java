
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

public class XsSnapshot {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsSnapshot(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsSnapshot obj) {
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
        movelladot_pc_sdkJNI.delete_XsSnapshot(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setM_deviceId(XsDeviceId value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_deviceId_set(swigCPtr, this, XsDeviceId.getCPtr(value), value);
  }

  public XsDeviceId getM_deviceId() {
    long cPtr = movelladot_pc_sdkJNI.XsSnapshot_m_deviceId_get(swigCPtr, this);
    return (cPtr == 0) ? null : new XsDeviceId(cPtr, false);
  }

  public void setM_frameNumber(long value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_frameNumber_set(swigCPtr, this, value);
  }

  public long getM_frameNumber() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_frameNumber_get(swigCPtr, this);
  }

  public void setM_timestamp(java.math.BigInteger value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_timestamp_set(swigCPtr, this, value);
  }

  public java.math.BigInteger getM_timestamp() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_timestamp_get(swigCPtr, this);
  }

  public void setM_iQ(SWIGTYPE_p_int value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_iQ_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getM_iQ() {
    long cPtr = movelladot_pc_sdkJNI.XsSnapshot_m_iQ_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setM_iV(SWIGTYPE_p_long_long value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_iV_set(swigCPtr, this, SWIGTYPE_p_long_long.getCPtr(value));
  }

  public SWIGTYPE_p_long_long getM_iV() {
    long cPtr = movelladot_pc_sdkJNI.XsSnapshot_m_iV_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_long_long(cPtr, false);
  }

  public void setM_mag(SWIGTYPE_p_int value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_mag_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(value));
  }

  public SWIGTYPE_p_int getM_mag() {
    long cPtr = movelladot_pc_sdkJNI.XsSnapshot_m_mag_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public void setM_baro(int value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_baro_set(swigCPtr, this, value);
  }

  public int getM_baro() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_baro_get(swigCPtr, this);
  }

  public void setM_status(int value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_status_set(swigCPtr, this, value);
  }

  public int getM_status() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_status_get(swigCPtr, this);
  }

  public void setM_accClippingCounter(short value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_accClippingCounter_set(swigCPtr, this, value);
  }

  public short getM_accClippingCounter() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_accClippingCounter_get(swigCPtr, this);
  }

  public void setM_gyrClippingCounter(short value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_gyrClippingCounter_set(swigCPtr, this, value);
  }

  public short getM_gyrClippingCounter() {
    return movelladot_pc_sdkJNI.XsSnapshot_m_gyrClippingCounter_get(swigCPtr, this);
  }

  public void setM_type(SnapshotType value) {
    movelladot_pc_sdkJNI.XsSnapshot_m_type_set(swigCPtr, this, value.swigValue());
  }

  public SnapshotType getM_type() {
    return SnapshotType.swigToEnum(movelladot_pc_sdkJNI.XsSnapshot_m_type_get(swigCPtr, this));
  }

  public XsSnapshot() {
    this(movelladot_pc_sdkJNI.new_XsSnapshot(), true);
  }

}
