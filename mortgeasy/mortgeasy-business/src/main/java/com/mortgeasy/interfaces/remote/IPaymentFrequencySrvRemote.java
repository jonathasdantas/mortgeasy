package com.mortgeasy.interfaces.remote;

import javax.ejb.Remote;

import com.mortgeasy.common.IBaseSrvRemote;
import com.mortgeasy.entity.PaymentFrequency;

@Remote
public interface IPaymentFrequencySrvRemote extends IBaseSrvRemote<PaymentFrequency, Integer> {

}
