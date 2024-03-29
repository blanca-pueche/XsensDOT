
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

public class XsFilterProfileArrayImpl {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected XsFilterProfileArrayImpl(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XsFilterProfileArrayImpl obj) {
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
        movelladot_pc_sdkJNI.delete_XsFilterProfileArrayImpl(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public XsFilterProfileArrayImpl(long count, XsFilterProfile src) {
    this(movelladot_pc_sdkJNI.new_XsFilterProfileArrayImpl__SWIG_0(count, XsFilterProfile.getCPtr(src), src), true);
  }

  public XsFilterProfileArrayImpl(long count) {
    this(movelladot_pc_sdkJNI.new_XsFilterProfileArrayImpl__SWIG_1(count), true);
  }

  public XsFilterProfileArrayImpl() {
    this(movelladot_pc_sdkJNI.new_XsFilterProfileArrayImpl__SWIG_2(), true);
  }

  public XsFilterProfileArrayImpl(XsFilterProfileArrayImpl other) {
    this(movelladot_pc_sdkJNI.new_XsFilterProfileArrayImpl__SWIG_3(XsFilterProfileArrayImpl.getCPtr(other), other), true);
  }

  public XsFilterProfileArrayImpl(XsFilterProfile ref, long sz, XsDataFlags flags) {
    this(movelladot_pc_sdkJNI.new_XsFilterProfileArrayImpl__SWIG_4(XsFilterProfile.getCPtr(ref), ref, sz, flags.swigValue()), true);
  }

  public void clear() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_clear(swigCPtr, this);
  }

  public void reserve(long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_reserve(swigCPtr, this, count);
  }

  public long reserved() {
    return movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_reserved(swigCPtr, this);
  }

  public XsArrayDescriptor descriptor() {
    return new XsArrayDescriptor(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_descriptor(swigCPtr, this), false);
  }

  public XsFilterProfile value(long index) {
    return new XsFilterProfile(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_value(swigCPtr, this, index), true);
  }

  public XsFilterProfile first() {
    return new XsFilterProfile(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_first(swigCPtr, this), true);
  }

  public XsFilterProfile last() {
    return new XsFilterProfile(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_last(swigCPtr, this), true);
  }

  public XsFilterProfile at(long index) {
    return new XsFilterProfile(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_at__SWIG_0(swigCPtr, this, index), false);
  }

  public void insert(XsFilterProfile item, long index) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_insert__SWIG_0(swigCPtr, this, XsFilterProfile.getCPtr(item), item, index);
  }

  public void insert(XsFilterProfile items, long index, long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_insert__SWIG_1(swigCPtr, this, XsFilterProfile.getCPtr(items), items, index, count);
  }

  public void push_back(XsFilterProfile item) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_push_back(swigCPtr, this, XsFilterProfile.getCPtr(item), item);
  }

  public void pop_back(long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_pop_back__SWIG_0(swigCPtr, this, count);
  }

  public void pop_back() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_pop_back__SWIG_1(swigCPtr, this);
  }

  public void push_front(XsFilterProfile item) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_push_front(swigCPtr, this, XsFilterProfile.getCPtr(item), item);
  }

  public void pop_front(long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_pop_front__SWIG_0(swigCPtr, this, count);
  }

  public void pop_front() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_pop_front__SWIG_1(swigCPtr, this);
  }

  public long size() {
    return movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_size(swigCPtr, this);
  }

  public void erase(long index, long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_erase__SWIG_0(swigCPtr, this, index, count);
  }

  public void erase(long index) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_erase__SWIG_1(swigCPtr, this, index);
  }

  public void assign(long count, XsFilterProfile src) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_assign(swigCPtr, this, count, XsFilterProfile.getCPtr(src), src);
  }

  public void resize(long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_resize(swigCPtr, this, count);
  }

  public void setSize(long count) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_setSize(swigCPtr, this, count);
  }

  public void append(XsFilterProfileArrayImpl other) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_append(swigCPtr, this, XsFilterProfileArrayImpl.getCPtr(other), other);
  }

  public boolean empty() {
    return movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_empty(swigCPtr, this);
  }

  public boolean badAlloc() {
    return movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_badAlloc(swigCPtr, this);
  }

  public void swap(XsFilterProfileArrayImpl other) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_swap__SWIG_0(swigCPtr, this, XsFilterProfileArrayImpl.getCPtr(other), other);
  }

  public void swap(long a, long b) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_swap__SWIG_1(swigCPtr, this, a, b);
  }

  public SWIGTYPE_p_ptrdiff_t find(XsFilterProfile needle) {
    return new SWIGTYPE_p_ptrdiff_t(movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_find(swigCPtr, this, XsFilterProfile.getCPtr(needle), needle), true);
  }

  public boolean contains(XsFilterProfile needle) {
    return movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_contains(swigCPtr, this, XsFilterProfile.getCPtr(needle), needle);
  }

  public void removeDuplicates() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_removeDuplicates(swigCPtr, this);
  }

  public void removeDuplicatesPredicate(SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int predicate) {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_removeDuplicatesPredicate(swigCPtr, this, SWIGTYPE_p_f_p_q_const__void_p_q_const__void__int.getCPtr(predicate));
  }

  public void sort() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_sort(swigCPtr, this);
  }

  public void reverse() {
    movelladot_pc_sdkJNI.XsFilterProfileArrayImpl_reverse(swigCPtr, this);
  }

}
