package com.mortgeasy.interfaces.remote;

import javax.ejb.Remote;

import com.mortgeasy.common.IBaseSrvRemote;
import com.mortgeasy.entity.Frequency;

@Remote
public interface IFrequencySrvRemote extends IBaseSrvRemote<Frequency, Integer> {

}
