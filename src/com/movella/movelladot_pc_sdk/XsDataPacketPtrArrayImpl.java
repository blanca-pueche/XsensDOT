
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

public class XsDataPacketPtrArrayImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsDataPacketPtrArrayImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsDataPacketPtrArrayImpl obj) {
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
        movelladot_pc_sdkJNI.delete_XsDataPacketPtrArrayImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public XsDataPacketPtrArrayImpl(long count, SWIGTYPE_p_p_XsDataPacket src) {
    this(movelladot_pc_sdkJNI.new_XsDataPacketPtrArrayImpl__SWIG_0(count, SWIGTYPE_p_p_XsDataPacket.getCPtr(src)), true);
  }

  public XsDataPacketPtrArrayImpl(long count) {
    this(movelladot_pc_sdkJNI.new_XsDataPacketPtrArrayImpl__SWIG_1(count), true);
  }

  public XsDataPacketPtrArrayImpl() {
    this(movelladot_pc_sdkJNI.new_XsDataPacketPtrArrayImpl__SWIG_2(), true);
  }

  public XsDataPacketPtrArrayImpl(XsDataPacketPtrArrayImpl other) {
    this(movelladot_pc_sdkJNI.new_XsDataPacketPtrArrayImpl__SWIG_3(XsDataPacketPtrArrayImpl.getCPtr(other), other), true);
  }

  public XsDataPacketPtrArrayImpl(SWIGTYPE_p_p_XsDataPacket ref, long sz, XsDataFlags flags) {
    this(movelladot_pc_sdkJNI.new_XsDataPacketPtrArrayImpl__SWIG_4(SWIGTYPE_p_p_XsDataPacket.getCPtr(ref), sz, flags.swigValue()), true);
  }

  public void clear() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_clear(swigCPtr, this);
  }

  public void reserve(long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_reserve(swigCPtr, this, count);
  }

  public long reserved() {
    return movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_reserved(swigCPtr, this);
  }

  public XsArrayDescriptor descriptor() {
    return new XsArrayDescriptor(movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_descriptor(swigCPtr, this), false);
  }

  public XsDataPacket value(long index) {
    long cPtr = movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_value(swigCPtr, this, index);
    return (cPtr == 0) ? null : new XsDataPacket(cPtr, false);
  }

  public XsDataPacket first() {
    long cPtr = movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_first(swigCPtr, this);
    return (cPtr == 0) ? null : new XsDataPacket(cPtr, false);
  }

  public XsDataPacket last() {
    long cPtr = movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_last(swigCPtr, this);
    return (cPtr == 0) ? null : new XsDataPacket(cPtr, false);
  }

  public XsDataPacket at(long index) {
    long cPtr = movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_at__SWIG_0(swigCPtr, this, index);
    return (cPtr == 0) ? null : new XsDataPacket(cPtr, false);
  }

  public void insert(XsDataPacket item, long index) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_insert__SWIG_0(swigCPtr, this, XsDataPacket.getCPtr(item), item, index);
  }

  public void insert(SWIGTYPE_p_p_XsDataPacket items, long index, long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_insert__SWIG_1(swigCPtr, this, SWIGTYPE_p_p_XsDataPacket.getCPtr(items), index, count);
  }

  public void push_back(XsDataPacket item) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_push_back(swigCPtr, this, XsDataPacket.getCPtr(item), item);
  }

  public void pop_back(long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_pop_back__SWIG_0(swigCPtr, this, count);
  }

  public void pop_back() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_pop_back__SWIG_1(swigCPtr, this);
  }

  public void push_front(XsDataPacket item) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_push_front(swigCPtr, this, XsDataPacket.getCPtr(item), item);
  }

  public void pop_front(long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_pop_front__SWIG_0(swigCPtr, this, count);
  }

  public void pop_front() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_pop_front__SWIG_1(swigCPtr, this);
  }

  public long size() {
    return movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_size(swigCPtr, this);
  }

  public void erase(long index, long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_erase__SWIG_0(swigCPtr, this, index, count);
  }

  public void erase(long index) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_erase__SWIG_1(swigCPtr, this, index);
  }

  public void assign(long count, SWIGTYPE_p_p_XsDataPacket src) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_assign(swigCPtr, this, count, SWIGTYPE_p_p_XsDataPacket.getCPtr(src));
  }

  public void resize(long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_resize(swigCPtr, this, count);
  }

  public void setSize(long count) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_setSize(swigCPtr, this, count);
  }

  public void append(XsDataPacketPtrArrayImpl other) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_append(swigCPtr, this, XsDataPacketPtrArrayImpl.getCPtr(other), other);
  }

  public boolean empty() {
    return movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_empty(swigCPtr, this);
  }

  public boolean badAlloc() {
    return movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_badAlloc(swigCPtr, this);
  }

  public void swap(XsDataPacketPtrArrayImpl other) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_swap__SWIG_0(swigCPtr, this, XsDataPacketPtrArrayImpl.getCPtr(other), other);
  }

  public void swap(long a, long b) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_swap__SWIG_1(swigCPtr, this, a, b);
  }

  public SWIGTYPE_p_ptrdiff_t find(XsDataPacket needle) {
    return new SWIGTYPE_p_ptrdiff_t(movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_find(swigCPtr, this, XsDataPacket.getCPtr(needle), needle), true);
  }

  public boolean contains(XsDataPacket needle) {
    return movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_contains(swigCPtr, this, XsDataPacket.getCPtr(needle), needle);
  }

  public void removeDuplicates() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_removeDuplicates(swigCPtr, this);
  }

  public void removeDuplicatesPredicate(SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int predicate) {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_removeDuplicatesPredicate(swigCPtr, this, SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int.getCPtr(predicate));
  }

  public void sort() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_sort(swigCPtr, this);
  }

  public void reverse() {
    movelladot_pc_sdkJNI.XsDataPacketPtrArrayImpl_reverse(swigCPtr, this);
  }

}
