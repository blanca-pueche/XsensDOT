
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

public class XsVector3 extends XsVector {
  private transient long swigCPtr;

  protected XsVector3(long cPtr, boolean cMemoryOwn) {
    super(movelladot_pc_sdkJNI.XsVector3_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsVector3 obj) {
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
        movelladot_pc_sdkJNI.delete_XsVector3(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public XsVector3() {
    this(movelladot_pc_sdkJNI.new_XsVector3__SWIG_0(), true);
  }

  public XsVector3(XsVector3 other) {
    this(movelladot_pc_sdkJNI.new_XsVector3__SWIG_1(XsVector3.getCPtr(other), other), true);
  }

  public XsVector3(XsVector other) {
    this(movelladot_pc_sdkJNI.new_XsVector3__SWIG_2(XsVector.getCPtr(other), other), true);
  }

  public XsVector3(double x, double y, double z) {
    this(movelladot_pc_sdkJNI.new_XsVector3__SWIG_3(x, y, z), true);
  }

  public static XsVector3 zero3() {
    return new XsVector3(movelladot_pc_sdkJNI.XsVector3_zero3(), false);
  }

  public void assign(long sz, SWIGTYPE_p_double src) {
    movelladot_pc_sdkJNI.XsVector3_assign__SWIG_0_0(swigCPtr, this, sz, SWIGTYPE_p_double.getCPtr(src));
  }

  public void assign(double x, double y, double z) {
    movelladot_pc_sdkJNI.XsVector3_assign__SWIG_1(swigCPtr, this, x, y, z);
  }

}
