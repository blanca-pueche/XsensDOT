
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

public class XsPortInfoArrayImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsPortInfoArrayImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsPortInfoArrayImpl obj) {
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
        movelladot_pc_sdkJNI.delete_XsPortInfoArrayImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public XsPortInfoArrayImpl(long count, XsPortInfo src) {
    this(movelladot_pc_sdkJNI.new_XsPortInfoArrayImpl__SWIG_0(count, XsPortInfo.getCPtr(src), src), true);
  }

  public XsPortInfoArrayImpl(long count) {
    this(movelladot_pc_sdkJNI.new_XsPortInfoArrayImpl__SWIG_1(count), true);
  }

  public XsPortInfoArrayImpl() {
    this(movelladot_pc_sdkJNI.new_XsPortInfoArrayImpl__SWIG_2(), true);
  }

  public XsPortInfoArrayImpl(XsPortInfoArrayImpl other) {
    this(movelladot_pc_sdkJNI.new_XsPortInfoArrayImpl__SWIG_3(XsPortInfoArrayImpl.getCPtr(other), other), true);
  }

  public XsPortInfoArrayImpl(XsPortInfo ref, long sz, XsDataFlags flags) {
    this(movelladot_pc_sdkJNI.new_XsPortInfoArrayImpl__SWIG_4(XsPortInfo.getCPtr(ref), ref, sz, flags.swigValue()), true);
  }

  public void clear() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_clear(swigCPtr, this);
  }

  public void reserve(long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_reserve(swigCPtr, this, count);
  }

  public long reserved() {
    return movelladot_pc_sdkJNI.XsPortInfoArrayImpl_reserved(swigCPtr, this);
  }

  public XsArrayDescriptor descriptor() {
    return new XsArrayDescriptor(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_descriptor(swigCPtr, this), false);
  }

  public XsPortInfo value(long index) {
    return new XsPortInfo(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_value(swigCPtr, this, index), true);
  }

  public XsPortInfo first() {
    return new XsPortInfo(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_first(swigCPtr, this), true);
  }

  public XsPortInfo last() {
    return new XsPortInfo(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_last(swigCPtr, this), true);
  }

  public XsPortInfo at(long index) {
    return new XsPortInfo(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_at__SWIG_0(swigCPtr, this, index), false);
  }

  public void insert(XsPortInfo item, long index) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_insert__SWIG_0(swigCPtr, this, XsPortInfo.getCPtr(item), item, index);
  }

  public void insert(XsPortInfo items, long index, long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_insert__SWIG_1(swigCPtr, this, XsPortInfo.getCPtr(items), items, index, count);
  }

  public void push_back(XsPortInfo item) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_push_back(swigCPtr, this, XsPortInfo.getCPtr(item), item);
  }

  public void pop_back(long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_pop_back__SWIG_0(swigCPtr, this, count);
  }

  public void pop_back() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_pop_back__SWIG_1(swigCPtr, this);
  }

  public void push_front(XsPortInfo item) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_push_front(swigCPtr, this, XsPortInfo.getCPtr(item), item);
  }

  public void pop_front(long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_pop_front__SWIG_0(swigCPtr, this, count);
  }

  public void pop_front() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_pop_front__SWIG_1(swigCPtr, this);
  }

  public long size() {
    return movelladot_pc_sdkJNI.XsPortInfoArrayImpl_size(swigCPtr, this);
  }

  public void erase(long index, long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_erase__SWIG_0(swigCPtr, this, index, count);
  }

  public void erase(long index) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_erase__SWIG_1(swigCPtr, this, index);
  }

  public void assign(long count, XsPortInfo src) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_assign(swigCPtr, this, count, XsPortInfo.getCPtr(src), src);
  }

  public void resize(long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_resize(swigCPtr, this, count);
  }

  public void setSize(long count) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_setSize(swigCPtr, this, count);
  }

  public void append(XsPortInfoArrayImpl other) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_append(swigCPtr, this, XsPortInfoArrayImpl.getCPtr(other), other);
  }

  public boolean empty() {
    return movelladot_pc_sdkJNI.XsPortInfoArrayImpl_empty(swigCPtr, this);
  }

  public boolean badAlloc() {
    return movelladot_pc_sdkJNI.XsPortInfoArrayImpl_badAlloc(swigCPtr, this);
  }

  public void swap(XsPortInfoArrayImpl other) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_swap__SWIG_0(swigCPtr, this, XsPortInfoArrayImpl.getCPtr(other), other);
  }

  public void swap(long a, long b) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_swap__SWIG_1(swigCPtr, this, a, b);
  }

  public SWIGTYPE_p_ptrdiff_t find(XsPortInfo needle) {
    return new SWIGTYPE_p_ptrdiff_t(movelladot_pc_sdkJNI.XsPortInfoArrayImpl_find(swigCPtr, this, XsPortInfo.getCPtr(needle), needle), true);
  }

  public boolean contains(XsPortInfo needle) {
    return movelladot_pc_sdkJNI.XsPortInfoArrayImpl_contains(swigCPtr, this, XsPortInfo.getCPtr(needle), needle);
  }

  public void removeDuplicates() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_removeDuplicates(swigCPtr, this);
  }

  public void removeDuplicatesPredicate(SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int predicate) {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_removeDuplicatesPredicate(swigCPtr, this, SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int.getCPtr(predicate));
  }

  public void sort() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_sort(swigCPtr, this);
  }

  public void reverse() {
    movelladot_pc_sdkJNI.XsPortInfoArrayImpl_reverse(swigCPtr, this);
  }

}
