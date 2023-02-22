package com.example.findjobbe.service;

import com.example.findjobbe.model.Notify;

import java.util.List;

public interface INotifyService extends ICoreCrud<Notify, Long> {
	List<Notify> findAllNotifyOfCandidate(Long id);
	List<Notify> findAllNotifyOfCompany(Long id);
	Integer countUnreadCandidateNotify(Long id);
	Integer countUnreadCompanyNotify(Long id);
	void deleteNotifyByJob(Long id);

}
