package com.skiply.skiply.service;

import com.skiply.skiply.Exception.ReceiptNotFoundException;
import com.skiply.skiply.Exception.StudentNotFoundException;
import com.skiply.skiply.entity.Receipt;
import com.skiply.skiply.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Service
public class FeePaymentServiceImpl implements FeePaymentService{

    @Autowired
    ReceiptRepository repository;
    @Override
    @Transactional
    public Receipt payFee(Receipt receipt) {
        try {
            return repository.save(receipt);
        }catch (DataIntegrityViolationException exception){
            throw new StudentNotFoundException("No Student found for the id: " + receipt.getStudent().getId());
        }

    }

    @Override
    public Receipt viewReceipt(Integer id) {

        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException exception){
            throw new ReceiptNotFoundException("No Receipt found for the id: " + id);
        }
    }
}
