package com.mortgeasy.interfaces.remote;

import javax.ejb.Remote;

import com.mortgeasy.common.IBaseSrvRemote;
import com.mortgeasy.entity.MortgageProposal;

@Remote
public interface IMortgageProposalSrvRemote extends IBaseSrvRemote<MortgageProposal, Integer> {

}
