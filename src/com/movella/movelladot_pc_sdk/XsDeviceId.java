
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

public class XsDeviceId {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsDeviceId(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsDeviceId obj) {
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
        movelladot_pc_sdkJNI.delete_XsDeviceId(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public XsDeviceId(String productCode, int hardwareVersion, long productVariant, java.math.BigInteger serialNumber, int subDevice) {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_0(productCode, hardwareVersion, productVariant, serialNumber, subDevice), true);
  }

  public XsDeviceId(String productCode, int hardwareVersion, long productVariant, java.math.BigInteger serialNumber) {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_1(productCode, hardwareVersion, productVariant, serialNumber), true);
  }

  public XsDeviceId(java.math.BigInteger serialNumber) {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_2(serialNumber), true);
  }

  public XsDeviceId() {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_3(), true);
  }

  public XsDeviceId(XsDeviceId parent, int subDevice) {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_4(XsDeviceId.getCPtr(parent), parent, subDevice), true);
  }

  public XsDeviceId(XsDeviceId other) {
    this(movelladot_pc_sdkJNI.new_XsDeviceId__SWIG_5(XsDeviceId.getCPtr(other), other), true);
  }

  public static java.math.BigInteger legacyBit() {
    return movelladot_pc_sdkJNI.XsDeviceId_legacyBit();
  }

  public boolean isLegacyDeviceId() {
    return movelladot_pc_sdkJNI.XsDeviceId_isLegacyDeviceId(swigCPtr, this);
  }

  public java.math.BigInteger toInt() {
    return movelladot_pc_sdkJNI.XsDeviceId_toInt(swigCPtr, this);
  }

  public XsString productCode() {
    return new XsString(movelladot_pc_sdkJNI.XsDeviceId_productCode(swigCPtr, this), true);
  }

  public long productVariant() {
    return movelladot_pc_sdkJNI.XsDeviceId_productVariant(swigCPtr, this);
  }

  public int hardwareVersion() {
    return movelladot_pc_sdkJNI.XsDeviceId_hardwareVersion(swigCPtr, this);
  }

  public int subDevice() {
    return movelladot_pc_sdkJNI.XsDeviceId_subDevice(swigCPtr, this);
  }

  public long legacyDeviceId() {
    return movelladot_pc_sdkJNI.XsDeviceId_legacyDeviceId(swigCPtr, this);
  }

  public boolean isMtiX() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtiX(swigCPtr, this);
  }

  public boolean isMtiX0() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtiX0(swigCPtr, this);
  }

  public boolean isMtiX00() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtiX00(swigCPtr, this);
  }

  public boolean isMtigX00() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtigX00(swigCPtr, this);
  }

  public boolean isMtigX10() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtigX10(swigCPtr, this);
  }

  public boolean isMti3X0() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMti3X0(swigCPtr, this);
  }

  public boolean isMti6X0() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMti6X0(swigCPtr, this);
  }

  public boolean isMti8X0() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMti8X0(swigCPtr, this);
  }

  public boolean isGlove() {
    return movelladot_pc_sdkJNI.XsDeviceId_isGlove(swigCPtr, this);
  }

  public XsHandId side() {
    return XsHandId.swigToEnum(movelladot_pc_sdkJNI.XsDeviceId_side(swigCPtr, this));
  }

  public boolean isDot() {
    return movelladot_pc_sdkJNI.XsDeviceId_isDot(swigCPtr, this);
  }

  public boolean isRugged() {
    return movelladot_pc_sdkJNI.XsDeviceId_isRugged(swigCPtr, this);
  }

  public boolean isMtw() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtw(swigCPtr, this);
  }

  public boolean isMtw2() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtw2(swigCPtr, this);
  }

  public boolean isMtw2Obskur() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtw2Obskur(swigCPtr, this);
  }

  public boolean isMtx() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtx(swigCPtr, this);
  }

  public boolean isMtx2() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtx2(swigCPtr, this);
  }

  public boolean isBodyPack() {
    return movelladot_pc_sdkJNI.XsDeviceId_isBodyPack(swigCPtr, this);
  }

  public boolean isBodyPackV1() {
    return movelladot_pc_sdkJNI.XsDeviceId_isBodyPackV1(swigCPtr, this);
  }

  public boolean isBodyPackV2() {
    return movelladot_pc_sdkJNI.XsDeviceId_isBodyPackV2(swigCPtr, this);
  }

  public boolean isWirelessMaster() {
    return movelladot_pc_sdkJNI.XsDeviceId_isWirelessMaster(swigCPtr, this);
  }

  public boolean isAwindaX() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwindaX(swigCPtr, this);
  }

  public boolean isAwindaXStation() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwindaXStation(swigCPtr, this);
  }

  public boolean isAwindaXDongle() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwindaXDongle(swigCPtr, this);
  }

  public boolean isAwindaXOem() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwindaXOem(swigCPtr, this);
  }

  public boolean isAwinda2() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwinda2(swigCPtr, this);
  }

  public boolean isAwinda2Station() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwinda2Station(swigCPtr, this);
  }

  public boolean isAwinda2Dongle() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwinda2Dongle(swigCPtr, this);
  }

  public boolean isAwinda2Oem() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAwinda2Oem(swigCPtr, this);
  }

  public boolean isSyncStationX() {
    return movelladot_pc_sdkJNI.XsDeviceId_isSyncStationX(swigCPtr, this);
  }

  public boolean isSyncStation2() {
    return movelladot_pc_sdkJNI.XsDeviceId_isSyncStation2(swigCPtr, this);
  }

  public boolean isHilDevice() {
    return movelladot_pc_sdkJNI.XsDeviceId_isHilDevice(swigCPtr, this);
  }

  public boolean isImu() {
    return movelladot_pc_sdkJNI.XsDeviceId_isImu(swigCPtr, this);
  }

  public boolean isVru() {
    return movelladot_pc_sdkJNI.XsDeviceId_isVru(swigCPtr, this);
  }

  public boolean isAhrs() {
    return movelladot_pc_sdkJNI.XsDeviceId_isAhrs(swigCPtr, this);
  }

  public boolean isGnss() {
    return movelladot_pc_sdkJNI.XsDeviceId_isGnss(swigCPtr, this);
  }

  public boolean isRtk() {
    return movelladot_pc_sdkJNI.XsDeviceId_isRtk(swigCPtr, this);
  }

  public boolean hasInternalGnss() {
    return movelladot_pc_sdkJNI.XsDeviceId_hasInternalGnss(swigCPtr, this);
  }

  public boolean isContainerDevice() {
    return movelladot_pc_sdkJNI.XsDeviceId_isContainerDevice(swigCPtr, this);
  }

  public boolean isMt() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMt(swigCPtr, this);
  }

  public boolean isMti() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMti(swigCPtr, this);
  }

  public boolean isMtig() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtig(swigCPtr, this);
  }

  public boolean isMtMark4() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtMark4(swigCPtr, this);
  }

  public boolean isMtMark5() {
    return movelladot_pc_sdkJNI.XsDeviceId_isMtMark5(swigCPtr, this);
  }

  public XsString toXsString() {
    return new XsString(movelladot_pc_sdkJNI.XsDeviceId_toXsString(swigCPtr, this), true);
  }

  public void fromString(XsString str) {
    movelladot_pc_sdkJNI.XsDeviceId_fromString(swigCPtr, this, XsString.getCPtr(str), str);
  }

  public XsString toDeviceTypeString(boolean makeType) {
    return new XsString(movelladot_pc_sdkJNI.XsDeviceId_toDeviceTypeString__SWIG_0(swigCPtr, this, makeType), true);
  }

  public XsString toDeviceTypeString() {
    return new XsString(movelladot_pc_sdkJNI.XsDeviceId_toDeviceTypeString__SWIG_1(swigCPtr, this), true);
  }

  public void fromDeviceTypeString(XsString str) {
    movelladot_pc_sdkJNI.XsDeviceId_fromDeviceTypeString(swigCPtr, this, XsString.getCPtr(str), str);
  }

  public boolean isValid() {
    return movelladot_pc_sdkJNI.XsDeviceId_isValid(swigCPtr, this);
  }

  public boolean contains(XsDeviceId other) {
    return movelladot_pc_sdkJNI.XsDeviceId_contains(swigCPtr, this, XsDeviceId.getCPtr(other), other);
  }

  public boolean isType() {
    return movelladot_pc_sdkJNI.XsDeviceId_isType(swigCPtr, this);
  }

  public XsString typeName() {
    return new XsString(movelladot_pc_sdkJNI.XsDeviceId_typeName(swigCPtr, this), true);
  }

  public XsDeviceId type() {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDeviceId_type(swigCPtr, this), true);
  }

  public XsDeviceId deviceType(boolean detailed) {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDeviceId_deviceType__SWIG_0(swigCPtr, this, detailed), true);
  }

  public XsDeviceId deviceType() {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDeviceId_deviceType__SWIG_1(swigCPtr, this), true);
  }

  public XsDeviceId deviceTypeMask(boolean detailed) {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDeviceId_deviceTypeMask__SWIG_0(swigCPtr, this, detailed), true);
  }

  public XsDeviceId deviceTypeMask() {
    return new XsDeviceId(movelladot_pc_sdkJNI.XsDeviceId_deviceTypeMask__SWIG_1(swigCPtr, this), true);
  }

  public int basePart() {
    return movelladot_pc_sdkJNI.XsDeviceId_basePart(swigCPtr, this);
  }

}
