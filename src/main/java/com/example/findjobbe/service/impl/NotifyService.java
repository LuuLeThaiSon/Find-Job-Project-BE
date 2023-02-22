package com.example.findjobbe.service.impl;

import com.example.findjobbe.model.Notify;
import com.example.findjobbe.model.NotifyType;
import com.example.findjobbe.repository.NotifyRepository;
import com.example.findjobbe.repository.NotifyTypeRepository;
import com.example.findjobbe.service.INotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class NotifyService implements INotifyService {
	@Autowired
	private NotifyRepository notifyRepository;
	@Autowired
	NotifyTypeRepository notifyTypeRepository;
	@Override
	public List<Notify> findAll() {
		return notifyRepository.findAll();
	}

	@Override
	public Optional<Notify> findOne(Long id) {
		return notifyRepository.findById(id);
	}

	@Override
	public Notify save(Notify notify) {
		return notifyRepository.save(notify);
	}

	@Override
	public void delete(Long id) {
		notifyRepository.deleteById(id);
	}

	@Override
	public List<Notify> findAllNotifyOfCandidate(Long id) {
		return notifyRepository.findAllNotifyOfCandidate(id);
	}

	@Override
	public List<Notify> findAllNotifyOfCompany(Long id) {
		return notifyRepository.findAllNotifyOfCompany(id);
	}

	@Override
	public Integer countUnreadCandidateNotify(Long id) {
		return notifyRepository.countUnreadCandidateNotify(id);
	}

	@Override
	public Integer countUnreadCompanyNotify(Long id) {
		return notifyRepository.countUnreadCompanyNotify(id);
	}

	@Override
	@Transactional
	public void deleteNotifyByJob(Long id) {
		notifyRepository.deleteNotifyByJob(id);
	}

	public List<NotifyType> findAllType() {
		return notifyTypeRepository.findAll();
	}
}
